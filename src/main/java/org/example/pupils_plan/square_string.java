package org.example.pupils_plan;

import java.util.Scanner;

public class square_string {
    static String[] texts;

    public square_string(String[] texts) {
        this.texts = texts;
    }
    private void solveOneText(String text) {
        if(text.length()%2 != 0){
            System.out.println("false");
            return;
        }
        int middle = text.length()/2;
        for(int i=0;i<middle;i++){
            if(text.charAt(i)!=text.charAt(i+middle)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
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
        square_string squareString = new square_string(inputs);
        input.close();
        squareString.solve();
    }


}
