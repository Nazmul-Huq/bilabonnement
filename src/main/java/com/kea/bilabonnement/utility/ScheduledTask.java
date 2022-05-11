package com.kea.bilabonnement.utility;

import com.kea.bilabonnement.service.AutomaticAlarmGeneratorService;

import java.util.TimerTask;

/**
 * Author Nazmul
 */

public class ScheduledTask extends TimerTask {

    //instantiate AutomaticAlarmGeneratorService
    private final AutomaticAlarmGeneratorService automaticAlarmGeneratorService = new AutomaticAlarmGeneratorService();



    // override run() from TimerTask
    @Override
    public void run() {
        automaticAlarmGeneratorService.runAllAlarm();
    }
}
