package org.example.digitDP;

import java.util.Arrays;
import java.util.Scanner;

public class DigitSum {
    String k;
    int d;
    int [][][] memo;
    private static final int MOD = 1000000007;
    public DigitSum(String  k, int d) {
        this.k = k;
        this.d = d;
        memo = new int [2][k.length()][k.length()*d];
        for(int[][] a: memo){
            for(int []b: a){
                Arrays.fill(b,-1);
            }
        }
    }
    private int solve() {
        return solveHelper(0,1,0)-1;
    }

    private int solveHelper(int i, int r, int remainder) {
        if(i==k.length()) {
//            System.out.println(remainder%d ==0);
            return remainder%d ==0? 1 : 0;
        }
        if(memo[r][i][remainder]!=-1){
            return memo[r][i][remainder];
        }
        int upperLimit = r==1?k.charAt(i) - '0' : 9;
        int result =0;
        for(int l=0; l<=upperLimit; l++){
            result+= solveHelper(i+1,(r==1&&l==upperLimit)?1:0,remainder+(l%d));

        }
        if(result>=MOD) {
            result-=MOD;

        }
        memo[r][i][remainder] = result;
        return memo[r][i][remainder];

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String  k = input.next();
        int d = input.nextInt();
        input.close();
        DigitSum digitSum = new DigitSum(k,d);
        int result = digitSum.solve();
        System.out.println(result);

    }

}
