
package com.arquitectura.web.sistfcliente.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="ConceptoUsoPuntos")//como referirse a la clase en el hql(query de jpa)
@Table(name ="concepto_uso")//nombre de la tabla en la bd
public class ConceptoUsoPuntos implements Serializable {
    @Id
    @Basic(optional = false )
    @Column(name="id")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @Basic(optional=false, fetch=FetchType.EAGER)    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_concepto")        
    String  concepto;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos_requeridos")
    Integer puntosRequeridos;

    public ConceptoUsoPuntos() {
    }

    public ConceptoUsoPuntos(Integer id, String concepto, Integer puntosRequeridos) {
        this.id = id;
        this.concepto = concepto;
        this.puntosRequeridos = puntosRequeridos;
    }

    public Integer getId() {
        return id;
    }

    public String getConcepto() {
        return concepto;
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public void setPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }
    
    
}
