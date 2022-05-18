package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.InvoicePaymentDate;

import java.util.List;

/**
 * Author Nazmul
 */

public interface StatisticRepo {

    /**
     * get invoice and payment date
     * return them as a list of InvoicePaymentDate model
     * @return
     */
    List<InvoicePaymentDate> getAllInvoicePaymentDate();

    /**
     * get car registration and renting time as date
     * convert them to string and return them
     * @return
     */
    List<String> getAllTransportDeliveryTime();
}
