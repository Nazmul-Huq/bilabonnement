package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Author Nazmul
 */
@Repository
public interface CheckAddAlarm<T>{

    List<T> getOutdatedEntities(Date date);

    List<T> getUnpaidEntities();

    List<T> getRecentAlarmsByType(AlarmType alarmType);

}
