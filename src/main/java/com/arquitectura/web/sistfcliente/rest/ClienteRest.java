/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.ClienteDAO;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Enrique
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
}
