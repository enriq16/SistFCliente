
package com.arquitectura.web.sistfcliente.controlador;

import com.arquitectura.web.sistfcliente.ejb.ConceptoUsoPuntosDAO;
import com.arquitectura.web.sistfcliente.entity.Cliente;
import com.arquitectura.web.sistfcliente.entity.ConceptoUsoPuntos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletConceptoUP", urlPatterns = {"/ServletConceptoUP"})
public class ServletConceptoUP extends HttpServlet {
    @Inject
    private ConceptoUsoPuntosDAO conceptUsoPuntosDAO;


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
                    System.out.println("accion: "+accion);
                    String jspEditar = "agregarConceptoUsoPt.jsp";
                    request.getRequestDispatcher(jspEditar).forward(request, response);
                    break;
                case "editar":
                    this.editarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
        
        
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));
            /*
            String concepto = request.getParameter("concepto");
            int puntos_req = Integer.parseInt(request.getParameter("puntosRequeridos"));
            */
            ConceptoUsoPuntos cc;                                   
            cc = conceptUsoPuntosDAO.findById(id);            
            
            List<ConceptoUsoPuntos> lista = conceptUsoPuntosDAO.listar();                                 
            
            request.setAttribute("cc", cc);
            request.setAttribute("conceptoUsoPuntos", lista);
            
            String jspEditar = "agregarConceptoUsoPt.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (IOException ex) {
            System.out.println("Error EditarCliente: '"+ex.getMessage()+"'");
            this.accionDefault(request, response);
        }
    }

    private ConceptoUsoPuntos buscarCliente(List<ConceptoUsoPuntos> lista, int id) {
        ConceptoUsoPuntos c = null;
        Iterator<ConceptoUsoPuntos> it = lista.iterator();
        while (it.hasNext()) {
            ConceptoUsoPuntos aux = it.next();
            if (aux.getId() == id) {
                System.out.println("Encontre Concepto id: "+id);
                c = aux;
                break;
            }
        }
        return c;
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
        ConceptoUsoPuntos cc;
        List<ConceptoUsoPuntos> lista;
                
        String concepto = request.getParameter("concepto");
        Integer ptsRequeridos = Integer.parseInt(request.getParameter("puntosRequeridos"));
        
        cc = new ConceptoUsoPuntos();
        cc.setConcepto(concepto);
        cc.setPuntosRequeridos(ptsRequeridos);
        System.out.println("Concepto: "+cc);
        conceptUsoPuntosDAO.agregar(cc);
        lista = conceptUsoPuntosDAO.listar();
        
        /*
        request.setAttribute("conceptoUsoPuntos", lista);
        String jspContent = "/conceptoUsoPts.jsp";
        request.getRequestDispatcher(jspContent).forward(request, response);
        */
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Método Put");        
        //List<ConceptoUsoPuntos> lista;
                
        Integer id = Integer.parseInt(request.getParameter("id"));        
        String concepto = request.getParameter("concepto");
        Integer ptsRequeridos = Integer.parseInt(request.getParameter("puntosRequeridos"));
        
        ConceptoUsoPuntos cc = new ConceptoUsoPuntos();
        
        cc.setId(id);
        cc.setConcepto(concepto);
        cc.setPuntosRequeridos(ptsRequeridos);
        
        conceptUsoPuntosDAO.update(cc);
        //lista = conceptUsoPuntosDAO.listar();
        /*
        request.setAttribute("conceptoUsoPuntos", lista);
        
        String jspContent = "/conceptoUsoPts.jsp";
        request.getRequestDispatcher(jspContent).forward(request, resp);                  
        */
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

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ConceptoUsoPuntos> lista;
        
        
        lista = conceptUsoPuntosDAO.listar();        
                
        request.setAttribute("conceptoUsoPuntos", lista);

        String jspContent = "/conceptoUsoPts.jsp";
        request.getRequestDispatcher(jspContent).forward(request, response); 
    }

}
