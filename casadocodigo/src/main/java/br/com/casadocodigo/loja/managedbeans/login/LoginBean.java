package br.com.casadocodigo.loja.managedbeans.login;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nando on 03/03/16.
 */
@Model
public class LoginBean {

    @Inject
    private HttpServletRequest request;

    private String username;
    private String password;


    @PostConstruct
    public void load(){

        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());

        try {
            request.logout();
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    public void  login(){

        try {
            request.login(username,password);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }



    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
