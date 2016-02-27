package br.com.casadocodigo.loja.managedbeans.site;

import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.daos.SystemUserDAO;
import br.com.casadocodigo.loja.managedbeans.services.PaymentGateway;
import br.com.casadocodigo.loja.models.Checkout;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.SystemUser;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * Created by Nando on 24/02/16.
 */
@Model
public class CheckoutBean {

    private SystemUser systemUser = new SystemUser();

    @Inject
    private SystemUserDAO systemUserDAO;

    @Inject
    private CheckoutDAO checkoutDAO;

    @Inject
    private ShoppingCart cart;

    @Inject
    private PaymentGateway paymentGateway;

    public SystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SystemUser systemUser) {
        this.systemUser = systemUser;
    }

    @Transactional
    public void checkout() {
        systemUserDAO.save(systemUser);
        Checkout checkout = new Checkout(systemUser, cart);
        checkoutDAO.save(checkout);

        String resultado = paymentGateway.pay(cart.getTotal());

        System.out.println(resultado);

    }
}
