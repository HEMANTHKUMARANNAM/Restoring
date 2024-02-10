import features.feature;

public class Negativedata 
{
    public static void main(String[] args) 
    {
        String num = "0010";

        String start = "0000";

        for(int i = 0; i <16 ; i++)
        {
            System.out.println("-14+" +Integer.parseInt(start, 2) + "=" + feature.addBinaryStrings(num, start)  );

            start = feature.addBinaryStrings( start , "0001");

        }
    }
}
