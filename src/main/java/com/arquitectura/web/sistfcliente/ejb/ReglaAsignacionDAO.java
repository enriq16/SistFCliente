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
}
