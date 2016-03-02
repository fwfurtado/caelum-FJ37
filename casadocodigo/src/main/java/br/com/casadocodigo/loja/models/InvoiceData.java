package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

/**
 * Created by Nando on 01/03/16.
 */
public class InvoiceData {
    private BigDecimal value;
    private String buyerEmail;


    public InvoiceData(Checkout checkout) {
        value = checkout.getValue();
        buyerEmail = checkout.getBuyer().getEmail();
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }
}
