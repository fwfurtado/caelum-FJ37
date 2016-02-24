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

    @Deprecated
    public BookDAO() {}

    public BookDAO(EntityManager manager){
        this.manager = manager;
    }


    public void save(Book book){
        manager.persist(book);
    }

    public List<Book> list(){
        return manager.createQuery("select distinct b from Book b join fetch b.authors", Book.class).getResultList();
    }

    public List<Book> lastReleases() {
        return manager.createQuery("select b from Book b where b.releaseDate <= CURRENT_DATE order by b.releaseDate desc ", Book.class).setMaxResults(3).getResultList();
    }


    public List<Book> olderBooks() {
        return manager.createQuery("select b from Book b", Book.class).setMaxResults(20).getResultList();
    }

    public Book findById(Integer id) {
        return manager.find(Book.class, id);
    }
}
