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

import java.util.Stack;

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
          but with indx obtained in previous line, we are able to divide our traversal/search across it.
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

    public static void main(String[] ars)
    {
        int[] in = { 4, 2, 5, 1, 3, 6 };
        int[] pre = { 1, 2, 4, 5, 3, 6 };
        int len = in.length;
        FindPostOrder treeNode = new FindPostOrder();
        treeNode.printPostOrder(in, pre, 0, len-1);

        System.out.println();
        int[] preorder = {40, 30, 35, 37, 39, 80, 100};
        len = preorder.length;
        treeNode.printPostOrderTraversal(preorder, 0, len-1);
        System.out.println();
    }
}
