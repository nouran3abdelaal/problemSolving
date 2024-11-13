package org.example.pupils_plan;

import java.util.HashMap;
import java.util.Scanner;

public class Two_gram {
    String twoGramString;

    public Two_gram(String twoGramString) {
        this.twoGramString = twoGramString;
    }

    private void solve() {
        String maxSubString = "";
        int maxCount = 0;
        HashMap<String,Integer> database = new HashMap<>();
        for(int i=0; i<twoGramString.length()-1;i++){
            String subString = twoGramString.substring(i,i+2);
            database.put(subString,database.getOrDefault(subString,0)+1);
            int count = database.get(subString);
            if(count>maxCount){
                maxSubString = subString;
                maxCount = count;

            }
        }
//        System.out.println(database);
        System.out.println(maxSubString);

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String twoGramString = input.next();
        Two_gram twoGram = new Two_gram(twoGramString);
        input.close();
        twoGram.solve();
    }


}
