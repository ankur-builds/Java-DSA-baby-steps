/*
 * Copyright (c) 2020.
 * File : Stack.java
 * Author : Ankur
 * Last modified : 15/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class StackDS<E> {
    Node root;

    class Node{
        E data;
        Node next;

        Node (E d){
            data = d;
            next = null;
        }
    }

    void push(E data) {
        Node temp = root;
        root = new Node(data);
        root.next = temp;
    }

    E pop(){
        E value = null;
        if(root!=null) {
            value = root.data;
            root = root.next;
        }
        return value;
    }

    E peep(){
        return root.data;
    }

    boolean isEmpty(){
        return (root==null);
    }

    int search(E key){
        Node n = root;
        int count = 0;
        while(n!=null){
            ++count;
            if(n.data==key)
                return count;

            n = n.next;
        }

        return -1;
    }

    int size(){
        Node n = root;
        int length = 0;
        while(n!=null){
            ++length;
            n = n.next;
        }
        return length;
    }

    public static void main(String[] args) {
        StackDS<Integer> st = new StackDS<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println("Size : " + st.size());
        System.out.println("Index from top : " + st.search(20));
        System.out.println("Is stack empty : " + st.isEmpty() + ", top : " + st.peep());
        System.out.println(st.pop() + " " + st.pop());
        System.out.println("Is stack empty : " + st.isEmpty());
    }
}
