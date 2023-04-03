
package com.arquitectura.web.sistfcliente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Karen
 */
@Entity (name="VencimientoPunto")
@Table (name="parametro_vencimiento_punto")

public class VencimientoPunto {

    @Id
    @Column (name="id")
    @Basic (optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "fecha_inicio_val" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaInicioVal;

    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "fecha_fin_val" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaFinVal;

    @Column (name="cant_dia_duracion")
    @Basic (optional = false)
    private Integer cant;
    
    public VencimientoPunto(){}

     public VencimientoPunto(Integer id) {
        this.id = id;
    }

    public VencimientoPunto(Integer id, Date fechaInicioVal, Date fechaFinVal, Integer cantDiaDuracion){
        this.id = id;
        this.fechaInicioVal = fechaInicioVal;
        this.fechaFinVal = fechaFinVal;
        this.cant = cantDiaDuracion;
    }
    public Integer getId() {
        return id;
    }

    public Date getFechaInicioVal() {
        return fechaInicioVal;
    }

    public Date getFechaFinVal() {
        return fechaFinVal;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaInicioVal(Date fechaInicioVal) {
        this.fechaInicioVal = fechaInicioVal;
    }

    public void setFechaFinVal(Date fechaFinVal) {
        this.fechaFinVal = fechaFinVal;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    

    @Override
    public String toString() {
        return "VencimientoPunto{"+"id= '"+id+"', fechaInicioVal= '"+fechaInicioVal+"',"
                 + " fechaFinVal= '"+fechaFinVal+"', " + "cantDiaDuracion= '"+cant+"''}";
    }
}
