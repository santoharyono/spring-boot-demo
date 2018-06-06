package com.mitraiscdc.springmvcdemo.domain;

import javax.persistence.*;

@Entity
@Table(name = "unitofmeasure")
public class UnitOfMeasure extends BaseEntity {

    private String uom;

    public UnitOfMeasure() {
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
