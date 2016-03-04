package br.com.casadocodigo.loja.configuration;

import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

/**
 * Created by Nando on 01/03/16.
 */
@JMSDestinationDefinitions({
        @JMSDestinationDefinition(
                                    name = ConfigureJMSDestinations.CHECKOUT_TOPIC_JNDI,
                                    interfaceName = "javax.jms.Topic"
        ),
        @JMSDestinationDefinition(
                                    name = ConfigureJMSDestinations.PAYMENT_INTEGRATION_QUEUE_JNDI,
                                    interfaceName = "javax.jms.Queue"
        )

})
public class ConfigureJMSDestinations {
        public static final String CHECKOUT_TOPIC_JNDI = "java:/jms/topics/checkoutTopic";
        public static final String PAYMENT_INTEGRATION_QUEUE_JNDI = "java:/jms/queues/paymentQueue";
}
