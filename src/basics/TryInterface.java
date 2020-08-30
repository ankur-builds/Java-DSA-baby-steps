/*
 * Copyright (c) 2020.
 * File : TryInterface.java
 * Author : Ankur
 * Last modified : 27/6/2020
 * All rights reserved. Please refer to apache license terms in the project.
 */

package basics;

public interface TryInterface {
    void print_hello();

    static void print_world() {
        System.out.println("static method");
    }

    default void test_default() {
        System.out.println("Starting point");
    }
}

interface xyz{}

class A implements TryInterface{
    public A(TryInterface variable) {
        System.out.println("#Hello A");
    }

    public A() {

    }

    @Override
    public void print_hello() {
        System.out.println("Hello A");
    }

    @Override
    public void test_default() {
        System.out.println("Override complete");
    }
}

class B implements TryInterface{
    public B(TryInterface variable) {
        System.out.println("#Hello B");
    }

    @Override
    public void print_hello() {
        System.out.println("Hello B");
    }
}

class C implements TryInterface{
    public C(TryInterface variable) {
        System.out.println("#Hello C");
    }

    @Override
    public void print_hello() {
        System.out.println("Hello C");
    }
}
