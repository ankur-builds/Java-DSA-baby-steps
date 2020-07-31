/*
 * Copyright (c) 2020.
 * File : TryBasics.java
 * Author : Ankur
 * Last modified : 27/6/2020
 * All rights reserved. Please refer to apache license terms in the project.
 */

package basics;

import java.util.Scanner;

public class TryBasics {

    public static void main(String[] args) {
        System.out.println("Try Basics");

        TryBasics basics = new TryBasics();
        basics.tryArrayManipulations();
        basics.tryBitWiseManipulations();
        basics.tryTypeCasting();
        basics.tryStringOperations();
        basics.performInputOutput();
        basics.tryVarags("Hello ", "World ", " Duniya valo ");
    }

    private void tryVarags(String... arg){
        int n = arg.length;
        for (String str : arg) {
            System.out.print(str);
        }
    }

    public void tryArrayManipulations() {
        // Try different things that canbe done with an array
        int[] arr = new int[0];
        System.out.println(arr.length);
        // System.out.println(arr[0]);
    }

    public void tryTypeCasting(){
        // Play with wrapper class

    }

    public void tryBitWiseManipulations(){
        // Play with bit operators

    }

    public void tryStringOperations(){
        // Play with String class

        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        int x=sc.nextInt();
        System.out.printf("%-15s%03d%n", s1, x);
        // ("%-15s%03d%n", s1, x) % : used as a formatter.
        // '-' : minus sign used for left indentation of the string.
        // 15s : here 15 denotes the string's minimum field width 15. '0' : pads the extra 0s in the integer.
        // 3d : here 3 denotes integer's minimum field width 3. %n : prints the new line.
    }

    public void performInputOutput(){
        /******
         Scenario - 1 :: Difference between System.out.print and System.out.println
         ******/
        System.out.println("Hello"); // println will print in different lines
        System.out.println("World");

        System.out.print("2020 "); //print will print in the same line. Kind of like cout without endl
        System.out.print("will be good for me.\n");

        /*******
         Scenario - 2 :: Read input for different data type like cin
         *******/
        Scanner sc = new Scanner(System.in);
        // while(sc.hasNext()) // This method may block while waiting for input to scan. The scanner does not advance past any input.
        System.out.println(sc.nextInt());
        // Note that hasNext() won't be blocking while reading input from a file but from console it expects a stream
        // hence will continue to wait for next token

        // Scanner is too slow will give TLE in competitive programming.


        System.out.println("Exit");
    }
}
