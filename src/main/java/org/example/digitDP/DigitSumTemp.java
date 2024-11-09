package org.example.digitDP;

import java.util.Arrays;
import java.util.Scanner;

public class DigitSumTemp {
    String k;
    int d;
    long [][][] memo;
    int mod = 1000000007;

    public DigitSumTemp(String  k, int d) {
        this.k = k;
        this.d = d;
        memo = new long [2][k.length()+5][d+5];
        for(long[][] a: memo){
            for(long []b: a){
                Arrays.fill(b,-1);
            }
        }
    }
    private long solve() {
        return solveHelper(0,1,0)-1;
    }

    private long solveHelper(int i, int r, int remainder) {
        if(i==k.length()) {
//            System.out.println(remainder%d ==0);
            return remainder ==0? 1 : 0;
        }
        if(memo[r][i][remainder]!=-1){
            return memo[r][i][remainder];
        }
        int upperLimit = r==1?k.charAt(i) - '0' : 9;
        int result =0;
        for(int l=0; l<=upperLimit; l++){
            memo[r][i][remainder]+= solveHelper(i+1,(r==1&&l==upperLimit)?1:0,(remainder+l)%d);
            if(memo[r][i][remainder]>=mod){
                memo[r][i][remainder]-=mod;
            }
        }
//        memo[r][i][remainder] = result;
        return memo[r][i][remainder];

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String  k = input.next();
        int d = input.nextInt();
        input.close();
        System.out.println(k+" "+d);
        DigitSumTemp digitSum = new DigitSumTemp(k,d);
        long result = digitSum.solve();
        System.out.println(result);

    }


}
