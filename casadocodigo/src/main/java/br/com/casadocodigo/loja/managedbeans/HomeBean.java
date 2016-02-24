package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Nando on 23/02/16.
 */
@Model
public class HomeBean {

    @Inject
    private BookDAO bookDAO;


    public List<Book> lastReleases(){
        return  bookDAO.lastReleases();
    }

    public List<Book> olderBooks(){
        return bookDAO.olderBooks();
    }
}
