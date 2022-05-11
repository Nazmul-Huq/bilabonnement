package com.kea.bilabonnement.service;

/**
 * Author Nazmul
 */

public class AutomaticAlarmGeneratorService {

    // call all methods, to run all check all alarm type
    public void runAllAlarm(){
        generatePaymentAlarm();
    }

    public void generatePaymentAlarm(){
        System.out.println("Check if alarm work or not");
    }

}
