package br.com.casadocodigo.loja.managedbeans.login;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Nando on 03/03/16.
 */
@Model
public class LoginBean {

    @Inject
    private HttpServletRequest request;

    public void login(){
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();

        System.out.println(servletRegistrations);
    }

}
