package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.utility.FileHandler;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;

/**
 * Author Nazmul
 */

public class LeaseService {

    // instantiate necessary objects
    private final BilabonnementCRUD<Lease> leaseRepo;

    public LeaseService(BilabonnementCRUD<Lease> leaseRepo) {
        this.leaseRepo = leaseRepo;
    }


    // add a given lease to the database
    public boolean addLease(Lease lease) {
        return leaseRepo.addEntity(lease);
    }

    /**
     * finish a lease,
     * update the database
      * @param id
     * @param date
     * @param carRegNumber
     * @return
     */
    public boolean finishLease(int id, Date date, int carRegNumber) {
        Lease lease = new Lease(id, 0, null, null, date, null, carRegNumber);
        return leaseRepo.updateEntity(lease);
    }

    /**
     * save the registration certificate to the respected database
     * @param carRegNumber
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public boolean saveRegCertificateFile(int carRegNumber, MultipartFile multipartFile) {
        String fileName = String.valueOf(carRegNumber);
        FileHandler.saveFile(fileName, multipartFile);
        return true;

    }

} // class ends here
