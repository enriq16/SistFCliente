/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquiterctura.web.sisfcliente.util;

/**
 *
 * @author Enrique
 */
public class DatosCargaPuntos {
    private Integer idCliente;
    private Float montoOp;

    public DatosCargaPuntos() {
    }

    public DatosCargaPuntos(Integer idCliente, Float montoOp) {
        this.idCliente = idCliente;
        this.montoOp = montoOp;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Float getMontoOp() {
        return montoOp;
    }

    public void setMontoOp(Float montoOp) {
        this.montoOp = montoOp;
    }
    
    
}
