package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by Nando on 16/02/16.
 */
@Dependent
public class BookDAO {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void save(Book book){
        manager.persist(book);
    }

}
