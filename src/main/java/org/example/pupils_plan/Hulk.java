package org.example.pupils_plan;

import java.util.Scanner;

public class Hulk {
    int n;

    public Hulk(int n) {
        this.n = n;
    }
    private String solve() {
        String result = "";
        for(int i =1; i<=n; i++){
            if(i%2==0){
                result+= "I love ";
            }else{
                result+= "I hate ";
            }
            if(i==n){
                result+= "it";
            }else{
                result+= "that ";

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Hulk hulk = new Hulk(n);
        input.close();
        System.out.println(hulk.solve());
    }
}
