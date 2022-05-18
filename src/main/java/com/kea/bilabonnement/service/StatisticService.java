package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.InvoicePaymentDate;
import com.kea.bilabonnement.repo.StatisticRepo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Nazmul
 */

public class StatisticService {

    // instantiate necessary objects
    private final StatisticRepo statisticRepo;

    public StatisticService(StatisticRepo statisticRepo) {
        this.statisticRepo = statisticRepo;
    }

    /**
     * get payment data by calling statistic repo
     * calculate average pay time and returned to controller
     * @return
     */
    public double getAveragePayTime() {
        // get invoice and payment date
        List<InvoicePaymentDate> invoicePaymentDates = statisticRepo.getAllInvoicePaymentDate();
        int totalDays = 0;
        double averagePayTime = 0.0;
        if (invoicePaymentDates.size() != 0) {
            // calculate average pay time
            for (InvoicePaymentDate date:invoicePaymentDates) {
                long diffInMillies = Math.abs(date.getPaymentDate().getTime() - date.getPaymentDeadline().getTime());
                int days = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                totalDays += days;
            }
            averagePayTime = totalDays / invoicePaymentDates.size();
        }
        return averagePayTime;
    }

    /**
     * get renting data by calling statistic repo
     * calculate average renting time and return to controller
     * @return
     */
    public double getAverageRentingTime() {
        // get cars registration and renting date as string
        List<String> lists = statisticRepo.getAllTransportDeliveryTime();
        int totalDays = 0;
        double averagePayTime = 0.0;
        if (lists.size() != 0) {
            for (String list:lists) {
                // convert string to date
                String[] carRegRent = list.split(":");
                LocalDate carRentDate = LocalDate.parse(carRegRent[0]);
                LocalDate carRegDate = LocalDate.parse(carRegRent[1]);

                //calculating number of days in between
                long noOfDaysBetween = ChronoUnit.DAYS.between(carRegDate, carRentDate);
                totalDays += noOfDaysBetween;
            }
            averagePayTime = totalDays/lists.size();
        }
        return averagePayTime;
    }

} // class ends here
