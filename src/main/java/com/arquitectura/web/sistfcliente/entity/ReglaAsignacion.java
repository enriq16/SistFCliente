
package com.arquitectura.web.sistfcliente.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Karen
 */
@Entity(name="ReglaAsigancion")
@Table(name="regla_asignacion")
public class ReglaAsignacion {

    @Id
    @Column (name="id")
    @Basic (optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
 
    @Column (name="limite_inf")
    @Basic (optional = false)
    private Integer limiteInf;

    @Column (name="limite_sup")
    @Basic (optional = false)
    private Integer limiteSup; 
 
    @Column (name="monto_eq_punto")
    @Basic (optional = false)
    private Integer montoEqPunto;

    public ReglaAsignacion() {
    }

    public ReglaAsignacion(Integer id) {
        this.id = id;
    }

    public ReglaAsignacion(Integer id, Integer limiteInf, Integer limiteSup, Integer montoEqPunto) {
        this.id = id;
        this.limiteInf = limiteInf;
        this.limiteSup = limiteSup;
        this.montoEqPunto = montoEqPunto;
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

    @Override
    public String toString() {
        return "ReglaAsignacion{"+"id= '"+id+"', limiteInf= '"+limiteInf+"',"
                + " limiteSup= '"+limiteSup+"', montoEqPunto= '"+montoEqPunto+"'}";
    }
}


