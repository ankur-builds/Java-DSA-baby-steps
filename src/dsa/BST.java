/*
 * Copyright (c) 2020.
 * File : BST.java
 * Author : Ankur
 * Last modified : 26/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class BST {
    Tree.Node root;

    static class Node{
        int data;
        Tree.Node left;
        Tree.Node right;

        Node(int d){
            data = d;
            left = right = null;
        }
    }

    void addNode(int d){
        System.out.print(d + " ");
        if(root == null) {
            root = new Tree.Node(d);
            return;
        }
        Tree.Node n = root;
        while(true){
            if(d <= n.data){
                if(n.left == null) {
                    n.left = new Tree.Node(d);
                    return;
                } else
                    n = n.left;
            } else {
                if(n.right == null){
                    n.right = new Tree.Node(d);
                    return;
                } else
                    n = n.right;
            }
        }
    }

    public static void main(String[] args) {

    }
}
