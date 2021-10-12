/*
 * Copyright (c) 2021.
 * File : MergeIntervals.java
 * Author : Ankur
 * Last modified : 12/10/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.ops;

import java.util.*;

public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] arr){
        if(arr.length==0 || arr[0].length==0)
            return null;

        // Sort on first element
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        int[] last = {arr[0][0], arr[0][1]};
        for(int i = 1; i<arr.length; ++i){
            if(arr[i][0]<=arr[i-1][1] || arr[i][0]==arr[i-1][1]+1){
                arr[i][0] = arr[i-1][0];
                if(arr[i][1]<arr[i-1][1])
                    arr[i][1] = arr[i-1][1];
            } else {
                list.add(new int[]{arr[i - 1][0], arr[i - 1][1]});
            }

            last[0] = arr[i][0];
            last[1] = arr[i][1];
        }

        int n = list.size();
        if(list.isEmpty() || !(last[0]==list.get(n-1)[0] && last[1]==list.get(n-1)[1]))
            list.add(last);

        return list.toArray(new int[list.size()][]);
    }

    public static int[][] merge(int[][] intervals) {
        System.out.println("---------------------");
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,10},{11,11},{15,20},{20,10000},{25,30}};
        int[][] arr1 = {{1,10},{10,11},{15,20},{20,10000},{25,30}};

        for(int[] a : mergeIntervals(arr)){
            System.out.println(Arrays.toString(a));
        }

        for(int[] a : merge(arr1)){
            System.out.println(Arrays.toString(a));
        }
    }
}
