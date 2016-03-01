package br.com.casadocodigo.loja.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Nando on 29/02/16.
 */
public class BookList {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:8080/casadocodigo/services/books")
                .request(MediaType.APPLICATION_JSON).get();


        System.out.printf(response.readEntity(String.class));

    }

}


