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
        System.out.println("Cliente: "+cliente.toString());    
        em.merge(cliente);
        System.out.println("Cliente despues: "+cliente.toString());    
        //em.persist(cliente);                       
    }
    
    public void update(Cliente cliente){
        Cliente c = em.find(Cliente.class, cliente.getId());
        
        boolean prueba = em.contains(c);
        if(prueba)
            System.out.println("Esta en el Context");
        else
            System.out.println("No esta en el Context");
        
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setNroDoc(cliente.getNroDoc());
        c.setTipDoc(cliente.getTipDoc());
        c.setNacionalidad(cliente.getNacionalidad());
        c.setEmail(cliente.getEmail());
        c.setTelefono(cliente.getTelefono());
        c.setFechaNacimiento(cliente.getFechaNacimiento());
        
        em.flush();
    }

    public List<Cliente> listar(){
        Query q = em.createQuery("select c from Cliente c");
        List<Cliente> lista = (List<Cliente>) q.getResultList();
        
        boolean prueba = em.contains(lista.get(0));
        if(prueba)
            System.out.println("Esta en el Context");
        else
            System.out.println("No esta en el Context");
        
        return lista;
    }

    public void delete(Cliente c) {
        c = findById(c.getId());
        if(c != null)
            em.remove(c);
    }
    
}
