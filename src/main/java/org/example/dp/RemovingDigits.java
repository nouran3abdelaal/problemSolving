package org.example.dp;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {

    static int [] memo;
    public static int[] convertToArray(int num) {
        // Convert the number to a string
        String numStr = Integer.toString(num);

        // Create an int array to store the digits
        int[] digits = new int[numStr.length()];

        // Iterate over the characters in the string
        for (int i = 0; i < numStr.length(); i++) {
            // Convert each character to its integer value
            digits[i] = numStr.charAt(i) - '0';  // '0' has an ASCII value of 48, so we subtract it
        }

        return digits;
    }

    public static int helper(int sum) {
        if(sum==0) {
            return 0;
        }
        int [] digits = convertToArray(sum);
//        System.out.println(Arrays.toString(digits));
        int minVal= Integer.MAX_VALUE;
        int tmp=0;
       for(int d:digits){
           if(d!=0){
               tmp=1+helper(sum-d);
               minVal=Math.min(tmp, minVal);
           }
       }
        return minVal==Integer.MAX_VALUE || minVal== 0?-1:minVal;
    }


    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        int sum = input.nextInt();
        input.close();
        memo= new int[sum+1];
        System.out.print(helper(sum));
    }
}

