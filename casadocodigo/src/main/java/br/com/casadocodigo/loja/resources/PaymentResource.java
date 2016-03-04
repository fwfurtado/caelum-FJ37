package br.com.casadocodigo.loja.resources;

import br.com.casadocodigo.loja.configuration.ConfigureJMSDestinations;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
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
import java.net.URI;

/**
 * Created by Nando on 29/02/16.
 */

@Path("payment")
public class PaymentResource {


    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executor;

    @Inject
    private JMSContext jmsContext;

    @Resource(name = ConfigureJMSDestinations.PAYMENT_INTEGRATION_QUEUE_JNDI)
    private Destination paymentQueue;

    @Context
    private ServletContext context;


    @POST
    public void pay(@Suspended final AsyncResponse ar, @QueryParam("uuid") String uuid){
        String contextPath = context.getContextPath();

        JMSProducer producer = jmsContext.createProducer();

        executor.submit(()->{

            try {

                System.out.println("        ******** Enviado para fila de Pagamentos ********        ");
                producer.send(paymentQueue, uuid);
                System.out.println("        ******** Pagamento Concluído com sucesso ********        ");

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
