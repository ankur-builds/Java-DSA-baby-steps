/*
 * Copyright (c) 2020.
 * File : InfixToPrefix.java
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

public class InfixToPrefix {
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

    /**
     * Step 1: Reverse the infix expression i.e A+B*C will become C*B+A.
     *         Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘
     * Step 2: Obtain the postfix expression of the modified expression i.e CB*A+
     * Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC
     * https://www.geeksforgeeks.org/convert-infix-prefix-notation/
     */
    void infixToPrefix(String str){
        System.out.println("Input : " + str);
        System.out.println("Output : " + reverseString(toPostfix(reverseString(str))));
    }

    String reverseString(String str){
        int len = str.length();
        StringBuilder output = new StringBuilder();
        char[] ch = str.toCharArray();

        for(int i = len-1; i>=0; --i){
            if(ch[i] == '(')
                output.append(')');
            else if(ch[i] == ')')
                output.append('(');
            else
                output.append(ch[i]);
        }

        return output.toString();
    }

    String toPostfix(String str) {
        char[] charArray = str.toCharArray();
        // Scan the infix expression from left to right.
        StringBuilder output = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        for (char ch : charArray) {
            if (isOperator(ch)) {
                // if Scanned character is operator check if stack is empty
                if (!stk.isEmpty()) {
                    // Stack is not empty. It will contain operators. Compare them
                    if (precedence(ch) <= precedence(stk.peek())) {
                        while (!stk.isEmpty()) {
                            // Stack is empty check is required to avoid exception during stk.peek()
                            if (precedence(ch) <= precedence(stk.peek()))
                                // Scanned operator has lower precedence, keep popping operators in stack
                                output.append(stk.pop());
                            else
                                break;
                        }
                    }
                }
                stk.push(ch); // Push scanned operator in stack
            } else if (ch == '(') {
                stk.push(ch);
            } else if (ch == ')') {
                char temp = stk.pop();
                while (temp != '(') {
                    // Keep popping operators until we reach '('
                    output.append(temp);
                    temp = stk.pop();
                }
            } else if ((ch >= 'a' && ch <= 'z') ||
                    (ch >= 'A' && ch <= 'Z')) {
                //  If the scanned character is an operand, output it.
                output.append(ch);
            }
        }

        while(!stk.isEmpty())
            output.append(stk.pop());

        return output.toString();
    }

    public static void main(String[] args) {
        InfixToPrefix input = new InfixToPrefix();
        input.infixToPrefix("((A+B)*(C-D))"); // Expected : *+AB-CD
        System.out.println();
        input.infixToPrefix("((A-(B/C))*((A/K)-L))"); // Expected : *-A/BC-/AKL
    }
}
