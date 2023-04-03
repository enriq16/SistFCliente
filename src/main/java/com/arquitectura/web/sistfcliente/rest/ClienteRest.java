/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.ClienteDAO;
import com.arquitectura.web.sistfcliente.entity.Cliente;
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
 * @author Enrique Ruiz
 */

@Path("cliente")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {
    @Inject
    private ClienteDAO ClienteDAO;
    
    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(ClienteDAO.listar()).build();
    }
    
    @PUT
    @Path("/")
    public Response updateCliente(Cliente c){
        ClienteDAO.update(c);
        return Response.ok(c).build();
    }
    
    @POST
    @Path("/")
    public Response addCliente(Cliente c){
     ClienteDAO.agregar(c);
     return Response.ok(c).build();
    }
    
    @DELETE
    @Path("/")
    public  Response deleteCliente(Cliente c){
        
        ClienteDAO.delete(c);
        
        return Response.ok().build();
    }
}
