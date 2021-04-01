/*
 * Copyright (c) 2021.
 * File : MirrorTree.java
 * Author : Ankur
 * Last modified : 1/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree;

import dsa.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class MirrorTree {
    // When we take mirror of a binary, left & right child of every node will get swapped.
    // Its implementation in recursive approach.
    public static void mirror(BST.Node n){
        if(n==null)
            return;

        mirror(n.left);
        mirror(n.right);

        BST.Node temp = n.left;
        n.left = n.right;
        n.right = temp;
    }

    // Here I am not reconstructing the tree but just mirroring the output using iterative approach
    public static void mirrorIteratively(BST.Node n){
        Queue<BST.Node> q = new LinkedList<>();
        Stack<Integer> stk = new Stack<>();

        q.add(n);
        q.add(null);
        while(!q.isEmpty()){
            n = q.poll();

            if(n!=null){
                stk.add(n.data);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            } else{
                // Basically here I am just reversing the level order traversal using stack
                while(!stk.isEmpty())
                    System.out.print(stk.pop() + " ");

                System.out.println();
                if(q.isEmpty())
                    return;
                else
                    q.add(null);
            }
        }
    }

    public static void main(String[] args) {
        BST t = new BST();

        for(int i = 0; i<10; ++i){
            t.addNode(ThreadLocalRandom.current().nextInt(10,20));
        }

        System.out.println();
        t.printLevelOrderTraversal(t.root);

        System.out.println("------");
        mirror(t.root);
        t.printLevelOrderTraversal(t.root);

        System.out.println("------");
        mirrorIteratively(t.root);
    }
}
