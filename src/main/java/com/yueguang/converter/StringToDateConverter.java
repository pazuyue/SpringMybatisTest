package com.yueguang.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {

    private String datePattern;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    public Date convert(String date) {
        try {
            System.out.println("date:"+date);
            System.out.println("datePattern:"+this.datePattern);

            SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
            return dateFormat.parse(date);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("日期转换失败");
            return null;
        }

    }

}
