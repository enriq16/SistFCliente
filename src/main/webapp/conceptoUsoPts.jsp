<%-- 
    Document   : conceptoUsoPts
    Created on : 20/09/2021, 03:50:02 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>        
        <title>Concepto Uso Puntos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

    </head>
    <body>
        <jsp:include page="/WEB-INF/util/cabecera.jsp"/>
        <header> 
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1 class="float-right">
                            <i class="fas fa-cog"></i> Administración Concepto Uso Puntos</h1>
                    </div>
                </div>
            </div>
        </header>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletConceptoUP?accion=agregar" 
                           class="btn btn-primary btn-block">
                            <i class="fas fa-plus"></i> Agregar Concepto Uso Pts
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <section id="clientes">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Listado Concepto Uso de Puntos</h4>
                            </div>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Concepto</th>
                                        <th>Cantidad Ptos</th>                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Iteramos cada elemento de la lista de clientes -->
                                    <c:forEach var="c" items="${conceptoUsoPuntos}" varStatus="status" >
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${c.concepto}</td> 
                                            <td>${c.puntosRequeridos}</td>                                            
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ServletConceptoUP?accion=editar&id=${c.id}"
                                                   class="btn btn-secondary">
                                                    <i class="fas fa-angle-double-right"></i> Editar
                                                </a>                                                
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>                                       
                </div>
            </div>
        </section>




        <script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>   
        <script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>        
    </body>
</html>
