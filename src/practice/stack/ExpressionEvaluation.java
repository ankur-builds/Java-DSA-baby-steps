/*
 * Copyright (c) 2020.
 * File : ExpressionEvaluation.java
 * Author : Ankur
 * Last modified : 9/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.stack;

import java.util.Stack;

public class ExpressionEvaluation {
    boolean isOperator(char ch){
        switch(ch){
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

    int precedence(char ch){
        switch(ch) {
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

    int evaluate(int o1, int o2, char ch){
        switch(ch){
            case('*'):
                return o1*o2;
            case('/'):
                return o1/o2;
            case('%'):
                return o1%o2;
            case('+'):
                return o1+o2;
            case('-'):
            default:
                return o1-o2;
        }
    }

    void pushIntoStack(Stack<Integer> stk1, char operator){
        if(stk1.size()>=2) {
            int operand2 = stk1.pop();
            if (operand2 != Integer.MIN_VALUE)
                stk1.push(evaluate(stk1.pop(), operand2, operator));
        }
    }

    // There are total three cases here. Our approach will be similar to Infix to postfix conversion
    int evaluateExpression(String str){
        Stack<Integer> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        char[] ch = str.toCharArray();
        for(int i = 0; i<str.length(); ++i){
            // Case I : Its an operand
            if(ch[i]>='0' && ch[i]<='9'){
                StringBuilder stbld = new StringBuilder();
                stbld.append(ch[i++]);
                // We have to go for while loop to parse multi-digit integer
                while(i<str.length() && ch[i]>='0' && ch[i]<='9'){
                    stbld.append(ch[i++]);
                }

                stk1.push(Integer.valueOf(stbld.toString()));
                --i;
            } else if(isOperator(ch[i])){
                // Case II : Its an operator
                if(!stk2.isEmpty() && precedence(ch[i])<=precedence(stk2.peek())){
                    while(!stk2.isEmpty() && precedence(ch[i])<=precedence(stk2.peek())){
                        pushIntoStack(stk1,stk2.pop());
                    }
                }
                stk2.push(ch[i]);
            } else if (ch[i]=='(')  // Case III : Handle brackets ()
                // It doesn't really matter if push it in operand stack or operator stack
                stk2.push(ch[i]);
            else if(ch[i]==')'){
                while(!stk2.isEmpty() && stk2.peek()!='(' && !stk1.isEmpty()){
                    pushIntoStack(stk1, stk2.pop());
                }
                stk2.pop();  // Makes sense to push it in operator stack as it takes Character input.
            }
        }

        while(!stk1.isEmpty()&&!stk2.isEmpty()){
            pushIntoStack(stk1, stk2.pop());
        }
        return stk1.pop();
    }
    public static void main(String[] args) {
        ExpressionEvaluation input = new ExpressionEvaluation();
        System.out.println(input.evaluateExpression("10 + 2 * 6"));
        System.out.println(input.evaluateExpression("100 * 2 + 12"));
        System.out.println(input.evaluateExpression("100 * ( 2 + 12 )"));
        System.out.println(input.evaluateExpression("100 * ( 2 + 12 ) / 14"));
        System.out.println(input.evaluateExpression("10+8*4"));
    }
}
