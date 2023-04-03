
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.ReglaAsignacionDAO;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.arquitectura.web.sistfcliente.entity.ReglaAsignacion;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

/* Gestion */
@Path("reglamanager")
public class ReglaAsignacionRest {
    @Inject
    private ReglaAsignacionDAO reglaDAO;
    
    
    @GET
    @Path("/")
    @Produces("application/json")
    public Response listar(){
        return Response.ok(reglaDAO.listar()).build();
    }
    
    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(ReglaAsignacion reg){
        reglaDAO.insert(reg);
        return Response.ok(reg).build();
    }
    
    @PUT
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(ReglaAsignacion reg){
        reglaDAO.update(reg);
        return Response.ok(reg).build();
    }   
    
    @DELETE
    @Path("/")
    @Consumes("application/json")
    public Response delete(ReglaAsignacion reg){
        reglaDAO.delete(reg);
        return Response.ok().build();
    }
    
    
}
