package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.SystemRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Nando on 04/03/16.
 */
public class SystemRoleDAO {

    @PersistenceContext
    private EntityManager manager;

    public List<SystemRole> list(){
        return manager.createQuery("select s from SystemRole s", SystemRole.class).getResultList();
    }

}
