package com.kea.bilabonnement.test;

import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.StatisticRepo;
import com.kea.bilabonnement.service.LeaseService;
import com.kea.bilabonnement.service.StatisticService;
import com.kea.bilabonnement.testrepo.LeaseTestRepo;
import com.kea.bilabonnement.testrepo.StatisticRepoTest;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author Nazmul
 */


public class StatisticServiceTest {



    @Test
    void getAveragePayTimeTest() {
        //Arrange
       StatisticRepo statisticRepo = new StatisticRepoTest();
       StatisticService statisticService = new StatisticService(statisticRepo);
       double testAveragePayTime = 10.0;



        //Assign
        double averagePayTime = statisticService.getAveragePayTime();

        //Assert
        assertEquals(averagePayTime, testAveragePayTime);

    }
}
