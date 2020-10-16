/*
 * Copyright (c) 2020.
 * File : LevelOrder.java
 * Author : Ankur
 * Last modified : 6/10/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree.traversals;

import dsa.BST;

import java.util.concurrent.ThreadLocalRandom;

public class PracticeTraversals1 {
    // Problem : Find nth node of inorder traversal
    private static int count = 0;
    private static int val = 6;
    static void nthNode(BST.Node n){
        if(n != null && count != val){
            nthNode(n.left);

            if(++count == val) {
                System.out.println(n.data);
                return;
            }

            nthNode(n.right);
        }
    }

    public static void main(String[] args) {
        BST treeNode = new BST();
        for(int i = 1; i<10; ++i){
            treeNode.addNode(ThreadLocalRandom.current().nextInt(10,40));
        }

        System.out.println();
        nthNode(treeNode.root);
    }
}
