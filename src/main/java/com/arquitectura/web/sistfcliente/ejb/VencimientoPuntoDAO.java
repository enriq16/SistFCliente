/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.ejb;

import com.arquitectura.web.sistfcliente.entity.VencimientoPunto;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class VencimientoPuntoDAO {
    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;
    
    public VencimientoPunto getVencimientoActivo(){
        Query q = em.createQuery("select v from VencimientoPunto v where v.fechaFinVal IS NULL");
        VencimientoPunto v = (VencimientoPunto)q.getSingleResult();
        if(v == null)               
            throw new EntityNotFoundException("No existe parametro de vencimietno activo");
        return v;
    }
    
    public void addVencimiento(VencimientoPunto nuevo){
        Query q = em.createQuery("select v from VencimientoPunto v where v.fechaFinVal IS NULL");
        VencimientoPunto v = (VencimientoPunto)q.getSingleResult();
        v.setFechaFinVal(new Date());
        
        em.persist(nuevo);
        em.flush();
    }
    
    public void updateVencimiento(VencimientoPunto nuevo){
        VencimientoPunto x = em.find(VencimientoPunto.class, nuevo.getId());
        System.out.println("nuevo: "+nuevo);
        x.setFechaInicioVal(nuevo.getFechaInicioVal());
        
        x.setFechaFinVal(nuevo.getFechaFinVal());
        
        x.setCant(nuevo.getCant());
        
        em.flush();
    }
    
    public void deleteVencimiento(VencimientoPunto toDelete){
        VencimientoPunto x = em.find(VencimientoPunto.class, toDelete.getId());
        if(x!=null)
            em.remove(x);
    }
}
