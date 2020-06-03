import com.ankur.basics.basics;

import java.util.Arrays;

public class Main {

    public static void printHello()
    {
        System.out.println("Hello");
    }
    
    public static void main(String [] args)
    {
        System.out.println("Start learning Java");
        printHello();
        // testArray();
    }

    public static void testArray(){
        String str = "COMMAREA=RA3202002141244090000012020021412440900000100018A3986001000000000010000057800879530101ABBYEZ$JJ1901000000SD4300000000001000000202002142020021412425664300020200214124256643000E02SUCCESSFINALKBCDTESTCOR200214124258000B8A3986001P20200214";
        System.out.println("Input String : " + str);
        System.out.println("Input String Length : " + str.length());

        System.out.println(str.substring(9));

        byte[] byteArray = str.getBytes();
        String str2 = new String(byteArray);
        System.out.println("Output String: " + str2);

        String [] strArray = new String[2];
        strArray[0] = "Hello";
        strArray[1] = "World";
        System.out.println(Arrays.toString(strArray));
    }
}
