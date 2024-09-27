package org.example.dp;
import java.util.Scanner;

public class LCS {

    static String s1;
    static String s2;
    static String [][]memo;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        s1 = input.next();
        s2 = input.next();
        input.close();

        memo = new String[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = "-1";
            }
        }
        System.out.println(dp(0,0));


    }

    public static String dp(int v1,int v2) {
        if(v1>=s1.length() || v2>=s2.length())
            return "";


        if(!memo[v1][v2].equals("-1")) {
            return memo[v1][v2];
        }

        if (s1.charAt(v1)==s2.charAt(v2))
            return s1.charAt(v1) +dp(v1+1,v2+1);


        memo[v1][v2]=findLongestString(dp(v1+1,v2) , dp(v1,v2+1) );
        return memo[v1][v2];

    }

    public static String findLongestString(String s1, String s2) {
        return Math.max(s1.length(), s2.length()) == s1.length() ? s1 : s2;
    }

}