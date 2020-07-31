/*
 * Copyright (c) 2020.
 * File : TryInterface.java
 * Author : Ankur
 * Last modified : 27/6/2020
 * All rights reserved. Please refer to apache license terms in the project.
 */

package basics;

public interface TryInterface {
    public void print_hello();
}

class A implements TryInterface{
    @Override
    public void print_hello() {
        System.out.println("Hello A");
    }
}

class B implements TryInterface{
    @Override
    public void print_hello() {
        System.out.println("Hello B");
    }
}

class C implements TryInterface{
    @Override
    public void print_hello() {
        System.out.println("Hello C");
    }
}
