/*
 * Copyright (c) 2020.
 * File : FindPostOrder.java
 * Author : Ankur
 * Last modified : 30/9/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.tree.traversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FindPostOrder{
    static int preIndex = 0;

    // Problem Statement 1: Given inorder and preorder array, output postorder array
    // without constructing tree.
    void printPostOrder(int[] inorderArray, int[] preorderArray, int start, int end){
        if(start>end)
            return;

        // Basically here we are finding the next parent/root
        int indx = search(inorderArray, preorderArray[preIndex++], start, end);

        /*
          Here we are traversing left and right subtree across parent/root just like how we do in
          postorder traversal. Important thing to note here is that we are not constructing a tree
          but with indx obtained in previous line, we are able to divide our tree traversal across it.
         */
        printPostOrder(inorderArray, preorderArray, start, indx-1);
        printPostOrder(inorderArray, preorderArray, indx+1, end);

        // Print current value which is generally root node
        System.out.print(inorderArray[indx] + " ");
    }

    private int search(int[] inorderArray, int key, int start, int end) {
        int i;
        for(i = start; i<end; ++i){
            if(inorderArray[i]==key)
                return i;
        }

        return i;
    }

    // Problem statement 2 : Given preorder traversal, find postorder traversal of BST
    void printPostOrderTraversal(int[] preorderArray, int start, int end){
        if(start>end || start >= preorderArray.length)
            return;

        // Find indx from which right subtree starts
        int indx = findIndx(preorderArray, start, end);

        // Now traverse left subtree. start is parent/root node
        // hence left subtree starts from start+1
        printPostOrderTraversal(preorderArray, start + 1, indx - 1);

        // Now traverse right subtree. Right subtree starts from indx
        printPostOrderTraversal(preorderArray, indx, end);

        System.out.print(preorderArray[start] + " ");
    }

    private int findIndx(int[] preorderArray, int start, int end) {
        for(int i = start; i<=end; ++i){
            if(preorderArray[i]>preorderArray[start])
                return i;
        }

        return end+1;
    }

    void findLRIndex(int[] preorderArray){
        int leftmost = 0, rightmost = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<preorderArray.length; ++i){
            if(preorderArray[i]<min){
                min = preorderArray[i];
                leftmost = i;
            }
            if(preorderArray[i]>max){
                max = preorderArray[i];
                rightmost = i;
            }
        }

        System.out.println("Leftmost : " + preorderArray[leftmost] + " Rightmost : " + preorderArray[rightmost]);
    }

    // Problem statement 3 : Replace each node with sum of its inorder predecessor and successor
    public int[] replaceNode(int[] arr){
        int[] output = new int[arr.length];

        output[0] = arr[1];
        output[arr.length-1] = arr[arr.length-2];
        for(int i = 1; i<arr.length - 1; ++i){
            output[i] = arr[i-1]+arr[i+1];
        }

        return output;
    }

    // Problem statement 4 : Populate inorder successor for all nodes
    List<Node> successorList = new ArrayList<>();
    void populateSuccessor(Node n){
        if(n==null)
            return;

        populateSuccessor(n.left);
        System.out.print(n.data + " ");
        successorList.add(n);
        populateSuccessor(n.right);
    }

    void printSuccessorList(){
        for(int i = 1; i<6; ++i){
            addNode(ThreadLocalRandom.current().nextInt(40));
        }

        System.out.println("\n");
        populateSuccessor(root);

        for(int i = 0; i<successorList.size() - 1; ++i){
            successorList.get(i).next = successorList.get(i+1);
        }

        successorList.get(successorList.size() - 1).next = null;

        System.out.println("\n");
        for (Node node : successorList) {
            if (node.next == null)
                System.out.println(0);
            else
                System.out.print(node.next.data + " ");
        }
    }
    void addNode(int d){
        System.out.print(d + " ");
        if(root==null) {
            root = new Node(d);
            return;
        }

        Node n = root;
        while(n!=null){
            if(n.data > d) {
                if(n.left==null) {
                    n.left = new Node(d);
                    return;
                } else
                    n =n.left;
            } else {
                if(n.right==null) {
                    n.right = new Node(d);
                    return;
                } else
                    n =n.right;
            }
        }
    }

    private Node root;
    static class Node{
        int data;
        Node left, right, next;

        Node(int d){
            data = d;
            left = right = next = null;
        }
    }

    public static void main(String[] ars)
    {
        int[] in = { 4, 2, 5, 1, 3, 6 };
        int[] pre = { 1, 2, 4, 5, 3, 6 };
        int len = in.length;
        FindPostOrder treeNode = new FindPostOrder();
        treeNode.printPostOrder(in, pre, 0, len-1);

        System.out.println();
        int[] preorder = {40, 30, 26, 35, 37, 39, 80, 100};
        len = preorder.length;
        treeNode.printPostOrderTraversal(preorder, 0, len-1);
        System.out.println();

        System.out.println(Arrays.toString(preorder));
        treeNode.findLRIndex(preorder);

        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        System.out.println(Arrays.toString(treeNode.replaceNode(inorder)));

        treeNode.printSuccessorList();
    }
}
