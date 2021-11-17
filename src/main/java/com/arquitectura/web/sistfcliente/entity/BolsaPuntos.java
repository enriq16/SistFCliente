
package com.arquitectura.web.sistfcliente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Enrique
 
 */

@Entity(name="BolsaPuntos")//como referirse a la clase en el hql(query de jpa)
@Table(name ="bolsa_puntos")
public class BolsaPuntos implements Serializable{
    @Id
    @Basic(optional = false )
    @Column(name="id")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
            
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "fecha_asignacion" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaAsignacion;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "fecha_caducidad" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaCaducidad;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "punto_asignado", nullable=false)
    private Integer puntoAsignado;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "punto_utilizado", nullable=false)
    private Integer puntoUtilizado;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "punto_saldo", nullable=false)
    private Integer puntoSaldo;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "monto_op", nullable=false)
    private float montoOperacion;

    public BolsaPuntos() {
    }

    public BolsaPuntos(Integer id, Cliente cliente, Date fechaAsignacion, Date fechaCaducidad, Integer puntoAsignado, Integer puntoUtilizado, Integer puntoSaldo, float montoOperacion) {
        this.id = id;
        this.cliente = cliente;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaCaducidad = fechaCaducidad;
        this.puntoAsignado = puntoAsignado;
        this.puntoUtilizado = puntoUtilizado;
        this.puntoSaldo = puntoSaldo;
        this.montoOperacion = montoOperacion;
    }

    public Integer getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public Integer getPuntoAsignado() {
        return puntoAsignado;
    }

    public Integer getPuntoUtilizado() {
        return puntoUtilizado;
    }

    public Integer getPuntoSaldo() {
        return puntoSaldo;
    }

    public float getMontoOperacion() {
        return montoOperacion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setPuntoAsignado(Integer puntoAsignado) {
        this.puntoAsignado = puntoAsignado;
    }

    public void setPuntoUtilizado(Integer puntoUtilizado) {
        this.puntoUtilizado = puntoUtilizado;
    }

    public void setPuntoSaldo(Integer puntoSaldo) {
        this.puntoSaldo = puntoSaldo;
    }

    public void setMontoOperacion(float montoOperacion) {
        this.montoOperacion = montoOperacion;
    }        
}
