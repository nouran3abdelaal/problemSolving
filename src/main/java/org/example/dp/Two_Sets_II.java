package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Two_Sets_II {
    int n;
    int sum;
    int[]options;
    int [][] memo;


    public Two_Sets_II(int n, int sum, int[] options) {
        this.n = n;
        this.sum = sum;
        this.options = options;
        this.memo = new int[n+1][sum/2+1];
        for (int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
    }

    private int solve() {
        if(sum%2!=0){
            return 0;
        }
        return solveHelper(1, sum/2);
    }

    private int solveHelper(int i, int sum) {
        if(sum ==0) return 1;
        if(i>n|| sum<0){
            return 0;
        }
        if(memo[i][sum]!=-1){
            return memo[i][sum];
        }
        memo[i][sum] = solveHelper(i+1,sum) + solveHelper(i+1,sum-i);
        return memo[i][sum];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]options = new int[n];
        int sum =0;
        for(int i=0; i<n;i ++){
            options[i] = i+1;
        }
        input.close();
        sum = (n*(n+1))/2;
        System.out.println(Arrays.toString(options));
        System.out.println(sum);

        Two_Sets_II twoSetsIi = new Two_Sets_II(n,sum,options);
        int result = twoSetsIi.solve();
        System.out.println(result);
    }
}
