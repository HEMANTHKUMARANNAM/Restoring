import java.util.Scanner;

import features.feature;

public class booth 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1 : ");
        int decimalNumber = sc.nextInt();
        String Q = Integer.toBinaryString(decimalNumber);

        System.out.print("Enter num2 : ");
        int decimalNumber2 = sc.nextInt();
        String M = Integer.toBinaryString(decimalNumber2);

        sc.close();

        14
        // String M = "1011";
        // String Q = "0100";

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

        M = "01011";
        Q = "01110";




        System.out.println("Q = " + Q +"("+Integer.parseInt(Q,2)+")" );
        System.out.println("M = " + M +"("+Integer.parseInt(M,2)+")"  );

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
                if(AC.length() > M.length())
                {
                    AC = AC.substring(1);
                }
                System.out.println("A = A - B" + " AC = " + AC);
                
                System.out.println("AC = " + AC + " Q0 = " + Q0 + " Q1 = " + Q1);

            }
            else if( Q0Q1.equals("01") )
            {
                AC = feature.addBinaryStrings(AC, M );
                if(AC.length() > M.length())
                {
                    AC = AC.substring(1);
                }
                System.out.println("A = A + B" + " AC = " + AC);
                
                System.out.println("AC = " + AC + " Q0 = " + Q0 + " Q1 = " + Q1);
            }


            //fix ac
            while( AC.length() < M.length() )
            {
                AC = "0" + AC; 
            }
            
            String Q1_s = Q1;
   
            Q1 = String.valueOf( Q0.charAt( Q0.length()-1 ) );


            Q0 = Q0.substring(0, Q0.length()-1 );

            Q0 =  AC.charAt( AC.length()-1 ) + Q0;

            AC = AC.substring( 0,AC.length()-1 );

            AC = AC.charAt(0) + AC;

            System.out.println("AC = " + AC + " Q0 = " + Q0 + " Q1 = " + Q1);

            System.out.println("....................................");

        }


        if(decimalNumber*decimalNumber2 > 0)
        {
            String ans = AC + Q0;
            System.out.println( "ANS = " + ans );
            System.out.println("ans(num) = " + Integer.parseInt(ans , 2) );
        }
        else
        {
            String ans = AC + Q0;
            ans = feature.convert(ans);
            System.out.println( "ANS = " + ans );
            System.out.println("ans(num) = " + Integer.parseInt(ans , 2) );
        }








        
    }
}
