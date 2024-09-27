package org.example.dp;

import java.util.Scanner;

public class WhereistheGhost {
    int n;
    public WhereistheGhost(int n) {
        this.n = n;
    }

    public  int dp(int i,int val) {
        if(val%2520==0) {
            return 1;
        }
        if(i>n) {
            return 0;
        }

        return dp(i+1, val)+dp(i+1,val*i);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       int n = input.nextInt();
        input.close();
        WhereistheGhost whereistheGhost = new WhereistheGhost(n);
        System.out.println( whereistheGhost.dp(1,1));


    }

}

