package br.com.casadocodigo.loja.listeners.checkout;

import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.infra.MailSender;
import br.com.casadocodigo.loja.models.Checkout;
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
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topics/checkoutTopic")
        }
)
public class SendCheckoutEmailListener implements MessageListener{

    private Logger logger = LoggerFactory.getLogger(SendCheckoutEmailListener.class);

    @Inject
    private MailSender mailSender;

    @Inject
    private CheckoutDAO checkoutDAO;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try{

            logger.info("UUID: ", textMessage.getText());

            Checkout checkout = checkoutDAO.findByUuid(textMessage.getText());

            String emailBody = "<html><body>Compra realizada com sucesso. O código de acompanhamento é <strong>" + checkout.getUuid() + "</strong></body></hmlt>";
            mailSender.send("cursofj37@gmail.com", checkout.getBuyer().getEmail(), "Sua Compra foi registrada com sucesso", emailBody);
        }catch (Exception e){
            logger.error("Problema no envio de e-mail", e);
        }
    }

}
