package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Nando on 16/02/16.
 */
@Dependent
public class BookDAO {

    @PersistenceContext
    private EntityManager manager;


    public void save(Book book){
        manager.persist(book);
    }

    public List<Book> list(){
        return manager.createQuery("select distinct b from Book b join fetch b.authors", Book.class).getResultList();
    }

}
