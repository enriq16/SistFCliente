/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.ejb;

import com.arquitectura.web.sistfcliente.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */

@Stateless
public class ClienteDAO {
    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;
    
    public void agregar(Cliente cliente){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        em.persist(cliente);
        tr.commit();
        
        System.out.println("Cliente: "+cliente.toString());        
    }
    
    public void update(Cliente cliente){
        Cliente c = em.find(Cliente.class, cliente.getId());
        
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setNroDoc(cliente.getNroDoc());
        c.setTipDoc(cliente.getTipDoc());
        c.setNacionalidad(cliente.getNacionalidad());
        c.setEmail(cliente.getEmail());
        c.setTelefono(cliente.getTelefono());
        c.setFechaNacimiento(cliente.getFechaNacimiento());
        
        tr.commit();                
    }

    public List<Cliente> listar(){
        Query q = em.createQuery("select c from Cliente c");
        return (List<Cliente>) q.getResultList();
    }
    
}
