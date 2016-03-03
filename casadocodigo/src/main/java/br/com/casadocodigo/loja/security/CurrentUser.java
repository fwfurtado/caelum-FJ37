package br.com.casadocodigo.loja.security;

import br.com.casadocodigo.loja.models.SystemUser;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by Nando on 02/03/16.
 */
@Model
public class CurrentUser {

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityDAO securityDAO;

    private SystemUser systemUser;

    public SystemUser get(){
        return systemUser;
    }

    @PostConstruct
    private void load(){
        Principal principal = request.getUserPrincipal();

        if (principal != null){
            this.systemUser = securityDAO.loadUserByUserName(principal.getName());
        }
    }


    public boolean hasRole(String name){
        return request.isUserInRole(name);

    }
}
