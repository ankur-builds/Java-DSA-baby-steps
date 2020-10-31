/*
 * Copyright (c) 2020.
 * File : PrefixPostfixConversions.java
 * Author : Ankur
 * Last modified : 31/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

public class PrefixPostfixConversions {
    boolean isOperator(char ch){
        switch(ch){
            case('^'):
            case('*'):
            case('/'):
            case('%'):
            case('+'):
            case('-'):
                return true;
            default:
                return false;
        }
    }

    void prefixToPostfix(String str){
        System.out.println("Input prefix : " + str);
        char[] ch = str.toCharArray();
        Stack<String> stk = new Stack<>();
        int size = ch.length;

        // Read the Prefix expression in reverse order
        for(int i = size-1; i>=0; --i){
            if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
                // If the symbol is an operand, then push it onto the Stack
                stk.push(String.valueOf(ch[i]));
            } else if (isOperator(ch[i])){
                // If the symbol is an operator, then pop two operands from the Stack
                // Create a string by concatenating the two operands and the operator after them.
                // Push the resultant string back to Stack
                stk.push(stk.pop()+stk.pop()+ch[i]);
            }
        }

        while(!stk.isEmpty()){
            // Output the converted string
            System.out.println("Output postfix : " + stk.pop());
        }
    }

    void postfixToPrefix(String str){
        System.out.println("Input postfix : " + str);
        Stack<String> stk = new Stack<>();

        // Read the Prefix expression in reverse order
        for (char ch : str.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                // If the symbol is an operand, then push it onto the Stack
                stk.push(String.valueOf(ch));
            } else if (isOperator(ch)) {
                // If the symbol is an operator, then pop two operands from the Stack
                // Create a string by concatenating the two operands and the operator after them.
                // Push the resultant string back to Stack
                String temp = stk.pop();
                temp = stk.pop() + temp;
                stk.push(ch + temp);
            }
        }

        while(!stk.isEmpty()){
            // Output the converted string
            System.out.println("Output prefix : " + stk.pop());
        }
    }

    void postfixToInfix(String str){
        System.out.println("Input postfix : " + str);
        Stack<String> stk = new Stack<>();

        for(char ch : str.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                stk.push(String.valueOf(ch));
            } else if (isOperator(ch)){
                // We know that operator preceding an operand will lie between last two operands in stack.
                // We will use that property to
                String temp = stk.pop() + ')';
                temp = '(' + stk.pop() + ch + temp;
                stk.push(temp);
            }
        }

        while(!stk.isEmpty()){
            System.out.println("Output infix : " + stk.pop());
        }
    }

    void prefixToInfix(String str){
        System.out.println("Input prefix : " + str);
        Stack<String> stk = new Stack<>();
        char[] ch = str.toCharArray();
        int size = ch.length;

        for(int i = size-1; i>=0; --i){
            if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')){
                stk.push(String.valueOf(ch[i]));
            } else if (isOperator(ch[i])){
                stk.push('(' + stk.pop() + ch[i]+ stk.pop() + ')');
            }
        }

        while(!stk.isEmpty()){
            System.out.println("Output infix : " + stk.pop());
        }
    }

    public static void main(String[] args) {
        PrefixPostfixConversions input = new PrefixPostfixConversions();
        input.prefixToPostfix("*+AB-CD");
        System.out.println();
        input.prefixToPostfix("*-A/BC-/AKL");

        System.out.println("-------------------------------");
        input.postfixToPrefix("AB+CD-*");
        System.out.println();
        input.postfixToPrefix("ABC/-AK/L-*");

        System.out.println("-------------------------------");
        input.postfixToInfix("abc++");
        System.out.println();
        input.postfixToInfix("ab*c+");
        System.out.println();
        input.postfixToInfix("AB+CD-*");
        System.out.println();
        input.postfixToInfix("ABC/-AK/L-*");

        System.out.println("-------------------------------");
        input.prefixToInfix("*+AB-CD");
        System.out.println();
        input.prefixToInfix("*-A/BC-/AKL");
    }
}
