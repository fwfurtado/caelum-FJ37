package br.com.casadocodigo.loja.security;

import br.com.casadocodigo.loja.models.SystemUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Nando on 02/03/16.
 */
public class SecurityDAO {

    @PersistenceContext
    private EntityManager manager;

    public SystemUser loadUserByUserName(String userName) {
        return manager
                .createQuery("select s from SystemUser s where s.email = :login", SystemUser.class)
                .setParameter("login", userName)
                .getSingleResult();
    }
}
