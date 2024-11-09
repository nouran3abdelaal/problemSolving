package org.example.pupils_plan;

import java.util.Arrays;
import java.util.Scanner;

public class Wet_shark_and_odd_and_even {
    int[] numbers;

    public Wet_shark_and_odd_and_even(int[] numbers) {
        this.numbers = numbers;
    }
    private long solve() {
        long result = Arrays.stream(numbers).sum();
        System.out.println(Arrays.toString(numbers));

        if(result%2!=0){
            int i =0;
            while(numbers[i]%2==0){
                System.out.println(numbers[i]);
                i++;
            }
            if(i<numbers.length){
                result-=numbers[i];
            }else{
                result=0;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] intArray = new int[n];
        for (int i=0;i<n;i++){
            intArray[i] = input.nextInt();
        }
        Wet_shark_and_odd_and_even wetSharkAndOddAndEven = new Wet_shark_and_odd_and_even(intArray);
        input.close();
        System.out.println(wetSharkAndOddAndEven.solve());
    }
}
