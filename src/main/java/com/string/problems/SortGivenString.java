package com.string.problems;

public class SortGivenString {
    public static void main(String[] args) {
        String str = "sunil";
        StringBuilder rev = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.charAt(i));
        }
    }
}
