/*
 * Copyright (c) 2021.
 * File : MaxDepth.java
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

import java.util.concurrent.ThreadLocalRandom;

public class MaxDepth {
    public static int maxDepth(BST.Node n){
        if(n==null)
            return 0;

        if(n.left ==null && n.right ==null)
            return 0;

        int leftMax = 1 + maxDepth(n.left);
        int rightMax = 1 + maxDepth(n.right);

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        BST t = new BST();
        for(int i = 0; i<10; ++i)
            t.addNode(ThreadLocalRandom.current().nextInt(10, 20));

        System.out.println();
        t.printLevelOrderTraversal(t.root);
        System.out.println(maxDepth(t.root));
    }
}
