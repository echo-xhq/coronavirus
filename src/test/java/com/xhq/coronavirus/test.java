package com.xhq.coronavirus;/*
Created by shkstart on 2020/3/9.
*/

import java.sql.Date;

public class test {

    public static void main(String[] args) {

        Date date=new Date(System.currentTimeMillis());
        System.out.println(date.getTime());
    for (int i=4;i>=0;i--){
        System.out.println(new Date(System.currentTimeMillis()-(i*86400000)));

    }



    }
}
