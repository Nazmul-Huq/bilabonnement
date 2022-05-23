package com.kea.bilabonnement.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BilabonnementCRUD <T>{

    //Create
    public boolean addEntity(T entity);

    //Read
    public T getSingleEntityById(int id);
    public List<T> getAllEntities();
    public List<T> getAllEntitiesById(int id);

    //Update
    public boolean updateEntity(T entity);

    //Delete
    public boolean deleteEntityById(int id);

}
