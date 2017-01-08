package cw.sas.dao.impl;

import cw.sas.dao.IDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Kithmal on 11/7/2015.
 */
public abstract class DaoImpl<T, PK extends Serializable> implements IDao<T, PK> {

    /* Persistence Entity class type. */
    protected Class<T> entityClass;

    /* Entity manager to perform DAO operations. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public DaoImpl() {

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }


    /*
     * Create Entity
     */
    public T create(T t) {

        this.entityManager.persist(t);
        return t;
    }


    /*
     * Read By Primary Key
     */
    public T read(PK id) {

        return this.entityManager.find(entityClass, id);
    }


    /*
     * Update Entity
     */
    public T update(T t) {

        return this.entityManager.merge(t);
    }


    /*
     *Delete Entity
     */
    public void delete(T t) {

        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }


    /*
     * Find All
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " c");
        return (List<T>) query.getResultList();
    }


}

