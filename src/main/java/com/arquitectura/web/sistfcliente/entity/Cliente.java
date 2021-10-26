/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;//Ojo hay otra clase llamada Entity en otro paquete
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Enrique 
 */

@Entity(name="Cliente")//como referirse a la clase en el hql(query de jpa)
@Table(name ="cliente")//nombre de la tabla en la bd
public class Cliente implements Serializable {
    @Id
    @Basic(optional = false )
    @Column(name="id_cliente")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;//se recomienda no usar tipos primitivos  
    /*  
    En @Basic
        Lleva optional=false los atributos que en bd son NOT NULL
    */
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "nombre", nullable=false, length=100)
    private String nombre;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "apellido", nullable=false, length=100)
    private String apellido;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "nro_documento", nullable=false)
    private Integer nroDoc;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "tipo_doc", nullable=false, length=2)
    private String tipDoc;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "nacionalidad" )        
    private String nacionalidad;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "email" )
    private String email;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "telefono" )
    private String telefono;
    
    @Basic(optional=false, fetch=FetchType.EAGER)
    @Column( name = "fecha_nacimiento" )
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date fechaNacimiento;//Usar Camel Case
    
    /* Es requerimietno de JPA que el Entity Class tenga un constructuor sin argumentos */
    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String apellido, Integer nroDoc, String tipDoc, String nacionalidad, String email, String telefono, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDoc = nroDoc;
        this.tipDoc = tipDoc;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getNroDoc() {
        return nroDoc;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
    
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNroDoc(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{"+"id= '"+id+"', nombre= '"+nombre+"', apellido= '"+apellido+"', nroDoc= '"+nroDoc+"', tipDoc= '" +tipDoc+"'}";
    }

    
}
