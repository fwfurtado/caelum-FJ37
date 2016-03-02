package br.com.casadocodigo.loja.services;

import br.com.casadocodigo.loja.models.Checkout;
import br.com.casadocodigo.loja.models.InvoiceData;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

/**
 * Created by Nando on 01/03/16.
 */
public class InvoiceGenerator {
    public void invoiceFor(Checkout checkout) {
        Client client = ClientBuilder.newClient();

        InvoiceData invoiceData = new InvoiceData(checkout);

        String uriToGenerateInvoice = "http://book-payment.herokuapp.com/invoice";

        Entity<InvoiceData> json = Entity.json(invoiceData);

        client.target(uriToGenerateInvoice).request().post(json, String.class);
    }
}
