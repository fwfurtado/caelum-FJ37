package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Checkout;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Nando on 25/02/16.
 */
public class CheckoutDAO {

    @PersistenceContext
    private EntityManager manager;

    public void save(Checkout checkout) {
        manager.persist(checkout);
    }

    public Checkout findByUuid(String uuid){
        return manager
                .createQuery("select c from Checkout c where c.uuid = :uui", Checkout.class)
                .setParameter("uui", uuid)
                .getSingleResult();
    }
}
