/*
 * Copyright (c) 2020.
 * File : PrintLeftView.java
 * Author : Ankur
 * Last modified : 26/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree;

import dsa.Tree;
import java.util.concurrent.ThreadLocalRandom;

/*
   The left view contains all nodes that are first nodes in their levels.
 */
public class PrintLeftView {
    static int currentLevel = 0;

    static void printLeftView(Tree.Node n, int level){
        if(n==null)
            return;

        if(currentLevel<level){
            System.out.print(n.data + " ");
            currentLevel = level;
        }

        printLeftView(n.left, level+1);
        printLeftView(n.right, level+1);
    }

    public static void main(String[] args) {
        Tree t = new Tree();

        System.out.println("Create an unordered list of 10 nodes");
        for (int i = 0; i < 10; ++i) {
            t.addNode(ThreadLocalRandom.current().nextInt(100));
        }

        System.out.println("\n\nPrint Left view of height : ");
        printLeftView(t.root, 1);
    }
}

