
package com.arquitectura.web.sistfcliente.entity;


public class ConceptoUsoPuntos {
    Integer id;
    String  concepto;
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
