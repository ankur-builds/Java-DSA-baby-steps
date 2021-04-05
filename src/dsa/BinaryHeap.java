/*
 * Copyright (c) 2021.
 * File : BinaryHeap.java
 * Author : Ankur
 * Last modified : 4/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

import java.lang.reflect.Array;

public class BinaryHeap<T extends Comparable> {
    public static int MAX_SIZE = 40;
    public int count = 0;
    private T[] arr;

    public BinaryHeap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public BinaryHeap(Class<T> clazz, int size) {
        this.arr = (T[]) Array.newInstance(clazz, size);
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > arr.length)
            return -1;

        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > arr.length)
            return -1;

        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count)
            return -1;

        return (index - 1) / 2;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public T getElementAtIndex(int index) {
        return arr[index];
    }

    public void setElementAtIndex(int index, T value) {
        if(index<arr.length)
            arr[index] = value;
    }

    public void addElement(T value){
        arr[count] = value;
    }

    protected void swap(int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public T getHighestPriority(){
        return arr[0];
    }

    public static void main(String[] args) {

    }
}

class MinHeap<T extends Comparable> extends BinaryHeap<T> {
    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    protected void siftDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int smallerIndex = -1;
        if (leftChildIndex != -1 && rightChildIndex != -1)
            smallerIndex = getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(rightChildIndex)) < 0
                    ? leftChildIndex : rightChildIndex;
        else if (leftChildIndex != -1)
            smallerIndex = leftChildIndex; // Right child does not exist
        else if (rightChildIndex != -1)
            smallerIndex = rightChildIndex; // Left child doesnot exist

        if(smallerIndex == -1)
            return;

        if (getElementAtIndex(index).compareTo(getElementAtIndex(smallerIndex)) > 0) {
            swap(index, smallerIndex);
            siftDown(smallerIndex);
        }
    }

    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 &&
                getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }

    public void insert(T value){
        if(isFull()){
            System.out.println("Heap is Full. Throw Exception !!!");
            return;
        }

        addElement(value);
        siftUp(count);
        count++;
    }

    public T removeHighestPriority(){
        T min = getHighestPriority();

        setElementAtIndex(0, getElementAtIndex(count-1));
        count--;
        siftDown(0);

        return min;
    }
}
