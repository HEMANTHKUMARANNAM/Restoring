import java.util.Scanner;

import features.feature;

public class Non_Restoing 
{
    public static void main(String[] args) 
    {
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
            int len = M.length() - Q.length();
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

        System.out.println("COMPLEMENT " + complement);

        String A = "";

        for (int i = 0; i < M.length() ; i++ )
        {
            A = A+ "0";
        }


        for(int i =0 ; i< M.length() ; i++)
        {
            if(A.charAt(0) == '0')
            {
                A = A.substring(1) + Q.charAt(0);
                System.out.println(A + " " + Q.substring(1) + "_ " + "SHIFT LEFT AQ" );
                A = features.feature.addBinaryStrings(A, complement);
                System.out.println(A + " " + Q.substring(1) + "_ " + "A = A-M" );

            }
            else
            {
                A = A.substring(1) + Q.charAt(0);
                System.out.println(A + " " + Q.substring(1) + "_ " + "SHIFT LEFT AQ" );
                A = features.feature.addBinaryStrings(A, M);
                System.out.println(A + " " + Q.substring(1) + "_ " + "A = A+M" );

            }

            Q = Q.substring(1);

            if(A.length() != M.length())
            {
                A = A.substring(1);
            }

            System.out.println(A);

            if (A.charAt(0) == '0') 
            {
                Q = Q + "1";
                System.out.println(A + " " + Q + " " + "Q[O] = 1" );

            }
            else
            {
                Q = Q + "0";
                System.out.println(A + " " + Q + " " + "Q[O] = 0" );
            }
            System.out.println("................................");
        }

        if (A.charAt(0) == '1') 
        {
            System.out.println("got special codition");
            A = features.feature.addBinaryStrings(A, M);
        }

        if(A.length() != M.length())
        {
            A = A.substring(1);
        }



        System.out.println(A + " " + Q );
        System.out.println( decimalNumber + "=" + decimalNumber2 + "x" + Integer.toString(Integer.parseInt(Q, 2)) + "+" + Integer.toString(Integer.parseInt(A, 2)) );

    }
}
