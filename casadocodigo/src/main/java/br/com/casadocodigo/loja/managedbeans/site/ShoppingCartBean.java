package br.com.casadocodigo.loja.managedbeans.site;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.ShoppingItem;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by Nando on 24/02/16.
 */
@Model
public class ShoppingCartBean {

    @Inject
    private ShoppingCart shoppingCart;

    @Inject
    private BookDAO bookDAO;


    public String add( Integer id){
        Book book = bookDAO.findById(id);
        ShoppingItem shoppingItem = new ShoppingItem(book);
        shoppingCart.add(shoppingItem);

        return "/site/carrinho.xhtml?faces-redirect=true";
    }

    public String remove(Integer id){
        Book book = bookDAO.findById(id);
        ShoppingItem shoppingItem = new ShoppingItem(book);
        shoppingCart.remove(shoppingItem);
        return "/site/carrinho.xhtml?faces-redirect=true";

    }


}
