package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.models.Book;

import javax.enterprise.inject.Model;

/**
 * Created by Nando on 15/02/16.
 */
@Model
public class AdminBooksBean {

    private Book product = new Book();


    public void save(){
        System.out.println(product);
    }

    public Book getProduct() {
        return product;
    }
}
