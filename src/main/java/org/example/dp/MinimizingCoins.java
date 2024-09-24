package org.example.dp;

import java.util.Scanner;

public class MinimizingCoins {
    public static int helper(int[] values, int sum) {
        if(sum==0) {
            return 0;
        }
        int minVal= Integer.MAX_VALUE;
        int tmp=0;
        for(int val: values) {
            if(sum-val>=0) {
                tmp=1+helper(values,sum-val);
                minVal=Math.min(tmp, minVal);
            }
        }

        return minVal==Integer.MAX_VALUE || minVal== 0?-1:minVal;
    }
        public static void main(String[] args) {
            // Create a Scanner object to read user input
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int sum = input.nextInt();
            int[] values= new int [n];
            for(int i=0; i<n; i++){
                values[i]= input.nextInt();
            }

            input.close();
            System.out.print(helper(values,sum));
        }
}
