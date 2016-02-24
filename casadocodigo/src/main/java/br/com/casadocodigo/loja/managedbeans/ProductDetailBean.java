package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by Nando on 23/02/16.
 */
@Model
public class ProductDetailBean {

    @Inject
    private BookDAO bookDAO;
    private Book book;
    private Integer id;

    public void loadBook(){
        this.book = bookDAO.findById(id);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
