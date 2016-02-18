package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nando on 17/02/16.
 */
@Model
public class AdminListBookBeans {

    @Inject
    private BookDAO bookDAO;

    private List<Book> books = new ArrayList<>();


    @PostConstruct
    public void load(){
        books = bookDAO.list();
    }


    public List<Book> getBooks() {
        return books;
    }
}
