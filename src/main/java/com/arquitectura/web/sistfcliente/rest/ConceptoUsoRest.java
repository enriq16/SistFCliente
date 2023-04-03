/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.ConceptoUsoPuntosDAO;
import com.arquitectura.web.sistfcliente.entity.ConceptoUsoPuntos;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Enrique
 */

@Path("conceptouso")
@Consumes("application/json")
@Produces("application/json")
public class ConceptoUsoRest {
    @Inject
    ConceptoUsoPuntosDAO c;
    
    @GET
    @Path("/")    
    //@Consumes("application/json")
    @Produces("application/json")
    public Response listar(){
        List<ConceptoUsoPuntos> lista = c.listar();
        return Response.ok(lista).build();
    }
    
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(ConceptoUsoPuntos con){
        c.agregar(con);
        return Response.ok(con).build();
    }
    
    @PUT
    @Path("/")
    @Consumes("application/json")    
    @Produces("application/json")
    public Response update(ConceptoUsoPuntos con){
        c.update(con);
        return Response.ok(con).build();
    }
    
    
    @DELETE
    @Path("/")
    @Consumes("application/json")    
    public Response eliminar(ConceptoUsoPuntos con){
        c.delete(con);
        
        return Response.ok().build();
    }
    
    
}
