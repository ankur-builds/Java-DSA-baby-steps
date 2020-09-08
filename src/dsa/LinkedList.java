/*
 * Copyright (c) 2020.
 * File : LinkedList.java
 * Author : Ankur
 * Last modified : 15/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Delete a node
    void deleteNode(int key){
        if(head.data == key) {
            head = head.next;
            return;
        }

        Node current = head.next;
        Node prev = head;
        while(current!=null){
            if(current.data == key){
                prev.next = current.next;
                return;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    // insert a node at the start
    void insertNode(Node t){
        // Here we are adding new node at the start itself.
        t.next = head;
        head = t;
    }

    // insert a node in a given position
    void insertNode(Node t, int pos){
        System.out.println("\nInsert Node");
        if(pos==1){
            t.next = head;
            head = t;
            return;
        }
        Node current = head.next;
        Node prev = head;
        int count = 2;

        while(true){
            if(current == null)
                return;

            if(count!=pos) {
                ++count;
                // System.out.printf("(%d) current %d, prev %d \n", count, current.data, prev.data);
                prev = current;
                current = current.next;
                System.out.printf("(%d) current %d, prev %d \n", count, current.data, prev.data);
            } else{
                // System.out.printf("(d) ELSE current %d, prev %d, t %d \n", count, current.data, prev.data, t.data);
                prev.next = t;
                t.next = current;
                return;
            }
        }
    }

    int lengthOfLinkedList(){
        Node n = head;
        int count = 0;
        while(n!=null){
            ++count;
            n = n.next;
        }
        return count;
    }

    boolean search(int key){
        Node n = head;
        while(n!=null){
            if(n.data == key)
                return true;

            n = n.next;
        }
        return false;
    }

    void traverseList(){
        Node n = head;
        while(n!=null){
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.head = new Node(20);

        Node second = new Node(30);
        ll.head.next = second;

        Node third = new Node(40);
        second.next = third;

        third.next = new Node(50);

        ll.traverseList();
        ll.deleteNode(40);
        System.out.println();
        ll.traverseList();

        ll.insertNode(new Node(10));
        System.out.println();
        ll.traverseList();

        ll.insertNode(new Node (40), 2);
        System.out.println();
        ll.traverseList();
        System.out.println("\nLength : " + ll.lengthOfLinkedList());

        System.out.println(ll.search(20));
    }
}
