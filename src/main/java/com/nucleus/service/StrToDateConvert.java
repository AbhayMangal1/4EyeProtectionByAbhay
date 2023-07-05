package com.nucleus.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrToDateConvert {
    public static Date formatDate(String date) {
        Date d = null;
        try {
            String createDate = date.trim();
            d = new SimpleDateFormat("dd/MMM/yyyy").parse(createDate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("current date : "+ d.toString());
        return d;
    }

    public static String nToNewConvert(String str){
        str = "New";
        return str;
    }
}
