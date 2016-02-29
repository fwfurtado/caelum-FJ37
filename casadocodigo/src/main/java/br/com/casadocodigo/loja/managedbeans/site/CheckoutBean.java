package br.com.casadocodigo.loja.managedbeans.site;

import br.com.casadocodigo.loja.daos.CheckoutDAO;
import br.com.casadocodigo.loja.daos.SystemUserDAO;
import br.com.casadocodigo.loja.managedbeans.services.PaymentGateway;
import br.com.casadocodigo.loja.models.Checkout;
import br.com.casadocodigo.loja.models.ShoppingCart;
import br.com.casadocodigo.loja.models.SystemUser;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
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

    @Inject
    private FacesContext facesContext;

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


        String  contextName = facesContext.getExternalContext().getContextName();

        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        response.setStatus(307);
        response.setHeader("Location", "/" + contextName + "/services/payment?uuid=" + checkout.getUuid());




    }
}
