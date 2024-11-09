package org.example.pupils_plan;

import java.util.Arrays;
import java.util.Scanner;

public class Wet_shark_and_odd_and_even {
    long[] numbers;

    public Wet_shark_and_odd_and_even(long[] numbers) {
        this.numbers = numbers;
    }
    private long solve() {
        long result = Arrays.stream(numbers).sum();
        if(result%2!=0){
            int i =0;
            while(numbers[i]%2==0){
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
        long[] intArray = new long[n];
        for (int i=0;i<n;i++){
            intArray[i] = input.nextLong();
        }
        Arrays.sort(intArray);
        Wet_shark_and_odd_and_even wetSharkAndOddAndEven = new Wet_shark_and_odd_and_even(intArray);
        input.close();
        System.out.println(wetSharkAndOddAndEven.solve());
    }
}
