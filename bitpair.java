import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.crypto.Data;

import features.feature;

public class bitpair 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1 : ");
        int decimalNumber = sc.nextInt();
        String A = Integer.toBinaryString(Math.abs(decimalNumber));

        System.out.print("Enter num2 : ");
        int decimalNumber2 = sc.nextInt();
        String B = Integer.toBinaryString(Math.abs(decimalNumber2));
        sc.close();


        if(decimalNumber<0)
        {
            A =feature.convert(A);
            A = "1" + A;
        }
        else
        {
            A = "0" + A;
        }

        if(decimalNumber2<0)
        {
            B = feature.convert(B);
            B = "1" + B;
        }
        else
        {
            B = "0" + B;
        }


        System.out.println("A = " + A + " B = " + B);


        if(A.length()!=B.length())
        {
            if(A.length()>B.length())
            {
                if(decimalNumber2>0)
                {
                    while(A.length()!=B.length())
                    {
                        B = "0" + B;
                    }
                }
                else
                {
                    while(A.length()!=B.length())
                    {
                        B = "1" + B;
                    }
                }
            }
            if(B.length()>A.length())
            {
                if(decimalNumber>0)
                {
                    while(A.length()!=B.length())
                    {
                        A = "0" + A;
                    }
                }
                else
                {
                    while(A.length()!=B.length())
                    {
                        A = "1" + A;
                    }
                }

            }
        }


        System.out.println("A = " + A + " B = " + B);


        int count = B.length();

        B = B+"0";

        if( count %2 ==1 )
        {
            if(decimalNumber2<0)
            {
                B = "1" + B;
            }
            else
            {
                B = "0" + B;
            }
        }



        ArrayList<Integer> bitpair = new ArrayList<Integer>();


        for (int i = 0; i < B.length() -2 ; i=  i+2)
        {
            System.out.println(B.substring(i, i + 3));

            String temp = B.substring(i,i+3);


            if(temp.equals("000"))
            {
                bitpair.add( 0);
            }

            if(temp.equals("001"))
            {
                bitpair.add( 1);
            }

            if(temp.equals("010"))
            {
                bitpair.add( 1);
            }

            if(temp.equals("011"))
            {
                bitpair.add( 2);
            }

            if(temp.equals("100"))
            {
                bitpair.add( -2);
            }

            if(temp.equals("101"))
            {
                bitpair.add( -1);
            }

            if(temp.equals("110"))
            {
                bitpair.add( -1);
            }

            if(temp.equals("111"))
            {
                bitpair.add( 0);
            }


        }

        System.out.println("Bit pair :");

        for(int i =0 ; i< bitpair.size(); i++ )
        {
            System.out.print(bitpair.get(i) + " ");
        }

        System.out.println("");

        
        int setsize = A.length() + (int) Math.pow(2,bitpair.size()-1  );


        // System.out.println("Bitpair table");

        // int[] multiguide= new int[8];

        String[] matrix = new String[bitpair.size()];


        for(int i =0 ; i< bitpair.size() ; i++ )
        {
            
            int bit = bitpair.get(bitpair.size()-i-1);

            System.out.println("bit =" + bit );


            String data ="";

            if( bit == 1)
            {
                data = A;
            }
            if(bit == -1)
            {
                data = feature.convert(A);
            }

            if(bit == -2)
            {
                data = feature.convert(A + "0");
            }

            if(bit == 2)
            {
                data = A + "0";
            }

            for(int j =0 ; j< i ; j++)
            {
                data+="XX";
            }

            if(bit ==0)
            {
                while(data.length() < setsize)
                {
                    data = "0" + data;
                }
            }


            int sign = decimalNumber*bit;

            while( data.length() < setsize )
            {

                if( sign >0)
                {
                    data = "0"+data;
                }
                else
                {
                    data = "1"+data;
                }

            }

            matrix[i] = data;

        }

        System.out.println("");

      


        for(int i = 0 ; i<matrix.length ; i++ )
        {
            System.out.println(matrix[i]);
        }

       


        String[] new_matrix = new String[bitpair.size()];


        for(int i = 0 ; i< bitpair.size() ; i++)
        {
            new_matrix[i] = matrix[i].replace('X', '0');
        }

        System.out.println("new matrix :");
        for(int i = 0 ; i<matrix.length ; i++ )
        {
            System.out.println(new_matrix[i]);
        }


        String sum = "";

        for(int i =0 ; i< setsize; i++ )
        {
            sum+= "0";
        }

 



        for(int i =0 ; i< bitpair.size() ; i++)
        {
            sum = feature.addBinaryStrings(sum, new_matrix[i]);
        }


        System.out.println(sum);


        if( decimalNumber*decimalNumber2 <0 )
        {
            sum = feature.convert(sum);
        }


        String ans = sum.substring( sum.length()-setsize  );

        System.out.println(ans);


        int fial_ans = Integer.parseInt(ans ,2);

        System.out.println(fial_ans);


        if(fial_ans == decimalNumber*decimalNumber2)
        {
            System.out.println("CORRECT");
        }
        else
        {
            System.out.println("WRONG");
        }

        






        





        


        




        
    }
}
