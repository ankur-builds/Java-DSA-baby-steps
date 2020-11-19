/*
 * Copyright (c) 2020.
 * File : Graph.java
 * Author : Ankur
 * Last modified : 17/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

import java.util.*;

public class Graph {
    byte[][] adjacencyMatrix;
    ArrayList<ArrayList<Integer>> adjacencyList;

    Graph(int v){
        adjacencyList = new ArrayList<>();
        for(int i = 1; i<=v; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyMatrix = new byte[v][v];
    }

    Graph(int v, byte[][] matrix){
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
        // This will be size() + 1 th node
        adjacencyList.add(new ArrayList<>());
    }

    // Perform Breadth First Search. Time complexity : O(V+E)
    void doBFS(int n){
        boolean[] visited = new boolean[size()];
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
    }

    // Perform Depth First Search. Time complexity : O(V+E)
    void doDFS(int n){
        boolean[] visited = new boolean[size()];
        Stack<Integer> stk = new Stack<>();
        stk.push(n);
        while(!stk.isEmpty()) {
            n = stk.pop();
            if(!visited[n]) {
                visited[n] = true;
                System.out.print(n + " ");
            }
            ReverseIterator<Integer> it = new ReverseIterator<>(adjacencyList.get(n));
            while(it.hasNext()){
                int i = it.next();
                if(!visited[i]){
                    stk.push(i);
                }
            }

            /*     Alternate Iterative Solution ...
            If you don't reverse adjacency list of corresponding node.
            Then also it will do DFS but from last node. Output will be different
            from what we get from recursive solution.

            Collections.reverse(adjacencyList.get(n));
            for (int i : adjacencyList.get(n)) {
                if (!visited[i]) {
                    stk.push(i);
                }
            }
            */
        }
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
        boolean[] visited = new boolean[size()];
        DFS(v, visited);
    }

    int size(){
        return adjacencyList.size();
    }

    int motherVertex(int n){
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[size()];
        
        stk.push(n);
        int count = 0;
        while(!stk.isEmpty()){
            int k = stk.pop();
            if(!visited[k]){
                visited[k] = true;
                ++count;
            }

            ReverseIterator<Integer> it = new ReverseIterator<>(adjacencyList.get(k));
            while(it.hasNext()){
                int i = it.next();
                if(!visited[i]){
                    stk.push(i);
                }
            }
        }
        
        return count==size()?n:-1;
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
    Time complexity : O(V+E)
    */
    void printGraph(){
        for(int u = 0; u<size(); ++u){
            System.out.print("Adjacency List for "+ u);
            for(int v : adjacencyList.get(u)){
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph input = new Graph(6);

        input.addEdge(0,1);
        input.addEdge(0,2);
        input.addEdge(0,3);
        input.addEdge(1,2);
        input.addEdge(1,3);
        input.addEdge(1,4);
        input.addEdge(2,5);
        input.addEdge(0,5);

        input.printGraph();

        System.out.print("\n BFS : ");
        input.doBFS(0);

        System.out.print("\n DFS : ");
        input.doDFS(0);

        System.out.print("\n DFS Recursive : ");
        input.recursiveDFS(0);

        // Find Mother Vertex. Time complexity : O(V(V+E))
        for(int i = 0; i< input.size(); ++i){
            if(input.motherVertex(i)==i) {
                System.out.println("\n\n Mother vertex : " + i);
                break;
            }
        }

        // Kosaraju's Strongly Connected Component Algorithm. Time complexity : O(V+E)
        // System.out.println(input.kosaraju());
    }
}
