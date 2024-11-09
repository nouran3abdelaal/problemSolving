package org.example.pupils_plan;

import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int subResult = 0;
        int result = 0;
        for(int i=0;i<n;i++) {
            subResult = 0;
            for (int j = 0; j < 3; j++) {
                subResult+= input.nextInt();
            }
            result+= subResult>=2?1:0;

        }
        input.close();
        System.out.println(result);
    }

}
