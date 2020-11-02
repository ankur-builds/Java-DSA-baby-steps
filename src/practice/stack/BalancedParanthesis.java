/*
 * Copyright (c) 2020.
 * File : BalancedParanthesis.java
 * Author : Ankur
 * Last modified : 2/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

public class BalancedParanthesis {
    boolean checkBalancedParanthesis(String str){
        System.out.print(str + " : ");
        Stack<Character> stk = new Stack<>();
        for(char ch : str.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stk.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                ch = invert(ch);
                if (ch != stk.pop())
                    return false;
            }
        }

        return stk.isEmpty();
    }

    char invert(char ch){
        switch (ch){
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default :
                return '@';
        }
    }
    public static void main(String[] args) {
        BalancedParanthesis input = new BalancedParanthesis();
        System.out.println(input.checkBalancedParanthesis("[()]{}{[()()]()}"));
        System.out.println(input.checkBalancedParanthesis("[(])"));
        System.out.println(input.checkBalancedParanthesis("["));
        System.out.println(input.checkBalancedParanthesis("()"));
        System.out.println(input.checkBalancedParanthesis("(abcdefg)"));
    }
}
