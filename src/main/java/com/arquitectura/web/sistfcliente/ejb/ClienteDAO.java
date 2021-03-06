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
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Enrique
 */

@Stateless
public class ClienteDAO {
    @PersistenceContext(unitName = "hibernate_jpa_pu")
    private EntityManager em;
    
    public Cliente findById(Integer id){
        Cliente c = em.find(Cliente.class, id);
        if(c == null){
            throw new EntityNotFoundException("No existe Cliente con ID: "+id);
        }
        return c;
    }
    
    public void agregar(Cliente cliente){
        em.persist(cliente);
                
        System.out.println("Cliente: "+cliente.toString());        
    }
    
    public void update(Cliente cliente){
        Cliente c = em.find(Cliente.class, cliente.getId());
        
        
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setNroDoc(cliente.getNroDoc());
        c.setTipDoc(cliente.getTipDoc());
        c.setNacionalidad(cliente.getNacionalidad());
        c.setEmail(cliente.getEmail());
        c.setTelefono(cliente.getTelefono());
        c.setFechaNacimiento(cliente.getFechaNacimiento());
        
        em.persist(c);
    }

    public List<Cliente> listar(){
        Query q = em.createQuery("select c from Cliente c");
        return (List<Cliente>) q.getResultList();
    }
    
}
