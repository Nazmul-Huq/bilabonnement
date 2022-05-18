package com.kea.bilabonnement.utility;

import org.springframework.stereotype.Service;

import java.sql.Date;


/**
 * Author Nazmul
 */

@Service
public class DateTimeHandler {

    public java.sql.Date getSqlTodayDate(){
        java.util.Date date = new java.util.Date();
        Date sqlDate = new Date(date.getTime());
        return sqlDate;
    }


    public java.util.Date getYesterdayDate(){
        return new java.util.Date(System.currentTimeMillis()-24*60*60*1000);
    }
} // class ends here
