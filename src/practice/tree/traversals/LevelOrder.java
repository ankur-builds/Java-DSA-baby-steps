/*
 * Copyright (c) 2020.
 * File : LevelOrder.java
 * Author : Ankur
 * Last modified : 13/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree.traversals;

import dsa.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class LevelOrder {
    // Problem Statement 1 : Print level order traversal in spiral form
    static void printLvlOrdrInSpiralForm(BST.Node n){
        Stack<BST.Node> stk = new Stack<>();
        Stack<BST.Node> stk1 = new Stack<>();

        stk.push(n);
        boolean flip = true;
        while(!stk.isEmpty() || !stk1.isEmpty()){
            if(flip) {
                n = stk.pop();

                System.out.print(n.data + " ");
                if (n.left != null) stk1.add(n.left);
                if (n.right != null) stk1.add(n.right);

                if (stk.isEmpty()) {
                    flip = false;
                    System.out.println();
                }
            } else{
                n = stk1.pop();

                System.out.print(n.data + " ");
                if (n.right != null) stk.add(n.right);
                if (n.left != null) stk.add(n.left);

                if (stk1.isEmpty()) {
                    flip = true;
                    System.out.println();
                }
            }
        }
    }

    // Problem Statement 2 : Print level order traversal line by line using 2 queues
    static void printlvlorder2q(BST.Node n){
        Queue<BST.Node> q = new LinkedList<>();
        Queue<BST.Node> q1 = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty() || !q1.isEmpty()){
            while(!q.isEmpty()){
                n = q.poll();
                System.out.print(n.data + " ");
                if(n.left!=null)
                    q1.add(n.left);
                if(n.right!=null)
                    q1.add(n.right);
            }

            System.out.println();

            while(!q1.isEmpty()){
                n = q1.poll();
                System.out.print(n.data+" ");
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }

            System.out.println();
        }
    }

    // Problem Statement 3 : Print level order traversal line by line using 1 queue
    static void printlvlorder1q(BST.Node n){
        Queue<BST.Node> q = new LinkedList<>();
        q.add(n);
        q.add(null); // Awesome idea to use null as tree level delimiter

        while (!q.isEmpty()){
            n = q.poll();

            if(n!=null){
                System.out.print(n.data + " ");
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            } else{
                System.out.println();
                if(q.isEmpty())
                    return;
                else
                    q.add(null);
            }
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        for(int i = 1; i<=20; ++i){
            tree.addNode(ThreadLocalRandom.current().nextInt(10,25));
        }

        System.out.println("\nLevel order of original tree 2q :");
        printlvlorder2q(tree.root);

        System.out.println("\nLevel order of original tree 1q :");
        printlvlorder1q(tree.root);

        System.out.println("\n\nLevel order in spiral form :");
        printLvlOrdrInSpiralForm(tree.root);
    }
}
