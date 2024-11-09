package org.example.digitDP;

import java.util.Arrays;
import java.util.Scanner;

public class CountingNumbers {
        String n1;
        String  n2;
        int [][][] memo;
        private static final int MOD = 1000000007;
        public CountingNumbers(String  n1, String n2) {
            this.n1 = n2;
            this.n2 = n2;
//            memo = new int [2][k.length()][k.length()*d];
//            for(int[][] a: memo){
//                for(int []b: a){
//                    Arrays.fill(b,-1);
//                }
//            }
        }
        private int solve() {
            return solveHelper(0,1,1,10,false);
        }

        private int solveHelper(int i, int lowerLimit, int upperLimit, int previousDigit, boolean leadingZeros) {
            if(i==n1.length()) return 1;
            int ll = lowerLimit==1?n1.charAt(i) -'0':0;
            int ul = upperLimit==1?n2.charAt(i) -'0':9;

            for(int x=ll; x<=ul;x++){
                if(x==0){
                    if(previousDigit==0){
                        if(leadingZeros){
                            solveHelper(i+1,(lowerLimit==1&&x==ll)?1:0,(upperLimit==1&&x==ul)?1:0,x,leadingZeros);
                        }
                    }else {
                        solveHelper(i+1,(lowerLimit==1&&x==ll)?1:0,(upperLimit==1&&x==ul)?1:0,x,false);
                    }
                }else{
                    if(previousDigit!=x)
                      solveHelper(i+1,(lowerLimit==1&&x==ll)?1:0,(upperLimit==1&&x==ul)?1:0,x,false);

                }

            }

            return 0;
        }

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String  n1 = input.next();
            String n2 = input.next();
            input.close();
            while(n1.length()<n2.length()){
                n1 = '0'+ n1;
            }while(n2.length()<n1.length()){
                n2 = '0'+ n2;
            }
            System.out.println(n1 +" "+ n2);
            CountingNumbers countingNumbers = new CountingNumbers(n1,n2);
            int result = countingNumbers.solve();
            System.out.println(result);

        }

    }


