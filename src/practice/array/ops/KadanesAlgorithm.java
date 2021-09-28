/*
 * Copyright (c) 2021.
 * File : KadanesAlgorithm.java
 * Author : Ankur
 * Last modified : 28/9/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.ops;

public class KadanesAlgorithm {
    // Find the contiguous subarray which has the largest sum
    static public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = 0;

        for(int i = 0; i<nums.length; ++i){
            if(i==0)
                max = nums[0];
            else
                max = Math.max(nums[i], nums[i]+max);

            if(max>result)
                result = max;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; // 4,-1,2,1] has the largest sum = 6
        System.out.println(maxSubArray(arr));

        int[] arr1 = {1};
        System.out.println(maxSubArray(arr1));

        int[] arr2 = {-1};
        System.out.println(maxSubArray(arr2));
    }
}
