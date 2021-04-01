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
import java.util.concurrent.ThreadLocalRandom;

public class MirrorTree {
    public static void mirror(BST.Node n){
        if(n==null)
            return;

        mirror(n.left);
        mirror(n.right);

        BST.Node temp = n.left;
        n.left = n.right;
        n.right = temp;
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
    }
}
