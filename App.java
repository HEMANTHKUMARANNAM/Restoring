
import java.util.Scanner;

import features.feature;

public class App
{

    // public static void main(String[] args) 
    // {
    //     String num = "0000";
    //     for (int i = 0; i <=15 ; i++)
    //     {
    //         System.out.print(num + " = " );
    //         String twosComplement = features.feature.convert(num);
    //         System.out.println(twosComplement);
    //         num = feature.addBinaryStrings(num, "1");
    //     }
    // }

    // public static void main(String[] args) 
    // {
    //     System.out.println(feature.addBinaryStrings("101", "001"));
    // }
    

    public static void main(String[] args) 
    {
        System.out.println("\n\n\t\t\t\tRESTORING DIVISION");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter divident : ");
        int decimalNumber = sc.nextInt();
        String Q = Integer.toBinaryString(decimalNumber);

        System.out.print("Enter divisor : ");
        int decimalNumber2 = sc.nextInt();
        String M = Integer.toBinaryString(decimalNumber2);

        sc.close();

        System.out.println("........................");

        // SIZEFIXER



        if( Q.length() > M.length())
        {
            int len = Q.length() - M.length();
            for(int i = 0; i < len  ; i++)
            {
                M = "0" + M;
            }
        }
        
        if( M.length() > Q.length())
        {
            int len = M.length() - Q.length()-1;
            for(int i = 0; i < len ; i++)
            {
                Q = "0" + Q;
            }
        }


        System.out.println("Q = " + Q );
        System.out.println("M = " + M );


        // String Q = "1011";
        // String M = "0011";

        String complement = features.feature.convert(M);

        System.out.println("COMPLEMENT (-M) = " + complement);

        String A = "";

        for (int i = 0; i < M.length()+1 ; i++ )
        {
            A = A+ "0";
        }
        System.out.println("...............................................");


        for(int i =0 ; i< Q.length() ; i++)
        {
            System.out.println("A = "+ A);
            //shift left AQ
            A = A.substring(1)+Q.charAt(0);
            Q = Q.substring(1);
            System.out.println(M + "  " + A + "  " + Q+"-" + "  " + "SHIFT LEFT AQ" );

            String A_temp = feature.addBinaryStrings(A, complement);

            // A_temp = A_temp.substring(A_temp.length()-M.length());

            System.out.println(M + "  " + A_temp + "  " + Q+"-" + "  " + "A = A-M" );

            if (A_temp.charAt(0) == '0') 
            {
                Q = Q + "0";
                System.out.println(M + "  " + A + "  " + Q + "  " + "Q[0]=0 And restore A" );
            }
            else
            {
                Q = Q + "1";
                A = A_temp;
                System.out.println(M + "  " + A + "  " + Q + "  " + "Q[0]=1" );
            }

            // System.out.println("A = " + A + " " + "Q = " + Q + "      A_temp = " + A_temp);

            System.out.println("...............................................");

        }


        A = A.substring(A.length()-M.length());


        System.out.println("Q = " + Q);
        System.out.println("R = " + A);


        // Convert binary string to decimal string
        String quiotient = Integer.toString(Integer.parseInt(Q, 2));
        String remainder = Integer.toString(Integer.parseInt(A, 2));

        System.out.printf("%d = %d X %d + %d" , decimalNumber , decimalNumber2 , Integer.parseInt(quiotient) ,Integer.parseInt(remainder));


    }


}