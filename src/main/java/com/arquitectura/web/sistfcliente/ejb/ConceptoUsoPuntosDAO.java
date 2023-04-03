/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.ejb;

import com.arquitectura.web.sistfcliente.entity.ConceptoUsoPuntos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class ConceptoUsoPuntosDAO {

    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;

    public ConceptoUsoPuntos findById(Integer id) {
        
        ConceptoUsoPuntos c = em.find(ConceptoUsoPuntos.class, id);
        if (c == null) {
            throw new EntityNotFoundException("No existe Concepto de uso de puntos con ID: " + id);
        }
        return c;
    }

    public void agregar(ConceptoUsoPuntos concepto) {
        em.persist(concepto);
        System.out.println("ConceptoUsoPuntos: " + concepto.toString());
    }

    public void delete(ConceptoUsoPuntos concepto) {
        concepto = findById(concepto.getId());
        em.remove(concepto);
    }

    public void update(ConceptoUsoPuntos concepto) {
        ConceptoUsoPuntos c = em.find(ConceptoUsoPuntos.class, concepto.getId());
        boolean b = em.contains(c);
        if(b)
            System.out.println("Esta en el Context");
        else
            System.out.println("No esta en el Context");
        
        c.setConcepto(concepto.getConcepto());
        c.setPuntosRequeridos(concepto.getPuntosRequeridos());

        em.flush();
    }

    public List<ConceptoUsoPuntos> listar() {
        Query q = em.createQuery("select c from ConceptoUsoPuntos c order by c.id ASC");
        return (List<ConceptoUsoPuntos>) q.getResultList();
    }
}
