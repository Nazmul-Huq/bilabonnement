package com.kea.bilabonnement.service;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CheckAddAlarm;
import com.kea.bilabonnement.utility.DateTimeHandler;
//import com.kea.bilabonnement.utility.DateTimeHandler;

import java.util.List;

/**
 * Author Nazmul
 */

public class AutomaticAlarmGeneratorService {

    // instantiate necessary objects via constructor
    CheckAddAlarm<Invoice> invoiceCheckAddAlarm;
    CheckAddAlarm<Transport> transportCheckAddAlarm;
    BilabonnementCRUD<Alarm> alarmRepo;
    DateTimeHandler dateTimeHandler;

    public AutomaticAlarmGeneratorService(
            CheckAddAlarm<Invoice> invoiceCheckAddAlarm,
            CheckAddAlarm<Transport> transportCheckAddAlarm,
            BilabonnementCRUD<Alarm> alarmRepo,
            DateTimeHandler dateTimeHandler)
    {
        this.invoiceCheckAddAlarm = invoiceCheckAddAlarm;
        this.transportCheckAddAlarm = transportCheckAddAlarm;
        this.alarmRepo = alarmRepo;
        this.dateTimeHandler = dateTimeHandler;
    }

    // call all methods, to check and make alarm
    public void generateAlarm(){
        generatePaymentAlarm();
        generateTransportAlarm();
    }

    /**
     * check and make alarm for outdated payment
     */

    public void generatePaymentAlarm(){
        // get a list of outdated payments
        List<Invoice> invoices = invoiceCheckAddAlarm.getOutdatedEntities(dateTimeHandler.getYesterdayDate());
        for (Invoice invoice:invoices) {
            // make and add alarm for each outdated payment
            String alarmDescription = "payment missing for Invoice Number: " + invoice.getInvoiceNumber() + ", Customer Id:  " + invoice.getCustomerId() + ", Agreement Number:  "+ invoice.getAgreementNumber();
            Alarm alarm = new Alarm(alarmDescription, dateTimeHandler.getSqlTodayDate(), "accountant", AlarmType.payment, invoice.getCarRegNumber());
            alarmRepo.addEntity(alarm);
        }
    }

    /**
     * check and make alarm for any outdated undelivered job
     */

    public void generateTransportAlarm(){
        // get a list of outdated undelivered job
        List<Transport> transports = transportCheckAddAlarm.getOutdatedEntities(dateTimeHandler.getYesterdayDate());
        for (Transport transport:transports) {
            // make and add alarm for each outdated undelivered job
            String alarmDescription = "Delivery pending for Transport Number: " + transport.getId() + ", Delivery time:  " + transport.getDeliveryDeadline() + ", Car registration number:  " + transport.getCarRegNumber();
            Alarm alarm = new Alarm(alarmDescription, dateTimeHandler.getSqlTodayDate(), "manager", AlarmType.transport, transport.getCarRegNumber());
            alarmRepo.addEntity(alarm);
        }
    }

} // class ends here
