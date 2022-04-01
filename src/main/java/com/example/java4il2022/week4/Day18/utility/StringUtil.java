package com.example.java4il2022.week4.Day18.utility;

import org.springframework.stereotype.Component;

public class StringUtil {

    private StringUtil() {}

    public static String reverseString(String str) {
        if(str == null) {
            throw new IllegalArgumentException("..");
        }
        return new StringBuilder(str).reverse().toString();
    }
}
