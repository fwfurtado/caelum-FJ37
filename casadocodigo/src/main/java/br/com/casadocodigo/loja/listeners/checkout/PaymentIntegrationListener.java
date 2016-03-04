package br.com.casadocodigo.loja.listeners.checkout;

import br.com.casadocodigo.loja.configuration.ConfigureJMSDestinations;
import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.managedbeans.services.PaymentGateway;
import br.com.casadocodigo.loja.models.Checkout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import java.math.BigDecimal;

/**
 * Created by Nando on 04/03/16.
 */
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = ConfigureJMSDestinations.PAYMENT_INTEGRATION_QUEUE_JNDI)
        }
)
public class PaymentIntegrationListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(PaymentIntegrationListener.class);

    @Inject
    private JMSContext jmsContext;

    @Resource(name = ConfigureJMSDestinations.CHECKOUT_TOPIC_JNDI)
    private Destination checkoutTopic;

    @Inject
    private CheckoutDAO checkoutDAO;

    @Inject
    private PaymentGateway paymentGateway;

    @Override
    public void onMessage(Message message) {
        TextMessage uuid = (TextMessage) message;


        try {

            logger.info("Recebido Mensagem para integração com pagamento", uuid.getText());

            Checkout checkout = checkoutDAO.findByUuid(uuid.getText());

            BigDecimal value = checkout.getValue();

            paymentGateway.pay(value);

//            jmsContext.acknowledge();

            JMSProducer producer = jmsContext.createProducer();

            producer.send(checkoutTopic, uuid.getText());

        } catch (Exception e) {
            logger.error("Problema com a integração de pagamento", e);
        }

    }
}
