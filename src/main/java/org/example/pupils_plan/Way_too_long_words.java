package org.example.pupils_plan;

import java.util.Scanner;

public class Way_too_long_words {
     String[] texts;

    public Way_too_long_words(String[] texts) {
        this.texts = texts;
    }
    private void solveOneText(String text) {
        if(text.length()<10 ){
            System.out.println(text);
            return;
        }
        int size = text.length()-2;
        System.out.println(text.charAt(0)+""+size+text.charAt(text.length()-1));
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
        Way_too_long_words wayTooLongWords = new Way_too_long_words(inputs);
        input.close();
        wayTooLongWords.solve();
    }
}
