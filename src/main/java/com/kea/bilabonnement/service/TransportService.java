package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.sql.Date;

/**
 * Author Nazmul
 */

public class TransportService {

    // create necessary instances
    private final BilabonnementCRUD<Transport> transportRepo;

    public TransportService(BilabonnementCRUD<Transport> transportRepo) {
        this.transportRepo = transportRepo;
    }


    /**
     * add a given transport
     * @param transport
     * @return
     */
    public boolean addTransport(Transport transport) {
        return transportRepo.addEntity(transport);
    }

    /**
     * end a transport by setting the delivery date from null to the actual date the car was delivered
     * @param id
     * @param deliveryDate
     * @return
     */
    public boolean endATransport(int id, Date deliveryDate) {
        Transport transportToUpdate = transportRepo.getSingleEntityById(id);
        if (transportToUpdate.getId() != 0) {
            transportToUpdate.setDeliveryDate(deliveryDate);
            return transportRepo.updateEntity(transportToUpdate);
        }
        return false;
    }

}
