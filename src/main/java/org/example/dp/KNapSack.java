package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

 class KNapSack {
    int n; int weight;
    int[] weights;
    int[] values;
    int [][] memo;

     KNapSack(int n, int weight, int[] weights, int[] values) {
        this.n = n;
        this.weight =weight;
        this.values = values;
        this.weights =weights;
        this.memo = new int [n][weight+1];
        for(int[]m : memo) Arrays.fill(m,-1);
    }
    private int solve() {

        return solveHelper(0,0);
    }

    private int solveHelper(int i, int wightSoFar) {
        if(i>n-1)return 0;
        if(memo[i][wightSoFar]!=-1) return memo[i][wightSoFar];
        if(weights[i]+wightSoFar>weight){
            memo[i][wightSoFar] = solveHelper(i+1,wightSoFar);
            return memo[i][wightSoFar];
        }
        memo[i][wightSoFar] = Math.max(values[i] + solveHelper(i+1,weights[i]+wightSoFar),solveHelper(i+1,wightSoFar));
        return memo[i][wightSoFar] ;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int weight = input.nextInt();
        int[] weights= new int [n];;
        int[] values= new int [n];;
        for(int i=0; i<n; i++){
            weights[i]= input.nextInt();
            values[i]= input.nextInt();
        }
        input.close();
        KNapSack kNapSack = new KNapSack(n,weight,weights,values);
        System.out.println(n);
        System.out.println(Arrays.toString(weights));
        System.out.println(Arrays.toString(values));


        int result = kNapSack.solve();
       System.out.println(result);

    }



}
