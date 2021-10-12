/*
 * Copyright (c) 2021.
 * File : ThreeSum.java
 * Author : Ankur
 * Last modified : 27/9/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.array.ops;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0; i<nums.length; ++i){
            if(i>0 && nums[i]==nums[i-1])
                continue;

            Set<Integer> s = new HashSet<>();
            int target = 0 - nums[i];

            for(int j = i+1; j<nums.length; ++j){
                if(s.contains(target-nums[j]) && nums[j]!=nums[j-1]){
                    output.add(Arrays.asList(nums[i], target-nums[j], nums[j]));
                }else{
                    s.add(nums[j]);
                }
            }
        }

        return output;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> threeSum = threeSum(nums);
        for(List<Integer> ll :  threeSum){
            System.out.println(ll);
        }
    }
}
