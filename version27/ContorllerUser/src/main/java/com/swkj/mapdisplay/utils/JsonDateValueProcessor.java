package com.swkj.mapdisplay.utils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//将json时间转换成规定时间
public class JsonDateValueProcessor implements  JsonValueProcessor {
    private String pattern = "yyyy-MM-dd HH-mm-ss";
    @Override
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return process(o);
    }

    @Override
    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return process(o);
    }
    private Object process(Object o){
        if (o instanceof Date){
          SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern,Locale.UK);
          return simpleDateFormat.format(o);
        }
        return o == null ? "" : o.toString();
    }
}
