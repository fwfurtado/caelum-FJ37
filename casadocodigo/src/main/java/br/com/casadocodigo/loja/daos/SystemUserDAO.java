package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.SystemUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Nando on 24/02/16.
 */
public class SystemUserDAO {

    @PersistenceContext
    private EntityManager manager;


    public void save(SystemUser systemUser){
        manager.persist(systemUser);
    }

    public List<SystemUser> list() {
        return manager.createQuery("select s from SystemUser s", SystemUser.class).getResultList();
    }

    public void delete(SystemUser user) {
        user = manager.merge(user);
        manager.remove(user);
    }
}
