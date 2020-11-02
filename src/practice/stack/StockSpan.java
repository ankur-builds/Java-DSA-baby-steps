/*
 * Copyright (c) 2020.
 * File : StockSpan.java
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
import java.util.concurrent.ThreadLocalRandom;

public class StockSpan {
    Stack<Track> stk = new Stack<>();
    class Track{
        int price;
        int days;
        Track(int p, int d){
            price = p;
            days = d;
        }
    }

    // Time complexity : O(n)
    // Had we used for loop, it would be O(n^2)
    void calculateStockSpan(int price){
        int day = 1;
        if(stk.isEmpty()) {
            System.out.println(price + " : " + day+ " ");
            stk.push(new Track(price, day));
            return;
        }

        while(!stk.isEmpty()){
            if(price>=stk.peek().price){
                day+= stk.pop().days;
            }else
                break;
        }

        System.out.println(price + " : " + day+ " ");
        stk.push(new Track(price, day));
    }

    public static void main(String[] args) {
        StockSpan input = new StockSpan();
        for(int i = 1; i<=18; ++i){
            int in = ThreadLocalRandom.current().nextInt(20,100);
            input.calculateStockSpan(in);
        }
    }
}
