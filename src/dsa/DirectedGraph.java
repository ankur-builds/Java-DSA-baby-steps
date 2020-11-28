/*
 * Copyright (c) 2020.
 * File : DirectedGraph.java
 * Author : Ankur
 * Last modified : 28/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

import java.util.*;

public class DirectedGraph {
    public byte[][] adjacencyMatrix;
    public ArrayList<ArrayList<Integer>> adjacencyList;

    public DirectedGraph(int v){
        adjacencyList = new ArrayList<>();
        for(int i = 1; i<=v; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyMatrix = new byte[v][v];
    }

    public DirectedGraph(int v, byte[][] matrix){
        adjacencyList = new ArrayList<>();
        for(int i = 1; i<=v; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyMatrix = matrix;
    }

    public void addEdge(int u, int v){
        adjacencyList.get(u).add(v);
    }

    // Perform Breadth First Search. Time complexity : O(V+E)
    public void doBFS(int n){
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

    public void DFS(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adjacencyList.get(v)) {
            if (!visited[n])
                DFS(n, visited);
        }
    }

    public void recursiveDFS(int v)
    {
        boolean[] visited = new boolean[size()];
        DFS(v, visited);
    }

    public int size(){
        return adjacencyList.size();
    }

    public void printGraph(){
        for(int u = 0; u<size(); ++u){
            System.out.print("Adjacency List for "+ u);
            for(int v : adjacencyList.get(u)){
                System.out.print(" -> " + v);
            }
            System.out.println();
        }
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[size()];

        for(int i = 0; i<size(); ++i){
            if(!visited[i]){
                boolean[] outbound = new boolean[size()];
                if(cyclicUtil(i, visited, outbound))
                    return true;
            }
        }
        return false;
    }

    boolean cyclicUtil(int v, boolean[] visited, boolean[] outbound){
        if(outbound[v]) // visited[v] is obv true so no need to double check
            return true;

        if(visited[v]) // Intelligent check!!! to ensure every adjacency list is iterated only once.
            return false;

        visited[v] = true;
        for (int n : adjacencyList.get(v)) {
            if(!outbound[v])
                outbound[v] = true;
            if(cyclicUtil(n, visited, outbound))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DirectedGraph input = new DirectedGraph(5);

        // 0 ---> 3 ---> 4 ----> 2
        //   ---> 1 -----------> 2
        input.addEdge(0,1);
        input.addEdge(0,3);
        input.addEdge(1,2);
        input.addEdge(3,4);
        input.addEdge(4,2);

        input.printGraph();
        System.out.println(input.isCyclic()?"Cyclic":"Non-Cyclic");
        input.addEdge(2,0); // Lets turn non-cyclic to cyclic
        System.out.println(input.isCyclic()?"Cyclic":"Non-Cyclic");
    }
}
