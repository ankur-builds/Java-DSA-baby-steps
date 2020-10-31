/*
 * Copyright (c) 2020.
 * File : InfixToPostfix.java
 * Author : Ankur
 * Last modified : 30/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

public class InfixToPostfix {
    Stack<Character> stk = new Stack<>();

    /*
    Infix expression is one when operator is between two operands so won't be considering unary operators
     */
    int precedence(char ch){
        switch(ch) {
            case('^'):
                return 4;
            case('*'):
            case('/'):
            case('%'):
                return 3;
            case('+'):
            case('-'):
                return 2;
            default:
                return 1;
        }
    }

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
    /*
    Infix : a+b+c
    Postfix : ab+c+
     */
    void convertInfix2Postfix(String str){
        char[] charArray = str.toCharArray();
        // Scan the infix expression from left to right.
        for(char ch : charArray){
            if(isOperator(ch)){
                // if Scanned character is operator check if stack is empty
                if(!stk.isEmpty()){
                    // Stack is not empty. It will contain operators. Compare them
                    if(precedence(ch) <= precedence(stk.peek())){
                        while(!stk.isEmpty()){
                            // Stack is empty check is required to avoid exception during stk.peek()
                            if (precedence(ch)<=precedence(stk.peek()))
                                // Scanned operator has lower precedence, keep popping operators in stack
                                System.out.print(stk.pop() + " ");
                            else
                                break;
                        }
                    }
                }
                stk.push(ch); // Push scanned operator in stack
            } else if(ch == '('){
                stk.push(ch);
            } else if(ch == ')'){
                char temp = stk.pop();
                while(temp!='(') {
                    // Keep popping operators until we reach '('
                    System.out.print(temp + " ");
                    temp = stk.pop();
                }
            } else if((ch >= 'a' && ch <= 'z') ||
                      (ch >='A' && ch <= 'Z')){
                //  If the scanned character is an operand, output it.
                System.out.print(ch + " ");
            }
        }

        while(!stk.isEmpty())
            System.out.print(stk.pop() + " ");
    }
    public static void main(String[] args) {
        InfixToPostfix convertExpression = new InfixToPostfix();
        convertExpression.convertInfix2Postfix("A+B*C*D");
        System.out.println();
        convertExpression.convertInfix2Postfix("A/(B*C)/D");
        System.out.println();
        convertExpression.convertInfix2Postfix("A/B*C/D");
        System.out.println();
        convertExpression.convertInfix2Postfix("(A+B)*C-(D-E)*(F+G)");
        System.out.println();
        convertExpression.convertInfix2Postfix("A*B+C*D");
    }
}
