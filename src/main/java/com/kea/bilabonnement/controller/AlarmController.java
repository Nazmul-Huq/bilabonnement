package com.kea.bilabonnement.controller;


import com.kea.bilabonnement.utility.AutomaticTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlarmController {
    AutomaticTaskExecutor automaticTaskExecutor = new AutomaticTaskExecutor();

    @GetMapping("/alarm")
    public String alarmTest(){
        automaticTaskExecutor.task();
        return "redirect:/index";
    }

}
