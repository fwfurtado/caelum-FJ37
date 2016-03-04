package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nando on 17/02/16.
 */
@Model
@Stateful
public class AdminListBookBeans {


    private BookDAO bookDAO;

    private List<Book> books = new ArrayList<>();

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;


    @PostConstruct
    private void load(){
        bookDAO = new BookDAO(manager);
        books = bookDAO.list();
    }


    public List<Book> getBooks() {
        return books;
    }

}
