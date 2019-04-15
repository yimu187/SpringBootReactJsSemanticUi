package com.example.demo;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parseWithDateFormat(String textToBeDate, String dateFormat) {
        Date result;
        DateFormat format = new SimpleDateFormat(dateFormat);
        try {
            if(StringUtils.hasText(textToBeDate)) {
                result = format.parse(textToBeDate);
            }else {
                result = null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            result = null;
        }
        return result;
    }
}
