package org.example.pupils_plan;

import java.util.Scanner;

public class Square_string {
    static String[] texts;

    public Square_string(String[] texts) {
        this.texts = texts;
    }
    private void solveOneText(String text) {
        if(text.length()%2 != 0){
            System.out.println("No");
            return;
        }
        int middle = text.length()/2;
        for(int i=0;i<middle;i++){
            if(text.charAt(i)!=text.charAt(i+middle)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
    private void solve() {
       for(String text: texts){
           solveOneText(text);
       }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String [] inputs = new String[n];
        for(int i=0;i<n;i++){
            inputs[i] = input.next();
        }
        Square_string squareString = new Square_string(inputs);
        input.close();
        squareString.solve();
    }


}
