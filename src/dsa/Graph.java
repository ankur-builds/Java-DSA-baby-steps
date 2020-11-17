/*
 * Copyright (c) 2020.
 * File : Graph.java
 * Author : Ankur
 * Last modified : 15/8/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

import java.util.*;

public class Graph {
    int num_nodes;
    byte[][] adjacencyMatrix;
    ArrayList<ArrayList<Integer>> adjacencyList;

    Graph(int v){
        num_nodes = v;
        adjacencyList = new ArrayList<>();
        for(int i = 1; i<=v; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyMatrix = new byte[v][v];
    }

    Graph(int v, byte[][] matrix){
        num_nodes = v;
        adjacencyList = new ArrayList<>();
        for(int i = 1; i<=v; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyMatrix = matrix;
    }

    void addEdge(int u, int v){
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    void addNode(){
        // This will be adjacencyList.size() + 1 th node
        adjacencyList.add(new ArrayList<>());
    }

    void doBFS(int n){
        System.out.println("Breadth First Traversal. Time complexity : O(V+E)");

        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> next = new LinkedList<>();

        next.add(n);
        visited[n] = true;

        while(!next.isEmpty()){
            n = next.poll();
            System.out.print(n+" ");
            for(int i : adjacencyList.get(n)) {
                if(!visited[i]) {
                    next.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println();
    }

    void doDFS(int n){
        System.out.println("Depth First Traversal. Time complexity : O(V+E)");

        boolean[] visited = new boolean[adjacencyList.size()];
        Stack<Integer> stk = new Stack<>();

        visited[n] = true;
        stk.push(n);

        while(!stk.isEmpty()) {
            n = stk.pop();
            System.out.print(n + " ");
            for (int i : adjacencyList.get(n)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stk.push(i);
                    break;
                }
            }
        }

        System.out.println();
    }

    void DFS(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adjacencyList.get(v)) {
            if (!visited[n])
                DFS(n, visited);
        }
    }

    void recursiveDFS(int v)
    {
        boolean[] visited = new boolean[adjacencyList.size()];
        DFS(v, visited);
    }
    /*
    The outer loop is executed O(|V|) regardless of the graph structure.
        - Even if we had no edges at all, for every iteration of the outer loop, we would have
        to do a constant number of operations (O(1))
        - The inner loop is executed once for every edge, thus O(deg(v)) times, where deg(v)
        is the degree of the current node.
        - Thus the runtime of a single iteration of the outer loop is O(1 + deg(v)). Note that
        we cannot leave out the 1, because deg(v) might be 0 but we still need to do some work
        in that iteration

    Summing it all up, we get a runtime of O(|V| * 1 + deg(v1) + deg(v2) + ...) = O(|V| + |E|).
    */
    void printGraph(){
        System.out.println("Printing adjacency list. Time complexity : O(V+E)");
        for(int u = 0; u<adjacencyList.size(); ++u){
            System.out.print("Edge between "+ u);
            for(int v : adjacencyList.get(u)){
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph input = new Graph(5);
        input.addEdge(0,1);
        input.addEdge(0,4);
        input.addEdge(1,2);
        input.addEdge(1,3);
        input.addEdge(1,4);
        input.addEdge(2,3);
        input.addEdge(3,4);

        input.printGraph();
        input.doBFS(4);
        input.doDFS(4);
        input.recursiveDFS(4);
    }
}
