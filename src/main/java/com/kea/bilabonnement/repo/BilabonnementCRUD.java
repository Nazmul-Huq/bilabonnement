package com.kea.bilabonnement.repo;

import java.util.List;

public interface BilabonnementCRUD <T>{

    //Create
    public boolean addEntity(T entity);

    //Read
    public T getSingleEntityById(int id);
    public List<T> getallEntities();
    public List<T> getAllEntitiesById(int id);

    //Update
    public boolean updateEntity(T entity);

    //Delete
    public boolean deleteEntityById(int id);
}
