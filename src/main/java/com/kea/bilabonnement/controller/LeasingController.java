package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.LeaseRepo;
import com.kea.bilabonnement.service.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/lease")
public class LeasingController {

    // instantiates necessary objects
    private final BilabonnementCRUD<Lease> leaseRepo = new LeaseRepo();
    private final LeaseService leaseService = new LeaseService(leaseRepo);


    // show register lease page
    @GetMapping("/register-lease")
    public String showRegisterLeasePage(){
        return "/lease/register-lease";
    }

    // handle lease registration
    @PostMapping ("/register-lease")
    public String registerLease(@ModelAttribute Lease lease){
        if (leaseService.addLease(lease)) {
            return "/success";
        } else {
            return "/error";
        }
    }

    // show finish lease page
    @GetMapping("/finish-lease")
    public String showFinishLeasePage(){
        return "/lease/finish-lease";
    }

    // handle finish lease
    @PostMapping ("/finish-lease")
    public String finishLease(
            //@ModelAttribute Lease lease,
            @RequestParam int id,
            @RequestParam Date leasingFinishDate,
            @RequestParam int carRegNumber,
            @RequestParam(required = false, value = "regCertificate") MultipartFile multipartFile
    ){
        // upload the file in the directory
        if (!(multipartFile.isEmpty())  && multipartFile != null) {
            leaseService.saveRegCertificateFile(carRegNumber, multipartFile);
        }

        // update the database
         if (leaseService.finishLease(id, leasingFinishDate, carRegNumber)) {
                return "/success";
            } else {
                return "/error";
            }
    }
} // class ends here
