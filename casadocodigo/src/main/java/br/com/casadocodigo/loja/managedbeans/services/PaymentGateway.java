package br.com.casadocodigo.loja.managedbeans.services;

import br.com.casadocodigo.loja.models.PaymentData;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.math.BigDecimal;

/**
 * Created by Nando on 26/02/16.
 */
public class PaymentGateway {


    public String pay(BigDecimal total) {
        Client client = ClientBuilder.newClient();



        PaymentData paymentData = new PaymentData(total);
        String uriToPay = "http://book-payment.herokuapp.com/payment";
        Entity<PaymentData> json = Entity.json(paymentData);

        return client.target(uriToPay)
                .request()
                .post(json,String.class);

    }
}
