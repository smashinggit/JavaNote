package com.cs.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/9 17:38
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * BigInteger类
 * 可以让超过Integer范围内的数据进行运算
 * <p>
 * <p>
 * <p>
 * BigDecimal类
 * 由于在运算的时候，float类型和double很容易丢失精度。所以，为了能精确的表示、计算浮点数，
 * Java提供了BigDecimal类
 * <p>
 * <p>
 * <p>
 * SimpleDateFormat
 * 年 y
 * 月 M
 * 日 d
 * 时 H
 * 分 m
 * 秒 s
 * 所以一般我们要这样书写”yyyy年MM月dd日 HH:mm:ss”
 * 就会得到相应的日期：比如 2016年08月17日 23:05:16
 */
public class BigIntegerDemo {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648

        //可以看到Integer的范围，如果我们超过Integer的范围，就要用BigInteger了
        //假如我们用Integer来创建一个超出它的范围的一个对象，那么肯定是报错的
        // Integer iii = new Integer("2147483648");// NumberFormatException

        BigInteger bigInteger = new BigInteger("2147483648");
        System.out.println("BigInteger :" + bigInteger);//BigInteger :2147483648

//        public BigInteger add(BigInteger val)：加
//        public BigInteger subtract(BigInteger val)：减
//        public BigInteger multiply(BigInteger val)：乘
//        public BigInteger divide(BigInteger val)：除
//        public BigInteger[] divideAndRemainder(BigInteger val)：返回商和余数的数组

        bigDecimal();
        date();
        calendar();

    }


    public static void bigDecimal() {

        System.out.println("0.09 + 0.01 = " + (0.09 + 0.01));  // 0.09999999999999999
        System.out.println("1.0 - 0.32 = " + (1.0 - 0.32));   //0.6799999999999999
        System.out.println("1.015 * 100 = " + (1.015 * 100));  // 101.49999999999999
        System.out.println("1.301 / 100 = " + (1.301 / 100));  //0.013009999999999999

        //因为float类型的数据存储和整数不一样导致的。 它们大部分的时候，都是带有有效数字位。
        //float类型和double很容易丢失精度，所以我们试试Java为我们提供的BigDecimal类
        BigDecimal b1 = new BigDecimal("0.09");
        BigDecimal b2 = new BigDecimal("0.01");
        System.out.println("b1.add(b2) = " + b1.add(b2));  //

        BigDecimal b3 = new BigDecimal("1.0");
        BigDecimal b4 = new BigDecimal("0.32");
        System.out.println(" b3.subtract(b4) = " + b3.subtract(b4));

        BigDecimal b5 = new BigDecimal("1.015");
        BigDecimal b6 = new BigDecimal("100");
        System.out.println("b5.multiply(b6) = " + b5.multiply(b6));

        BigDecimal b7 = new BigDecimal("1.301");
        BigDecimal b8 = new BigDecimal("100");
        System.out.println("b7.divide(b8) = " + b7.divide(b8));
        System.out.println("b7.divide(b8,3,BigDecimal.ROUND_HALF_UP) = " + b7.divide(b8, 3, BigDecimal.ROUND_HALF_UP));
        System.out.println("b7.divide(b8,8,BigDecimal.ROUND_HALF_UP) = " + b7.divide(b8, 8, BigDecimal.ROUND_HALF_UP));
    }

    public static void date() {
        Date date = new Date();
        System.out.println("date:" + date);


//  年 y
//  月 M
//  日 d
//  时 H
//  分 m
//  秒 s
//  所以一般我们要这样书写”yyyy年MM月dd日 HH:mm:ss”
//  就会得到相应的日期：比如 2016年08月17日 23:05:16
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");

        System.out.println("date format:   " + format.format(date));
        System.out.println("date format2:   " + format2.format(date));


        //计算出从出生到现在过了多少天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate = null;
        try {
            birthdayDate = sdf.parse("1991-07-05");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 通过该日期得到一个毫秒值
        long birthdayDateTime = birthdayDate.getTime();
        // 获取当前时间的毫秒值
        long nowTime = System.currentTimeMillis();
        // 用nowTime - myTime 得到一个毫秒值
        long time = nowTime - birthdayDateTime;

        // 把time 的毫秒值转换为天
        long day = time / 1000 / 60 / 60 / 24;
        long year = day / 365;
        System.out.println("你来到这个世界：" + day + "天" + "  " + year + "年");
    }


    private static void calendar() {
        // 其日历字段已由当前日期和时间初始化：
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);

        System.out.println(year + "年" + (month + 1) + "月" + date + "日");




    }

}
