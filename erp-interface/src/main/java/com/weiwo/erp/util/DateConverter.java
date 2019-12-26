package com.weiwo.erp.util;



import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {


    //支持转换的多种日期格式，可增加时间格式
    private final DateFormat[] dfs = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy年MM月dd日"),
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
    };

    @Override
    public Date convert(String source) {
        for(int i=0;i<dfs.length;i++) {
            try {
                return dfs[i].parse(source);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }
}
