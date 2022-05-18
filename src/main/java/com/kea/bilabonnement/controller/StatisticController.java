package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.repo.StatisticRepo;
import com.kea.bilabonnement.repo.StatisticRepoImpl;
import com.kea.bilabonnement.service.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    // instantiate necessary objects
    StatisticRepo statisticRepo = new StatisticRepoImpl();
    private final StatisticService statisticService = new StatisticService(statisticRepo);

    /**
     * make view for average renting time
     * @param model
     * @return
     */
    @GetMapping("/average-renting-time")
    public String averageRentingTime(Model model){
        double averageRentingTime = statisticService.getAverageRentingTime();
        model.addAttribute("averageRentingTimeInDays", averageRentingTime);
        return "/statistic/average-renting-time";
    }

    /**
     * make view for average pay time
     * @param model
     * @return
     */
    @GetMapping("/average-pay-time")
    public String averagePayTime(Model model){
        double averagePayTime = statisticService.getAveragePayTime();
        model.addAttribute("averagePayTimeInDays", averagePayTime);
        return "/statistic/average-pay-time";
    }

} // class ends here
