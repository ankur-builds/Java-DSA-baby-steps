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

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public Node root;

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int d){
            data = d;
            left = right = null;
        }
    }

    public void addNode(int d){
        System.out.print(d + " ");
        if(root == null) {
            root = new Node(d);
            return;
        }
        Node n = root;
        while(true){
            if(d < n.data){
                if(n.left == null) {
                    n.left = new Node(d);
                    return;
                } else
                    n = n.left;
            } else {
                if(n.right == null){
                    n.right = new Node(d);
                    return;
                } else
                    n = n.right;
            }
        }
    }

    // Print each level of tree line by line
    public void printLevelOrderTraversal(Node n){
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        q.add(null);  // Awesome idea to use null as tree level delimiter

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

    }
}
