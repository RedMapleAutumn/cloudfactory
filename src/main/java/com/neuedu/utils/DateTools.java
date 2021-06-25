package com.neuedu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTools {

        /**
         * 校验日期是否合法
         *
         * @param: 日期格式的字符串
         * @return: 真或假
         */
        public static boolean isValidDate(String str) {
            boolean convertSuccess = true;
            // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");// yyyyMMdd
            try {
                // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，
                // 比如2007/02/29会被接受，并转换成2007/03/01
                format.setLenient(false);
                format.parse(str);
            } catch (ParseException e) {
                // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
                convertSuccess = false;
            }
            return convertSuccess;
        }

        /**
         * 判断某个日期是否是距现在1年以内
         *
         * @param: 日期格式的字符串
         * @return: 真或假
         */
        public static boolean betweenDate(String d3)  {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");

            Calendar c = Calendar.getInstance();
            Date d = c.getTime();
            String day = simpleDateFormat.format(d);
//		System.out.println("当前日期：" + day);

//		c.add(Calendar.YEAR, -1);
//		Date d0 = c.getTime();
//		String day0 = simpleDateFormat.format(d0);
//		System.out.println("前1年日期：" + day0);

            Date date1 = null;
            Date date3 = null;
            try {
                date1 = simpleDateFormat.parse(day);
//		Date date2 = simpleDateFormat.parse(day0);

                date3 = simpleDateFormat.parse(d3);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date3.getTime() <= date1.getTime()) {

                return true;
            } else
                return false;
        }

        /**
         * 获取当前日期
         *
         * @param:
         * @return: 当前日期的字符串
         */
        public static String getCurrDate()  {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date d = c.getTime();
            String day = simpleDateFormat.format(d);

            return day;
        }

        public static String getDate() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMdd");
            Calendar c = Calendar.getInstance();
            Date d = c.getTime();
            String day = simpleDateFormat.format(d);

            return day;
        }
}

