/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquiterctura.web.sisfcliente.util;

import com.arquitectura.web.sistfcliente.entity.ReglaAsignacion;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class Util {
    public static Date SumarDias(Date date, Integer cantDias){
        Calendar c = Calendar.getInstance();
        
        c.setTime(date);
        c.add(Calendar.DATE, cantDias);
        
        return c.getTime();
    }
    
    public static Integer montoEqPunto(Iterator<ReglaAsignacion> it, Float data){
        //Iterator<ReglaAsignacion> it = regla.listar().iterator();
        Integer montoEqPunto = null;
        while(it.hasNext()){
            ReglaAsignacion aux = it.next();
            
            Integer limInf = aux.getLimiteInf();
            Integer limSup = aux.getLimiteSup();
                                   
            if(limInf <= data && data <= limSup){
                montoEqPunto = aux.getMontoEqPunto();
            }            
        }
        
        if(montoEqPunto == null)
            montoEqPunto = 20000;
        
        return montoEqPunto;
    }
}
