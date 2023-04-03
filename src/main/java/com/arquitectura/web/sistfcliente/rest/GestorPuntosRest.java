
package com.arquitectura.web.sistfcliente.rest;

import com.arquitectura.web.sistfcliente.ejb.BolsaPuntosDAO;
import com.arquitectura.web.sistfcliente.ejb.ClienteDAO;
import com.arquitectura.web.sistfcliente.ejb.ReglaAsignacionDAO;
import com.arquitectura.web.sistfcliente.ejb.VencimientoPuntoDAO;
import com.arquitectura.web.sistfcliente.entity.BolsaPuntos;
import com.arquitectura.web.sistfcliente.entity.Cliente;
import com.arquiterctura.web.sisfcliente.util.DatosCargaPuntos;
import com.arquiterctura.web.sisfcliente.util.DatosConsultPuntos;
import com.arquiterctura.web.sisfcliente.util.Util;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;

/**
 *
 * @author Enrique
 */


@Path("servicio")
@Consumes("application/json")
@Produces("application/json")
public class GestorPuntosRest {
    @Inject
    private ClienteDAO clienteDAO;
    
    @Inject
    private ReglaAsignacionDAO reglaDAO;
    
    @Inject 
    private VencimientoPuntoDAO paramVencDAO;
    
    @Inject
    private BolsaPuntosDAO bolsaDAO;
    
    @POST
    @Path("crearbolsa")
    public Response cargarPuntos(DatosCargaPuntos data){
        Integer puntoAsignado;
        Integer puntoUtilizado = 0;
        Integer saldoPunto;
        
        /* Monto Equivalente a un punto */
        Integer montoEqPunto = Util.montoEqPunto(reglaDAO.listar().iterator(), data.getMontoOp());
        puntoAsignado = data.getMontoOp().intValue() / montoEqPunto;
        saldoPunto = puntoAsignado;        
        
        /* Parametro de vencimiento de Puntos: de donde quitamos la cantidad de dìas de duraciòn de la bolsa */
        Integer diasDuracion = paramVencDAO.getVencimientoActivo().getCant();                      
        
        Date fechaInicio = new Date();
        Date fechaFin    = Util.SumarDias(new Date(), diasDuracion);/* Sumar diasDuracion a fecha actual */
                
        /* obtener el cliente */
        Cliente c = clienteDAO.findById(data.getIdCliente());
        
        BolsaPuntos nuevo = new BolsaPuntos();
        nuevo.setCliente(c);
        nuevo.setFechaAsignacion(fechaInicio);
        nuevo.setFechaCaducidad(fechaFin);
        nuevo.setMontoOperacion(data.getMontoOp());
        nuevo.setPuntoAsignado(puntoAsignado);
        nuevo.setPuntoUtilizado(puntoUtilizado);
        nuevo.setPuntoSaldo(puntoAsignado);                
        nuevo.setEstado("A");
        
        bolsaDAO.cargaPuntos(nuevo);
        
        return Response.ok(nuevo).build();
    }

    @GET
    @Path("/consultarpuntos/{montoOp}")
    public Response getCantPuntos(@PathParam("montoOp") Float monto){
        
        /* Monto equivalente a un punto*/
        Integer montoEqPunto = Util.montoEqPunto(reglaDAO.listar().iterator(),monto);
        System.out.println(monto.intValue() +"/"+ montoEqPunto);
        Integer cantPuntos = monto.intValue() / montoEqPunto;

        DatosConsultPuntos aux = new DatosConsultPuntos();
        aux.setMonto(monto);
        aux.setCantidadPuntos(cantPuntos);

        return Response.ok(aux).build();
    }
}