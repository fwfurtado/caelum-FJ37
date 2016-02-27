package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

/**
 * Created by Nando on 26/02/16.
 */
public class PaymentData {

    private final BigDecimal value;

    public PaymentData(BigDecimal total) {
        value = total;
    }

    public BigDecimal getValue() {
        return value;
    }
}
