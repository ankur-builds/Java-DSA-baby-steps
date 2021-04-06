/*
 * Copyright (c) 2021.
 * File : TopologicalSort.java
 * Author : Ankur
 * Last modified : 7/4/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.graph;
import dsa.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
                            Directed Acyclic Graph
   A DAG is a graph that flows in one direction, where no element can be a child of itself.
   https://ericsink.com/vcbe/html/directed_acyclic_graphs.html
*/

/*
    There can be more than one topological sorting for a graph.
    The first vertex in topological sorting is always a vertex with in-degree as 0
    (a vertex with no incoming edges).
*/
public class TopologicalSort extends Graph{

    TopologicalSort(int v){
        super(v);
    }

    @Override
    public void addEdge(int u, int v){
        adjacencyList.get(u).add(v);
    }

    public int getInDegree(int vertex){
        int inDegree = 0;
        for(int i = 0; i<size(); ++i){
            if(adjacencyList.get(i).contains(vertex))
                inDegree++;
        }
        return inDegree;
    }


    public void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        int[] indegree = new int[size()];
        int[] sorted = new int[size()];

        for(int i = 0; i<size(); ++i){
            indegree[i] = getInDegree(i);
            if(indegree[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int v = q.poll();
            for(int i : adjacencyList.get(v)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
            sorted[count++] = v;
        }

        if(count==size())
            System.out.println("Topologically sorted list : " + Arrays.toString(sorted));
        else
            System.out.println("Topological Sorting not possible as Graph as cycles.");
    }

    public static void main(String[] args) {
        TopologicalSort input = new TopologicalSort(8);
        input.addEdge(0,1);
        input.addEdge(0,2);
        input.addEdge(0,3);
        input.addEdge(1,2);
        input.addEdge(1,3);
        input.addEdge(1,4);
        input.addEdge(2,5);
        input.addEdge(0,5);
        input.addEdge(6,7);

        input.printGraph();

        for(int i = 0; i<8; ++i) {
            System.out.println("Vertex : " + i + ", indegree -> " + input.getInDegree(i) + " :: outdegree -> " + input.adjacencyList.get(i).size());
        }

        System.out.println();
        input.topologicalSort();
    }
}
