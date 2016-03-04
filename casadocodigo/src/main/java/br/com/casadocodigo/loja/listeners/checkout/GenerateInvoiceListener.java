package br.com.casadocodigo.loja.listeners.checkout;

import br.com.casadocodigo.loja.configuration.ConfigureJMSDestinations;
import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.models.Checkout;
import br.com.casadocodigo.loja.services.InvoiceGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Nando on 01/03/16.
 */

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = ConfigureJMSDestinations.CHECKOUT_TOPIC_JNDI)
        }
)

public class GenerateInvoiceListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(GenerateInvoiceListener.class);

    @Inject
    private CheckoutDAO checkoutDAO;

    @Inject
    private InvoiceGenerator invoiceGenerator;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {

            logger.info("Generate Invoice UUID: ", textMessage.getText());

            Checkout checkout = checkoutDAO.findByUuid(textMessage.getText());

            invoiceGenerator.invoiceFor(checkout);


        }catch (Exception e){
            logger.error("Problema na geração da nota fiscal", e);
        }

    }
}
