package com.kea.bilabonnement.utility;

import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Author Nazmul
 */

public class AutomaticTaskExecutor {

    // instantiate ScheduledTask
    private final ScheduledTask scheduledTask = new ScheduledTask();


    public Calendar getTimeOfDay(){
        Calendar timeOfDay = Calendar.getInstance();
        System.out.println(timeOfDay.getTime());
        timeOfDay.set(Calendar.HOUR_OF_DAY, 17);
        timeOfDay.set(Calendar.MINUTE, 13);
        timeOfDay.set(Calendar.SECOND, 0);
        System.out.println(timeOfDay.getTime());
        return timeOfDay;
    }

    public void task() {
        Timer timer = new Timer();
        timer.schedule(scheduledTask, getTimeOfDay().getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
    }


} // class ends here
