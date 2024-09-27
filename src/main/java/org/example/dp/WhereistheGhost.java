package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class WhereistheGhost {
    int n;
    int [][] memo;
    public WhereistheGhost(int n) {
        this.n = n;
        this.memo = new int[n+1][2520];
        for (int i=1;i<=n+1;i++){
            Arrays.fill(memo[i-1],-1);
        }
    }

    public int dp(int i,int val) {
        if(val==0) {
            return 1;
        }
        if(i>n) {
            return 0;
        }
        if(memo[i][val]!=-1){
            return memo[i][val];
        }
        memo[i][val] = dp(i+1, val)+dp(i+1,(val*i)%2520);
        return memo[i][val];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       int n = input.nextInt();
        input.close();
        WhereistheGhost whereistheGhost = new WhereistheGhost(n);
        System.out.println( whereistheGhost.dp(1,1));


    }

}

