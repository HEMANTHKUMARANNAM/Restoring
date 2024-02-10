package features;

public class feature 
{



    // ADDER
    public static String addBinaryStrings(String binaryString1, String binaryString2) 
    {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = binaryString1.length() - 1;
        int j = binaryString2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? binaryString1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? binaryString2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }


    // COMPLEMENT 

    public static String convert(String num) {
        String binaryString = num; // Replace this with your binary string

        String onesComplement = calculateOnesComplement(binaryString);
        String twosComplement = calculateTwosComplement(onesComplement);

        // System.out.println("Original Binary: " + binaryString);
        // System.out.println("Ones Complement: " + onesComplement);
        // System.out.println("Twos Complement: " + twosComplement);

        return twosComplement;
    }

    private static String calculateOnesComplement(String binaryString) {
        StringBuilder onesComplement = new StringBuilder();

        for (char bit : binaryString.toCharArray()) {
            onesComplement.append((bit == '0') ? '1' : '0');
        }

        return onesComplement.toString();
    }

    public static String calculateTwosComplement(String onesComplement) {
        int length = onesComplement.length();
        StringBuilder twosComplement = new StringBuilder(onesComplement);

        // Add 1 to the least significant bit
        for (int i = length - 1; i >= 0; i--) {
            if (onesComplement.charAt(i) == '0') {
                twosComplement.setCharAt(i, '1');
                break;
            } else {
                twosComplement.setCharAt(i, '0');
            }
        }

        return twosComplement.toString();
    }



    






}









