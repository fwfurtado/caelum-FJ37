package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.SystemRoleDAO;
import br.com.casadocodigo.loja.daos.SystemUserDAO;
import br.com.casadocodigo.loja.models.SystemRole;
import br.com.casadocodigo.loja.models.SystemUser;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Nando on 04/03/16.
 */
@Model
public class AdminUserBean {

    @Inject
    private SystemUser user;

    @Inject
    private SystemUserDAO systemUserDAO;

    @Inject
    private SystemRoleDAO systemRoleDAO;

    private List<SystemRole> roles;

    private List<SystemUser> users;

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }


    public List<SystemRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SystemRole> roles) {
        this.roles = roles;
    }

    public List<SystemUser> getUsers() {
        return users;
    }

    public void setUsers(List<SystemUser> users) {
        this.users = users;
    }

    @PostConstruct
    public void load(){
        roles = systemRoleDAO.list();
        users = systemUserDAO.list();
    }


    @Transactional
    public void save(){
        users.add(user);
        systemUserDAO.save(user);
    }


    @Transactional
    public void delete(SystemUser user){
        users.remove(user);
        systemUserDAO.delete(user);
    }

}
