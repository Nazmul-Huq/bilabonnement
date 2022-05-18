package com.kea.bilabonnement.service;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CheckAddAlarm;

import java.util.List;

/**
 * Author Nazmul
 */

public class AlarmService {

    // instantiate necessary objects via constructor
    BilabonnementCRUD<Alarm> alarmCrudRepo;
    CheckAddAlarm<Alarm> checkAddAlarm;

    public AlarmService(BilabonnementCRUD<Alarm> alarmCrudRepo, CheckAddAlarm<Alarm> checkAddAlarm) {
        this.alarmCrudRepo = alarmCrudRepo;
        this.checkAddAlarm = checkAddAlarm;
    }

    /**
     * get a list of recent all type of alarm and send to model
     * * @return
     */
    public List<Alarm> seeRecentAlarms() {
        //return checkAddAlarm.getRecentAlarm();
        return alarmCrudRepo.getAllEntities();
    }

    /**
     * get a list of recent payment alarm and send to model
     * @return
     */
    public List<Alarm> seePaymentAlarms() {
        return checkAddAlarm.getRecentAlarmsByType(AlarmType.payment);
    }

    /**
     * get a list of recent transport alarm and send to model
     * @return
     */
    public List<Alarm> seeTransportAlarms() {
        return checkAddAlarm.getRecentAlarmsByType(AlarmType.transport);
    }

} // class ends here
