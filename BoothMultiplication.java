import java.util.Arrays;

public class BoothMultiplication {

    // Function to perform binary Addition
    public static String addition(String a, String b) {
        int n = a.length();
        int m = b.length();
        int l = Math.max(n, m);
        a = String.format("%1$" + l + "s", a).replace(' ', '0');
        b = String.format("%1$" + l + "s", b).replace(' ', '0');
        int carry = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = l - 1; i >= 0; i--) {
            int tem = carry + Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i));
            if (tem < 2) {
                ans.insert(0, tem);
                carry = 0;
            } else if (tem == 2) {
                ans.insert(0, 0);
                carry = 1;
            } else if (tem == 3) {
                ans.insert(0, 1);
                carry = 1;
            }
        }

        ans.insert(0, "0".repeat(l - ans.length()));
        return ans.toString();
    }

    // Function to perform 1's Complement
    public static String onesComplement(String num) {
        StringBuilder comp = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (c == '0') {
                comp.append('1');
            } else {
                comp.append('0');
            }
        }
        return comp.toString();
    }

    // Function to perform 2's Complement
    public static String twosComplement(String num) {
        String oneCom = onesComplement(num);
        return addition(oneCom, "1");
    }

    // Function to Convert number to binary
    public static String setBin(int num) {
        StringBuilder binary = new StringBuilder();
        int decimal = Math.abs(num);
        while (decimal > 0) {
            if (decimal % 2 == 1) {
                binary.insert(0, '1');
            } else {
                binary.insert(0, '0');
            }
            decimal /= 2;
        }
        return binary.toString();
    }

    // Function to set Binary as signed (by 2's complement)
    public static String setSigned(int d, String num) {
        if (d >= 0) {
            return "0" + num;
        } else {
            return "1" + twosComplement(num);
        }
    }

    // Main function to perform binary multiplication using Booth's algorithm
    public static void boothMultiplication(int multiplicand, int multiplier) {
        StringBuilder output = new StringBuilder();

        String n1 = setBin(multiplicand);
        String n2 = setBin(multiplier);
        int m = Math.max(n1.length(), n2.length());
        n1 = String.format("%1$" + m + "s", n1).replace(' ', '0');
        n2 = String.format("%1$" + m + "s", n2).replace(' ', '0');

        String br = setSigned(multiplicand, n1);
        String qr = setSigned(multiplier, n2);
        String br1 = twosComplement(br);

        output.append("br                        : ").append(br).append("\n");
        output.append("br' ( in 2's complement ) : ").append(br1).append("\n");
        output.append("qr                        : ").append(qr).append("\n\n");

        String ac = "0".repeat(m + 1);
        char qn1 = '0';
        char qn;

        output.append("Qn\tQn+1\t\tAC\tQR\tQn+1\tSC\n");
        output.append("----------------------------------------------------\n");
        output.append("\t\tInitial\t").append(ac).append("\t").append(qr).append("\t").append(qn1).append("\t").append(m + 1).append("\n\n");

        for (int i = 0; i <= m; i++) {
            qn = qr.charAt(qr.length() - 1);
            int a = 0;

            if (qn == '1' && qn1 == '0') {
                a = 1;
                ac = addition(ac, br1);
                output.append(qn).append("\t").append(qn1).append("\tSub BR\t").append(br1).append("\n");
                output.append("\t\t\t").append(ac).append("\t").append(qr).append("\n\n");
            } else if (qn == '0' && qn1 == '1') {
                a = 1;
                ac = addition(ac, br);
                output.append(qn).append("\t").append(qn1).append("\tAdd BR\t").append(br).append("\n");
                output.append("\t\t\t").append(ac).append("\t").append(qr).append("\n\n");
            }

            qn1 = qr.charAt(qr.length() - 1);
            qr = ac.charAt(ac.length() - 1) + qr.substring(0, m);
            ac = ac.charAt(0) + ac.substring(0, m);

            if (a == 1) {
                output.append("\t\tAshr\t").append(ac).append("\t").append(qr).append("\t").append(qn1).append("\t").append(m - i).append("\n");
            } else {
                output.append(qn).append("\t").append(qn1).append("\tAshr\t").append(ac).append("\t").append(qr).append("\t").append(qn1).append("\t").append(m - i).append("\n");
            }
        }

        String ans = ac + qr;
        if (ans.charAt(0) == '1') {
            output.append("Result : ").append(ans).append("\n");
            output.append("Result in decimal: -").append(Integer.parseInt(twosComplement(ans), 2)).append("\n");
        } else {
            output.append("Result : ").append(ans).append("\n");
            output.append("Result in decimal: ").append(Integer.parseInt(ans, 2)).append("\n");
        }

        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        boothMultiplication(-3, -100);
    }
}
