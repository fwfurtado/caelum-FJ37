package br.com.casadocodigo.loja.configuration;

import javax.jms.JMSDestinationDefinition;

/**
 * Created by Nando on 01/03/16.
 */

@JMSDestinationDefinition(
                            name = "java:/jms/topics/checkoutTopic",
                            interfaceName = "javax.jms.Topic"
                        )
public class ConfigureJMSDestinations {}
