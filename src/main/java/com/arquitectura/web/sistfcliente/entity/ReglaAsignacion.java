/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arquitectura.web.sistfcliente.entity;

/**
 *
 * @author Karen
 */
public class ReglaAsignacion {

private Integer id;         
private Integer limiteInf;
private Integer limiteSup;    
private Integer montoEqPunto;

 public ReglaAsignacion() {
    }

    public ReglaAsignacion(Integer id) {
        this.id = id;
    }

public Integer getId() {
        return id;
    }
public Integer getLimiteInf() {
        return limiteInf;
    }
public Integer getLimiteSup() {
        return limiteSup;
    }
public Integer getMontoEqPunto() {
        return montoEqPunto;
    }
public void setId(Integer id) {
        this.id = id;
    }
public void setLimiteInf(Integer limiteInf) {
        this.limiteInf = limiteInf;
    }
public void setLimiteSup(Integer limiteSup) {
        this.limiteSup = limiteSup;
    }
public void setMontoEqPunto(Integer montoEqPunto) {
        this.montoEqPunto = montoEqPunto;
    }
}


