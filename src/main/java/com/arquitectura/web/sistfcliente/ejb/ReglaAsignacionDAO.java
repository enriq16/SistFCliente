/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.ejb;

import com.arquitectura.web.sistfcliente.entity.Cliente;
import com.arquitectura.web.sistfcliente.entity.ReglaAsignacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author Enrique
 */
@Stateless
public class ReglaAsignacionDAO {
    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;
    
    public List<ReglaAsignacion> listar(){
        Query q = em.createQuery("select r from ReglaAsignacion r order by r.id ASC");
        return (List<ReglaAsignacion>) q.getResultList();
    }
    
    public void insert(ReglaAsignacion reg) {
        em.merge(reg);                
    }
    
    public void update(ReglaAsignacion reg){
        ReglaAsignacion aux = em.find(ReglaAsignacion.class, reg.getId());
        
        aux.setLimiteInf(reg.getLimiteInf());
        aux.setLimiteSup(reg.getLimiteSup());
        aux.setMontoEqPunto(reg.getMontoEqPunto());
        
        em.flush();
    }
    
    public void delete(ReglaAsignacion reg){
        System.out.println("Eliminando "+reg.toString());
        ReglaAsignacion aux = em.find(ReglaAsignacion.class, reg.getId());
        if(aux != null)
            em.remove(aux);
    }
}
