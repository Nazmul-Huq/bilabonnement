package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.InvoicePaymentDate;
import com.kea.bilabonnement.repo.StatisticRepo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Author Nazmul
 */


public class StatisticRepoTest implements StatisticRepo {
    @Override
    public List<InvoicePaymentDate> getAllInvoicePaymentDate() {
        List<InvoicePaymentDate> list= new ArrayList<>();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            InvoicePaymentDate invoicePaymentDate1 = new InvoicePaymentDate(formatter.parse("01-05-2022"), formatter.parse("11-05-2022"));
            list.add(invoicePaymentDate1);

            InvoicePaymentDate invoicePaymentDate2 = new InvoicePaymentDate(formatter.parse("01-05-2022"), formatter.parse("11-05-2022"));
            list.add(invoicePaymentDate2);

            InvoicePaymentDate invoicePaymentDate3 = new InvoicePaymentDate(formatter.parse("01-05-2022"), formatter.parse("11-05-2022"));
            list.add(invoicePaymentDate3);

        } catch (ParseException e){

        }

        return list;
    }

    @Override
    public List<String> getAllTransportDeliveryTime() {
        return null;
    }
}
