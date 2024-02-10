
import features.feature;

public class DataNumbers 
{
    public static void main(String[] args) 
    {
        String num = "0000";
        for (int i = 0; i <=15 ; i++)
        {
            System.out.print( Integer.parseInt(num, 2) + " = ");
            System.out.print(num + " = " );
            String twosComplement = features.feature.convert(num);
            System.out.println(twosComplement);
            num = feature.addBinaryStrings(num, "1");
        }
    }
}



// PS C:\Users\heman\Desktop\Restoring> cd "c:\Users\heman\Desktop\Restoring\" ; if ($?) { javac DataNumbers.java } ; if ($?) { java DataNumbers }
// 0 = 0000 = 0000
// 1 = 0001 = 1111
// 2 = 0010 = 1110
// 3 = 0011 = 1101
// 4 = 0100 = 1100
// 5 = 0101 = 1011
// 6 = 0110 = 1010
// 7 = 0111 = 1001
// 8 = 1000 = 1000
// 9 = 1001 = 0111
// 10 = 1010 = 0110
// 11 = 1011 = 0101
// 12 = 1100 = 0100
// 13 = 1101 = 0011
// 14 = 1110 = 0010
// 15 = 1111 = 0001