package com.sgb.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ***
 * @create 2021-12-31 9:34
 */
public class MyDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
