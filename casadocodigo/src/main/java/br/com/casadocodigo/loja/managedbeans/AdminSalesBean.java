package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.models.Book;
import br.com.casadocodigo.loja.models.Sale;
import br.com.casadocodigo.loja.websockets.ConnectedUsers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 * Created by Nando on 04/03/16.
 */
@Model
public class AdminSalesBean {

    private Sale sale;

    @Inject
    private ConnectedUsers connectedUsers;

    public void save(){

        System.out.println(sale.toJson());

        connectedUsers.send(sale.toJson());
        System.out.println("gravado com sucesso");
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @PostConstruct
    public void load(){
        sale = new Sale();
        sale.setBook(new Book());
    }



}
