/*
 * Copyright (c) 2020.
 * File : TryLambda.java
 * Author : Ankur
 * Last modified : 30/7/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package basics;

public class TryLambda {
    interface IntegerMath {
        int operation(int a, int b);
    }

    interface CustomI{
        int print(int a, int b);
    }
    public int printHello(int a, int b, CustomI ci){
        return ci.print(a,b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        TryLambda myApp = new TryLambda();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        CustomI ci_var = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
            return 1;
        };

        /*
        ** Unnecessary compilation error shown by IntelliJ. Below two statements are perfectly fine.
        System.out.printf("40 + 2 = %d%n", myApp.operateBinary(40, 2, addition));
        System.out.printf("20 - 10 = %d%n", myApp.operateBinary(20, 10, subtraction));
         */
        System.out.println("CustomI" + myApp.printHello(50,100,ci_var));
    }
}
