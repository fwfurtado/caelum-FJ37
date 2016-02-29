package br.com.casadocodigo.loja.resources;

import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.managedbeans.services.PaymentGateway;
import br.com.casadocodigo.loja.models.Checkout;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.math.BigDecimal;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nando on 29/02/16.
 */

@Path("payment")
public class PaymentResource {

    private static ExecutorService executor = Executors.newFixedThreadPool(50);


    @Inject
    private CheckoutDAO checkoutDAO;

    @Inject
    private PaymentGateway paymentGateway;

    @Context
    private ServletContext context;


    @POST
    public void pay(@Suspended final AsyncResponse ar, @QueryParam("uuid") String uuid){
        String contextPath = context.getContextPath();

        executor.submit(()->{
            Checkout checkout = checkoutDAO.findByUuid(uuid);

            BigDecimal value = checkout.getValue();

            try {
                paymentGateway.pay(value);

                URI requestURI = UriBuilder
                                    .fromUri(contextPath + "/site/index.xhtml")
                                    .queryParam("msg", "Compra realizada com sucesso")
                                    .build();

                Response response = Response.seeOther(requestURI).build();

                ar.resume(response);

            }catch (Exception ex){
                ar.resume(new WebApplicationException(ex));
            }

        });
    }

}
