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

    private int solveHelper(int i, int j) {
        if(i>n-1)return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(weights[i]+j>weight){
            memo[i][j] = solveHelper(i+1,j);
            return memo[i][j];
        }
        memo[i][j] = Math.max(values[i] + solveHelper(i+1,weights[i]+j),solveHelper(i+1,j));
        return memo[i][j] ;
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
