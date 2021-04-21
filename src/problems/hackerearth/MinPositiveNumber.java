package problems.hackerearth;

import java.util.*;

// https://www.hackerearth.com/challenges/competitive/april-circuits-21/algorithm/divide-array-3-10ef1aae/
public class MinPositiveNumber {
    static int max = 0;

    // Find the minimum non-negative number for this subarray
    private int mex(Map<Integer, Integer> m){
        int i = 0;
        while(i<=max){
            if(m.containsKey(i))
                i++;
            else
                return i;
        }

        return -1;
    }

    public int divideArrays(int[] arr){
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        for(int i = 0; i<arr.length; ++i){
            m2.put(arr[i], i);
        }

        for(int i = 0; i<arr.length; ++i){
            m1.put(arr[i], i);
            int num1 = mex(m1);

            m2.remove(arr[i], i);
            int num2 = mex(m2);
            if(num1 == num2 && num1 != -1)
                return i+1;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        MinPositiveNumber input = new MinPositiveNumber();
        int testcases = s.nextInt();
        while(testcases-- > 0){
            int n = s.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i<n; ++i){
                arr[i] = s.nextInt();
                if(arr[i]>max)
                    max = arr[i];
            }

            System.out.println(input.divideArrays(arr));
        }
    }
}