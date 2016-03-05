package br.com.casadocodigo.loja.managedbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * Created by Nando on 04/03/16.
 */
@SessionScoped @Named
public class I18nBean implements Serializable {

    private Locale locale;

    @Inject
    private FacesContext context;

    @PostConstruct
    public void load(){
        this.locale = context.getApplication().getDefaultLocale();
    }

    public void changeLecale(String locale){
        this.locale = new Locale(locale);
    }

    public Locale getLocale() {
        return locale;
    }





}
