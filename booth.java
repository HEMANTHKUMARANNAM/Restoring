import java.util.Scanner;

import features.feature;

public class booth 
{
    public static void main(String[] args) 
    {
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter divident : ");
        // int decimalNumber = sc.nextInt();
        // String Q = Integer.toBinaryString(decimalNumber);

        // System.out.print("Enter divisor : ");
        // int decimalNumber2 = sc.nextInt();
        // String M = Integer.toBinaryString(decimalNumber2);

        // sc.close();

        
        String M = "1011";
        String Q = "0100";

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

        String NQ = feature.convert(Q);
        String NM = feature.convert(M);

        System.out.println("-Q = " + NQ);
        System.out.println("-M = " + NM);

        String AC = "";

        for( int i = 0; i < M.length() ; i++ )
        {
            AC = AC + "0";
        }

        System.out.println("AC = " + AC);

        String Q0 = Q;

        String Q1 = "0";

        System.out.println(".........");
        System.out.println("Q0 = " + Q0 + "  Q1 " + Q1 + "   AC" + AC + "\n......");

        for(int i = 0; i < M.length(); i++ )
        {
            String Q0Q1 = Q0.charAt(Q0.length() -1) + Q1;

            if( Q0Q1.equals("10") )
            {
                AC = feature.addBinaryStrings(AC,  NM   );
                System.out.println("A = A - B" + " AC = " + AC);
            }
            else if( Q0Q1.equals("01") )
            {
                AC = feature.addBinaryStrings(AC, M );
                System.out.println("A = A + B" + " AC = " + AC);
            }


            //fix ac
            while( AC.length() < M.length() )
            {
                AC = "0" + AC; 
            }
            
   
            Q1 = String.valueOf( Q0.charAt( Q0.length()-1 ) );


            Q0 = Q0.substring(0, Q0.length()-1 );

            Q0 =  AC.charAt( AC.length()-1 ) + Q0;

            AC = AC.substring( AC.length()-1 );

            //fix ac
            while( AC.length() < M.length() )
            {
                AC = "0" + AC; 
            }
            

            System.out.println("AC = " + AC + " Q0 = " + Q0 + " Q1 = " + Q1);

            System.out.println("....................................");

        }






        
    }
}
