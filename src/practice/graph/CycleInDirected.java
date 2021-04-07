/*
 * Copyright (c) 2021.
 * File : DirectedGraph.java
 * Author : Ankur
 * Last modified : 30/11/2020
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.graph;

import dsa.Graph;

public class CycleInDirected extends Graph {
    public CycleInDirected(int v){
        super(v);
    }

    @Override
    public void addEdge(int u, int v){
        adjacencyList.get(u).add(v);
        adjacencyMatrix[u][v] = 1;
    }

    public boolean isCyclic(){
        boolean[] visited = new boolean[size()];

        // Iterate over each connected components.
        for(int i = 0; i<size(); ++i){
            if(!visited[i]){
                boolean[] outbound = new boolean[size()];
                if(cyclicUtil(i, visited, outbound))
                    return true;
            }
        }
        return false;
    }

    /*
    In a directed graph we just need to check if there is an outbound link to other node in that "connected
    component" << This is the reason why we are reinitializing outbound array in each iteration in line 33
    as each iteration indicates a new connected component
     */
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
        CycleInDirected input = new CycleInDirected(5);

        // 0 ---> 3 ---> 4 ----> 2
        //   ---> 1 -----------> 2
        input.addEdge(0,1);
        input.addEdge(0,3);
        input.addEdge(1,2);
        input.addEdge(3,4);
        input.addEdge(4,2);

        System.out.println(input.isCyclic()?"Cyclic":"Non-Cyclic");
        input.addEdge(2,0); // Lets turn non-cyclic to cyclic
        System.out.println(input.isCyclic()?"Cyclic":"Non-Cyclic");
    }
}
