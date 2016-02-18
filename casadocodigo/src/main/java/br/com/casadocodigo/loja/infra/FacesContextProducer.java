package br.com.casadocodigo.loja.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 * Created by Nando on 18/02/16.
 */
@ApplicationScoped
public class FacesContextProducer {

    @Produces
    @RequestScoped
    public FacesContext get(){
        return FacesContext.getCurrentInstance();
    }

}
