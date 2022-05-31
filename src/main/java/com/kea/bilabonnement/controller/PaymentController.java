package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Payment;
import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaymentController {

    PaymentService paymentService = new PaymentService();

    @GetMapping("/rent/overview-of-payments.html")
    public String overviewOfPayments(Model model){
        model.addAttribute("showPayments", paymentService.getPaymentList());
        model.addAttribute("showTotalPayments", paymentService.getTotalPaymentList());
        return "/rent/overview-of-payments";
    }
}
