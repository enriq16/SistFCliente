

package com.arquiterctura.web.sisfcliente.util;

/**
 *
 * @author Karen
 */
public class DatosConsultPuntos {
    private Float monto;
    private Integer cantidadPuntos;

    public DatosConsultPuntos(){
    }

    public DatosConsultPuntos(Float monto, Integer cantidadPunto){
        this.monto = monto;
        this.cantidadPuntos = cantidadPuntos;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Integer getCantidadPunto() {
        return cantidadPunto;
    }

    public void setCantidadPunto(Float cantidadPunto) {
        this.cantidadPunto = cantidadPunto;
    }

}
