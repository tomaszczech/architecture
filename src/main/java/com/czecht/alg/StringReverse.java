package com.czecht.alg;

import java.io.IOException;

public class StringReverse {

    public static void main(String[] args) throws IOException {
        System.out.println(new String("abc").equals("abc"));

        System.out.println(new String("abc") == "abc");

        System.out.println(new String("abc") == new String("abc"));

        System.out.println("abc" == "abc");


        String str = "dupa";
        System.out.println(reverse(str));
    }

    static String reverse(String str) {
        System.out.println("reverse(" + str + ")");
        if (str.length() == 1) {
            return str;
        }
        else {
            String tmpResult = reverse(str.substring(1)) + str.charAt(0);
            System.out.println("Krok: " + tmpResult);
            return tmpResult;
        }
    }
}
