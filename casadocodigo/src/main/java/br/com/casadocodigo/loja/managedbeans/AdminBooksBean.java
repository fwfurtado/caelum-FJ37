package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by Nando on 15/02/16.
 */
@Model
public class AdminBooksBean {

    private Book product = new Book();

    @Inject
    private BookDAO dao;


    public void save(){
        dao.save(product);
    }

    public Book getProduct() {
        return product;
    }
}
