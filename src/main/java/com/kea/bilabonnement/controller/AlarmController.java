package com.kea.bilabonnement.controller;


import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.repo.AlarmRepo;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CheckAddAlarm;
import com.kea.bilabonnement.service.AlarmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author Nazmul
 */


@Controller
@RequestMapping(value = "/alarm")
public class AlarmController {

    // instantiate necessary object
    BilabonnementCRUD<Alarm> alarmCrudRepo = new AlarmRepo();
    CheckAddAlarm<Alarm> checkAddAlarm = new AlarmRepo();
    AlarmService alarmService = new AlarmService(alarmCrudRepo, checkAddAlarm);

    /**
     * show all type of recent alarm
     */
    @GetMapping("/see-recent-alarm")
    public String seeRecentAlarm(Model model){
        List<Alarm> alarmList = alarmService.seeRecentAlarms();
        model.addAttribute("recentAlarms", alarmList);
        //model.addAttribute("recentAlarms", alarmService.seeRecentAlarms());
        return "/alarm/see-recent-alarm";
    }

    /**
     * see recent payment alarm
     * @param model
     * @return
     */
    @GetMapping("/see-payment-alarm")
    public String seePaymentAlarm(Model model){
        model.addAttribute("paymentAlarms", alarmService.seePaymentAlarms());
        return "/alarm/see-payment-alarm";
    }

    /**
     * see recent transport alarm
     * @param model
     * @return
     */
    @GetMapping("/see-transport-alarm")
    public String seeTransportAlarm(Model model){
        List<Alarm> alarmList = alarmService.seeTransportAlarms();
        model.addAttribute("transportAlarms", alarmList);
        return "/alarm/see-transport-alarm";
    }

} // class ends here
