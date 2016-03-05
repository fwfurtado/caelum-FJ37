package br.com.casadocodigo.loja.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nando on 04/03/16.
 */
@ApplicationScoped
public class ConnectedUsers {

    private Set<Session> users = new HashSet<>();
    private Logger logger = LoggerFactory.getLogger(ConnectedUsers.class);

    public boolean add(Session session){
        return users.add(session);
    }

    public void send(String message){

        logger.info("Mensagem à ser enviada: {}", message);

        for (Session user:users ) {
            if (user.isOpen()) {
                try {
                    user.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    logger.error("Não foi possivel enviar uma mensagem para um cliente, {}", e);
                }
            }
            else {
                logger.info("Cliente não esta mais aberto");
            }
        }
    }

}
