package org.example.dp;

import java.util.Scanner;

public class CoinCombinations_I {
    int n;
    int sum;
    int[]options;

    public CoinCombinations_I(int n, int sum, int[] options) {
        this.n = n;
        this.sum = sum;
        this.options = options;
    }
    private int solve() {
        return solveHelper(sum,options);
    }

    private int solveHelper(int sum, int[] options) {
        if(sum==0) return 1;
        if(sum<0) return 0;
        int result =0;
        for(int o: options){
            result += solveHelper(sum-o,options);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = input.nextInt();
        int[]options = new int[n];
        for(int i=0; i<n;i ++){
            options[i] = input.nextInt();
        }
        CoinCombinations_I coinCombinationsI = new CoinCombinations_I(n,sum,options);
        int result = coinCombinationsI.solve();
        System.out.println(result);
    }
}
