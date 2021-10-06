/*
 * Copyright (c) 2021.
 * File : SearchInsert.java
 * Author : Ankur
 * Last modified : 29/9/2021
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package practice.search;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(mid==0)
                return mid;

            if(nums[mid-1]<target && target<=nums[mid])
                return mid;
            else if(nums[mid-1]>=target)
                right = mid-1;
            else
                left = mid+1;
        }

        return nums.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 7));

        System.out.println(searchInsert(arr, 0));

        System.out.println(searchInsert(arr, 2));

        System.out.println(searchInsert(arr, 4));
    }
}
