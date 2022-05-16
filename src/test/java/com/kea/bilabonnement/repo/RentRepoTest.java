package com.kea.bilabonnement.repo;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RentRepoTest {

    @Test
    void writeToFile() throws IOException {

        //Arrange
        FileWriter fileWriter = new FileWriter("agreement.txt");
        String testLine = "Hej med dig";


    }
}