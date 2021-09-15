/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arquitectura.web.sistfcliente.controlador;

import com.arquitectura.web.sistfcliente.entity.Cliente;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletCliente"})
public class NewServlet extends HttpServlet {

 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    System.out.println("Editar Cliente");
                    //this.editarCliente(request, response);
                    break;
                case "eliminar":
                    System.out.println("Eliminar Cliente");
                    //this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
        
    }

    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente c1;
        List<Cliente> lista;
        HttpSession sesion = request.getSession();
        lista = (List<Cliente>) sesion.getAttribute("clientes");
        
        if(lista == null){
        try {
            lista = new ArrayList<>();
            c1 = new Cliente(1, "Enrique", "Ruiz", "3967631", "CI", "Paraguaya", "enriq16@fpuna.edu.py", "0992549600",
                    new SimpleDateFormat("dd-MM-yyyy").parse("14-06-1987"));
            lista.add(c1);
            c1 = new Cliente(1, "Karen", "Verón", "55555", "CI", "Paraguaya", "karen@fpuna.edu.py", "0982875221",
                    new SimpleDateFormat("dd-MM-yyyy").parse("14-10-1992"));
            lista.add(c1);
            c1 = new Cliente(1, "Juan", "Peréz", "55555", "CI", "Paraguaya", "jperez@gmail.com", "0983522311",
                    new SimpleDateFormat("dd-MM-yyyy").parse("28-02-1993"));
            lista.add(c1);
            sesion.setAttribute("clientes", lista);    
        } catch (ParseException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
                
        sesion.setAttribute("clientes", lista);
        String jspContent = "/clientes.jsp";
        request.getRequestDispatcher(jspContent).forward(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        List<Cliente> lista = (List<Cliente>) sesion.getAttribute("clientes");


        
        Integer id = lista.size() + 1;
        //recuperamos los valores del formulario agregarCliente
        String nombre =   request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nroDoc =   request.getParameter("nro_doc");
        String tipoDoc =  request.getParameter("tipo_doc");
        String nacionalidad =  request.getParameter("nacionalidad");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaNacimiento"));
        } catch (ParseException ex) {
            System.out.println("Error en foramto de fecha");
            //Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(id, nombre, apellido, nroDoc, tipoDoc, nacionalidad, email, telefono, fechaNacimiento);
        
        //Insertamos el nuevo objeto en la base de datos
        lista.add(cliente);
        
        sesion.setAttribute("clientes", lista);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        List<Cliente> lista = (List<Cliente>) sesion.getAttribute("clientes");
        
        
        Integer id = lista.size() + 1;
        //recuperamos los valores del formulario agregarCliente
        String nombre =   request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nroDoc =   request.getParameter("nro_doc");
        String tipoDoc =  request.getParameter("tipo_doc");
        String nacionalidad =  request.getParameter("nacionalidad");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaNacimiento"));
        } catch (ParseException ex) {
            System.out.println("Error en foramto de fecha");
            //Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        //Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(id, nombre, apellido, nroDoc, tipoDoc, nacionalidad, email, telefono, fechaNacimiento);
        
        //Insertamos el nuevo objeto en la base de datos
        lista.add(cliente);
        
        sesion.setAttribute("clientes", lista);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
