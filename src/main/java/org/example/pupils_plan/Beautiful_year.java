package org.example.pupils_plan;

import java.util.HashSet;
import java.util.Scanner;

public class Beautiful_year {
    int year;
    public Beautiful_year(int year) {
        this.year = year;
    }
    private void solve() {
        year++;
        String yearString = String.valueOf(year);
        while (!distinctYear(yearString)){
            year++;
            yearString = String.valueOf(year);
        }
        System.out.println(year--);
    }
    private boolean distinctYear(String yearString) {
        HashSet<Character> database = new HashSet<>();
        for(char c: yearString.toCharArray()){
            if(!database.add(c)){
                return false;
            }
        }
        return true;

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        Beautiful_year wayTooLongWords = new Beautiful_year(year);
        input.close();
        wayTooLongWords.solve();
    }
}
