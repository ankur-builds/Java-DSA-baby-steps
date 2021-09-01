/*
 * Copyright (c) 2021.
 * File : UnionFind.java
 * Author : Ankur
 * Last modified : 1/9/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package dsa;

public class UnionFind {
    public class QuickFind{
        private int[] id;
        QuickFind(int n){
            id = new int[n];
            for(int i = 0; i<id.length; ++i)
                id[i] = i;
        }

        public boolean find(int p, int q){
            return id[p]==id[q];
        }

        public void union(int p, int q){
            if(id[p]==id[q])
                return;

            int pid = id[p];
            int qid = id[q];

            for(int i = 0; i<id.length; ++i){
                if(id[i]==pid) // Putting id[p] instead of pid is a bug. Think why!
                    id[i] = qid;
            }
        }

    }

    public class QuickUnion{
        private int[] id;
        QuickUnion(int n){
            id = new int[n];
            for(int i = 0; i< id.length; ++i)
                id[i] = i;
        }

        public boolean find(int p, int q){
            return root(p)==root(q);
        }

        private int root(int x){
            while(x!=id[x]){
                x = id[x];
            }

            return x;
        }

        public void union(int p, int q){
            id[root(p)] = root(q);
        }
    }

    public class WeightedQuickUnion{
        private int[] id;
        private int[] sz;

        WeightedQuickUnion(int n){
            id = new int[n];
            sz = new int[n];

            for(int i = 0; i<n; ++i){
                id[i] = i;
                sz[i] = 1;
            }
        }

        public boolean find(int p, int q){
            return root(p)==root(q);
        }

        private int root(int x){
            while(x!=id[x]){
                x = id[x];
            }

            return x;
        }

        public void union(int p, int q){
            int i = root(p);
            int j = root(q);
            if(i==j) return;

            if(sz[i]<sz[j]){
                id[i] = j;
                sz[j] += sz[i];
            } else{
                id[j] = i;
                sz[i] += sz[j];
            }
        }
    }
}
