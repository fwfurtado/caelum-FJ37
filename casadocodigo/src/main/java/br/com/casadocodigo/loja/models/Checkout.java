package br.com.casadocodigo.loja.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by Nando on 25/02/16.
 */
@Entity
public class Checkout {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SystemUser buyer;

    private BigDecimal value;

    private String jsonCart;

    private String uuid;

    @Deprecated
    protected Checkout(){}


    public Checkout(SystemUser systemUser, ShoppingCart cart){
        this.buyer = systemUser;
        this.value = cart.getTotal();
        this.jsonCart = cart.toJson();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SystemUser getBuyer() {
        return buyer;
    }

    public void setBuyer(SystemUser buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getJsonCart() {
        return jsonCart;
    }

    public void setJsonCart(String jsonCart) {
        this.jsonCart = jsonCart;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    public void prePersist(){
        this.uuid = UUID.randomUUID().toString();
    }

}
