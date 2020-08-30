/*
 * Copyright (c) 2020.
 * File : StringOps.java
 * Author : Ankur
 * Last modified : 19/7/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package basics;

public class LambdaOps {
    public static void main(String[] args){

        A a = new A();
        a.print_hello();
        TryInterface.print_world();
        a.test_default();

        Sub var = new Sub();
        var.doBaseStuff();
        var.doOtherStuff();

        Base var1 = new Base();
        var1.doBaseStuff();
        // ((StringBuilder)var1).doOtherStuff(); Compiler will only catch exceptions for illegal type casting
        // Runnable r = ((Runnable)var1);  // RunTime ClassCastException
        // ((Sub)var1).doOtherStuff(); // RunTime ClassCastException

        // Decorator Pattern
        System.out.println("\n#Going to try Decorator Pattern#");
        /*
        Following code canbe replaced with lambda. Pretty cool
        TryInterface variable = new TryInterface() {
            @Override
            public void print_hello() {
                System.out.println("Object of TryInterface");
            }
        };
         */
        TryInterface variable = () -> System.out.println("Object of TryInterface");

        // Trying Decorator Pattern
        variable = new A(variable);
        variable = new B(variable);
        variable = new C(variable);

        variable.print_hello();
    }
}
