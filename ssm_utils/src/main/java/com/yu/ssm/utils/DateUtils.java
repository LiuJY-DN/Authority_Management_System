package com.yu.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateUtils {

    //日期转换成字符串
    public static String dateToString(Date date,String ft){
        SimpleDateFormat sdf = new SimpleDateFormat(ft);
        String format = sdf.format(date);
        return format;
    }

    //字符串转换成日期
    public static Date stringToDate(String str,String ft) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(ft);
        Date parse = sdf.parse(str);
        return parse;
    }

}
