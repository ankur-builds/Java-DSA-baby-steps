/*
 * Copyright (c) 2020.
 * File : Main.java
 * Author : Ankur
 * Last modified : 27/6/2020
 * All rights reserved. Please refer to apache license terms in the project.
 */

public class Main {
    /*
    An object stores its state in fields (variables in some programming languages) and exposes its behavior through
    methods (functions in some programming languages). Methods operate on an object's internal state and serve as the
    primary mechanism for object-to-object communication.
     */
    
    public static void main(String[] args) {
        /*
        The main method accepts a single argument: an array of elements of type String. This array is the mechanism
        through which the runtime system passes information to your application. For example:
            java MyApp arg1 arg2
                For example : java main Hello World
                Each string in the array is called a command-line argument.
         */
        System.out.println("Start learning Java");
        System.out.println(args.length);
    }
}
