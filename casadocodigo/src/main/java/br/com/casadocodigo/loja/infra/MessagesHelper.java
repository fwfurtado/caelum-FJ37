package br.com.casadocodigo.loja.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Created by Nando on 18/02/16.
 */
@ApplicationScoped
public class MessagesHelper {

    @Inject
    private FacesContext context;



    public void addFlash(FacesMessage message){
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null,message);

    }
}
