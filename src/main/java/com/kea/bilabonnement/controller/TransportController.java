package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.TransportRepo;
import com.kea.bilabonnement.service.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/transport")
public class TransportController {

    private final BilabonnementCRUD<Transport> transportRepo = new TransportRepo();
    private final TransportService transportService = new TransportService(transportRepo);

    @GetMapping("/order-transport")
    public String orderTransportForm(){
        return "/transport/order-transport";
    }

    @PostMapping("/order-transport")
    public String orderTransport(@ModelAttribute Transport transport){
        transportService.addTransport(transport);
        System.out.println(transport.getDeliveryDeadline());
        return "/success";
    }

    @GetMapping("/end-a-transport")
    public String endATransportForm(){
        return "/transport/end-a-transport";
    }

    @PostMapping("/end-a-transport")
    public String endATransport(
            @RequestParam int id,
            @RequestParam Date deliveryDate){
        if (transportService.endATransport(id, deliveryDate)) {
            return "/success";
        } else {
            return "/error";
        }

    }
}
