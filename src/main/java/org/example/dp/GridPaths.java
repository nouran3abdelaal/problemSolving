package org.example.dp;

import java.util.Scanner;

public class GridPaths {
    int n;
    String[][] matrix;

    public GridPaths(int n, String[][] matrix) {
        this.n = n;
        this.matrix = matrix;
    }
    private int solve() {
        return solveHelper(0,0);
    }

    private int solveHelper(int i, int i1) {
        if(i==n-1 && i1==n-1){
            return 1;
        }
        if(i+1<n && !matrix[i+1][i1].equals("*")){
            if( i1+1<n && !matrix[i][i1+1].equals("*")){
                return solveHelper(i,i1+1) +solveHelper(i+1,i1);
            }
            return solveHelper(i+1,i1);
        }
        if( i1+1<n && !matrix[i][i1+1].equals("*")) {
            return solveHelper(i, i1 + 1);
        }
        return  0;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [][] matrix = new String[n][n];
        for(int i=0; i<n;i ++){
            for(int j=0; j<n;j++)
             matrix[i][j] = input.next();
        }
        GridPaths gridPaths = new GridPaths(n,matrix);
        int result = gridPaths.solve();
        System.out.println(result);
    }
}
