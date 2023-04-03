/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.ejb;


import com.arquitectura.web.sistfcliente.entity.BolsaPuntos;
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
public class BolsaPuntosDAO {
    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;
    
    public void cargaPuntos(BolsaPuntos nuevo){
        em.persist(nuevo);
    }
       
    public void updatePuntos(BolsaPuntos bolsa/*, int cant*/){
        /*
        BolsaPuntos c = em.find(BolsaPuntos.class, bolsa.getId());
        
        if(c.getPuntoAsignado() >= c.getPuntoUtilizado()+cant){
            c.setPuntoUtilizado(c.getPuntoUtilizado()+cant);
            c.setPuntoSaldo(c.getPuntoSaldo()-(c.getPuntoUtilizado()+cant));
        }else{
            c.setPuntoUtilizado(c.getPuntoAsignado());
            c.setPuntoSaldo(0);
        }
        */        
        em.persist(bolsa);
    }
    
    public List<BolsaPuntos> listarPuntos(Integer idCliente){
        Query q = em.createQuery("select b from BolsaPuntos b where b.cliente.id = :idCliente order by b.id");
        q.setParameter("idCliente", idCliente);
        return (List<BolsaPuntos>) q.getResultList();        
    }
        
}
