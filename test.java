import features.feature;

public class test 
{
    public static void main(String[] args) 
    {
        String a = "0000";
        
        for(int i = 0; i <16 ; i++)
        {
            System.out.print(  Integer.parseInt(a, 2) + "=" + a  );

            System.out.println( "   -" + Integer.parseInt(a, 2) + "=" + feature.calculateTwosComplement(a)  );

            a = feature.addBinaryStrings(a, "0001");
        }


    }
}
