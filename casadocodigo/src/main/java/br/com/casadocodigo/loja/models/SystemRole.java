package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nando on 02/03/16.
 */
@Entity
public class SystemRole {

    @Id
    private String name;

    public SystemRole() {
    }

    public SystemRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
