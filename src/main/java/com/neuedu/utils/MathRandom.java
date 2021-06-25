package com.neuedu.utils;

public class MathRandom {

    public static int getRandomInt(int num1, int num2) {
        int n = num1 + (int) (Math.random() * (num2 - num1));
        return n;
    }

}
