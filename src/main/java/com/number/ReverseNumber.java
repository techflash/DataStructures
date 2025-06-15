package com.number;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int number) {
        int reversedNumber = 0;

        while (number > 0) {
            reversedNumber = reversedNumber + number % 10;

            number /= 10;
            if(number > 0) {
                reversedNumber *= 10;
            }


        }
        return reversedNumber;
    }
}


