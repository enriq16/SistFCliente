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
import java.util.Iterator;
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
                case "agregar":
                    String jspEditar = "agregarCliente.jsp";
                    request.getRequestDispatcher(jspEditar).forward(request, response);
                    break;
                case "editar":
                    System.out.println("Editar Cliente");
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    System.out.println("Eliminar Cliente");
                    this.eliminarCliente(request, response);
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

        if (lista == null) {
            try {
                lista = new ArrayList<>();
                c1 = new Cliente(1, "Enrique", "Ruiz", 3967631, "CI", "Paraguaya", "enriq16@fpuna.edu.py", "0992549600",
                        new SimpleDateFormat("dd-MM-yyyy").parse("14-06-1987"));
                lista.add(c1);
                c1 = new Cliente(2, "Karen", "Verón", 55555, "CI", "Paraguaya", "karen@fpuna.edu.py", "0982875221",
                        new SimpleDateFormat("dd-MM-yyyy").parse("14-10-1992"));
                lista.add(c1);
                c1 = new Cliente(3, "Lizzie", "Miranda", 3385335, "CI", "Paraguaya", "lichimiranda44@gmail.com", "0991711880",
                        new SimpleDateFormat("dd-MM-yyyy").parse("28-02-1993"));
                lista.add(c1);
            } catch (ParseException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        sesion.setAttribute("clientes", lista);
        String jspContent = "/clientes.jsp";
        request.getRequestDispatcher(jspContent).forward(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            //recuperamos el idCliente
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            HttpSession sesion = request.getSession();
            List<Cliente> lista = (List<Cliente>) sesion.getAttribute("clientes");
            if (lista == null) {
                lista = new ArrayList<>();
            }
            
            Cliente cliente = buscarCliente(lista, idCliente);
            
            request.setAttribute("cliente", cliente);
            sesion.setAttribute("clientes", lista);
            
            String jspEditar = "agregarCliente.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (IOException ex) {
            System.out.println("Error EditarCliente: '"+ex.getMessage()+"'");
            this.accionDefault(request, response);
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idCliente = Integer.parseInt(request.getParameter("id"));

        HttpSession sesion = request.getSession();
        List<Cliente> lista = (List<Cliente>) sesion.getAttribute("clientes");

        if (lista == null) {
            lista = new ArrayList<>();
        }

        eliminarCliente(lista, idCliente);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
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

        if (lista == null) {
            lista = new ArrayList<>();
        }

        Integer id = lista.size() + 1;
        //recuperamos los valores del formulario agregarCliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Integer nroDoc = Integer.parseInt(request.getParameter("nro_doc"));
        String tipoDoc = request.getParameter("tipo_doc");
        String nacionalidad = request.getParameter("nacionalidad");
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

        System.out.println("idCliente: "+request.getParameter("idCliente"));
        
        //recuperamos los valores del formulario agregarCliente
        Integer id = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Integer nroDoc = Integer.parseInt(request.getParameter("nro_doc"));
        //String nroDoc = request.getParameter("nro_doc");
        String tipoDoc = request.getParameter("tipo_doc");
        String nacionalidad = request.getParameter("nacionalidad");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("fechaNacimiento"));
        } catch (ParseException ex) {
            System.out.println("Error en foramto de fecha");            
        }
        System.out.println("id: "+id);
        System.out.println("lista: "+lista);
        
        Iterator<Cliente> it = lista.iterator();
        while (it.hasNext()) {
            Cliente aux = it.next();
            if (aux.getId().intValue() == id) {
                aux.setNombre(nombre);
                aux.setApellido(apellido);
                aux.setNroDoc(nroDoc);
                aux.setTipDoc(tipoDoc);
                aux.setNacionalidad(nacionalidad);
                aux.setEmail(email);
                aux.setTelefono(telefono);
                aux.setFechaNacimiento(fechaNacimiento);
            }
        }
        
        

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

    private Cliente buscarCliente(List<Cliente> lista, int idCliente) {
        Cliente c = null;
        Iterator<Cliente> it = lista.iterator();
        while (it.hasNext()) {
            Cliente aux = it.next();
            if (aux.getId() == idCliente) {
                c = aux;
            }
        }
        return c;
    }

    private void eliminarCliente(List<Cliente> lista, Integer id) {
        Iterator<Cliente> it = lista.iterator();
        while (it.hasNext()) {
            Cliente aux = it.next();
            if (aux.getId().intValue() == id) {
                lista.remove(aux);
            }
        }
    }

}
