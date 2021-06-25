package com.neuedu.utils;

public class NumberTools {
    public static String getNumber(){
        StringBuffer num = new StringBuffer();
        num.append(DateTools.getDate());

        int number = new MathRandom().getRandomInt(0001, 9999);
        if(number<10) {
            num.append("000"+number);
        }
        if(number>=10&&number<100) {
            num.append("00"+number);
        }
        if(number>=100&&number<1000) {
            num.append("0"+number);
        }
        if(number>=1000&&number<10000) {
            num.append(number);
        }

        return num.toString();
    }
}
