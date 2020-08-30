/*
 * Copyright (c) 2020.
 * File : CharSequenceDemo.java
 * Author : Ankur
 * Last modified : 5/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package basics;

public class CharSequenceDemo implements CharSequence {
    private String s;

    public CharSequenceDemo(String s) {
        //It would be much more efficient to just reverse the string
        //in the constructor. But a lot less fun!
        System.out.println("Input String : " + s);
        this.s = s;
    }

    //If the string is backwards, the end is the beginning!
    private int fromEnd(int i) {
        return s.length() - 1 - i;
    }

    public char charAt(int i) {
        if ((i < 0) || (i >= s.length())) {
            throw new StringIndexOutOfBoundsException(i);
        }
        return s.charAt(fromEnd(i));
    }

    public int length() {
        return s.length();
    }

    public CharSequence subSequence(int start, int end) {
        if (start < 0) {
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end > s.length()) {
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start > end) {
            throw new StringIndexOutOfBoundsException(start - end);
        }
        StringBuilder sub =
                new StringBuilder(s.subSequence(fromEnd(end), fromEnd(start)));
        return sub.reverse();
    }

    public String toString() {
        StringBuilder s = new StringBuilder(this.s);
        return s.reverse().toString();
    }

    //Random int from 0 to max. As random() generates values between 0 and 0.9999
    private static int random(int max) {
        return (int) Math.round(Math.random() * (max+1));
    }

    public static void main(String[] args) {
        CharSequenceDemo s =
                new CharSequenceDemo("Write a class that implements the CharSequence interface found in the java.lang package.");

        //exercise charAt() and length()
        System.out.print("Reversed String : ");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }

        System.out.println();

        //exercise subSequence() and length();
        int start = random(s.length() - 1);
        int end = random(s.length() - 1 - start) + start;
        System.out.printf("Random Subsequence from (%d, %d) : ", start+1, end+1);
        System.out.println(s.subSequence(start, end));
        System.out.printf("Original string length : %d\n", s.length());

        //exercise toString();
        System.out.println("Original reversed string : " + s);

    }
}
