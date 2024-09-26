package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class GridPaths {
    int n;
    char[][] matrix;
    int [][] memo;


    public GridPaths(int n, char[][] matrix) {
        this.n = n;
        this.matrix = matrix;
        this.memo = new int [n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
    }
    private int solve() {
        return solveHelper(0,0);
    }

    private int solveHelper(int i, int i1) {
        if(i==n-1 && i1==n-1 && !(matrix[i][i1] == '*')){
            return 1;
        }
        if(memo[i][i1]!=-1){
            return memo[i][i1];
        }
        if(i+1<n && !(matrix[i+1][i1] == '*')){
            if( i1+1<n && !(matrix[i][i1+1] == '*')){
                 memo[i][i1] = solveHelper(i,i1+1) +solveHelper(i+1,i1);
                return memo[i][i1];
            }
            memo[i][i1] =  solveHelper(i+1,i1);
            return memo[i][i1];
        }
        if( i1+1<n && !(matrix[i][i1+1] == '*')) {
            memo[i][i1] =  solveHelper(i, i1 + 1);
            return memo[i][i1];
        }
        memo[i][i1] =0;
        return  memo[i][i1];
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        char [][] matrix = new char[n][n];
        for(int i=0; i<n;i ++){
            String li = input.next();
            for(int j=0; j<n;j++)
             matrix[i][j] = li.charAt(j);
        }
        GridPaths gridPaths = new GridPaths(n,matrix);
        int result = gridPaths.solve();
        System.out.println(result);
    }
}
