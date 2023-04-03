/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.VencimientoPuntoDAO;
import com.arquitectura.web.sistfcliente.entity.VencimientoPunto;
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
 * @author USUARIO
 */

@Path("paramvencimiento")
public class VencimientoRest {
    @Inject
    VencimientoPuntoDAO v;
    
    @GET
    @Path("/")
    @Produces("application/json")
    public Response obtenerParamActivo(){
        System.out.println("Hola");
            
        return Response.ok(v.getVencimientoActivo()).build();
    }
    
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addParam(VencimientoPunto venc){
        System.out.println("Cantidad dias: "+venc.getCant());
        v.addVencimiento(venc);        
        return Response.ok(venc).build();
    }
    
    @PUT
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updatePara(VencimientoPunto venc){
        v.updateVencimiento(venc);
        return Response.ok(venc).build();
    }
    
    @DELETE
    @Path("/")
    @Consumes("application/json")
    public Response deletePara(VencimientoPunto venc){
        v.deleteVencimiento(venc);
        return Response.ok().build();
    }
}
