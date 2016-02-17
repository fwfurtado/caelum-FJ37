package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Nando on 17/02/16.
 */
public class AuthorDAO {

    @PersistenceContext
    EntityManager manager;

    public List<Author> list() {
        return manager.createQuery("select a from Author a", Author.class).getResultList();
    }
}
