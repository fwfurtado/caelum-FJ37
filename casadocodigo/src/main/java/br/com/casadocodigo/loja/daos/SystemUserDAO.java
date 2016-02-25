package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.SystemUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Nando on 24/02/16.
 */
public class SystemUserDAO {

    @PersistenceContext
    private EntityManager manager;


    public void save(SystemUser systemUser){
        manager.persist(systemUser);
    }
}
