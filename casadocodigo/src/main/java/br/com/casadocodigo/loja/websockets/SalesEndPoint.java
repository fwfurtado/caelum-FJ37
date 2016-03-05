package br.com.casadocodigo.loja.websockets;

import javax.inject.Inject;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Nando on 04/03/16.
 */
@ServerEndpoint("/channel/sales")
public class SalesEndPoint {

    @Inject
    private ConnectedUsers connectedUsers;

    @OnOpen
    public void onNewUser(Session session){

        System.out.println(session);
        connectedUsers.add(session);
    }

}
