package org.example.pupils_plan;

import java.util.Scanner;

public class Stones_on_the_table {
    String colors;
    public Stones_on_the_table(String colors) {
        this.colors= colors;
    }
    private void solve() {
        int result =0;
        for(int i=0;i<colors.length()-1;i++){
            if(colors.charAt(i)==colors.charAt(i+1)){
                result++;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String colors = input.next();
        Stones_on_the_table stonesOnTheTable = new Stones_on_the_table(colors);
        input.close();
        stonesOnTheTable.solve();
    }
}
