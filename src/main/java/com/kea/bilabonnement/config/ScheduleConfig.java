package com.kea.bilabonnement.config;


import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.repo.*;
import com.kea.bilabonnement.service.AutomaticAlarmGeneratorService;
import com.kea.bilabonnement.utility.DateTimeHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * Author Nazmul
 */

@Configuration
@EnableScheduling
public class ScheduleConfig {

    // instantiate necessary objects
    CheckAddAlarm<Invoice> invoiceCheckAddAlarm = new InvoiceRepo();
    CheckAddAlarm<Transport> transportCheckAddAlarm = new TransportRepo();
    BilabonnementCRUD<Alarm> alarmRepo = new AlarmRepo();
    DateTimeHandler dateTimeHandler = new DateTimeHandler();
    AutomaticAlarmGeneratorService automaticAlarmGeneratorService = new AutomaticAlarmGeneratorService(
            invoiceCheckAddAlarm,
            transportCheckAddAlarm,
            alarmRepo,
            dateTimeHandler);

    /**
     * Schedule the task in a defined time
     * (in this case every night at 03.00 o'clock)
     * to change the time, open application.properties file and change 'cronExpression' detail
     */
    @Scheduled(cron = "${cronExpression}")
    public void scheduleTaskUsingCronExpression() {
        automaticAlarmGeneratorService.generateAlarm();
    }

}
