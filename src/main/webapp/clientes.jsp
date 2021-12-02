<%-- 
    Document   : index
    Created on : 14/09/2021, 06:07:48 PM
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Control Fidelización Clientes</title>
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
                            <i class="fas fa-cog"></i> Administración Datos Clientes</h1>
                    </div>
                </div>
            </div>
        </header>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/ServletCliente?accion=agregar" 
                           class="btn btn-primary btn-block">
                            <i class="fas fa-plus"></i> Agregar Cliente
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
                                <h4>Listado de Clientes</h4>
                            </div>
                            <table class="table table-striped">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Nro Documento</th>                                        
                                        <th>Tipo Doc</th>
                                        <th>Nacionalidad</th>
                                        <th>Email</th>
                                        <th>Teléfono</th>
                                        <th>Fecha Nacimiento</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Iteramos cada elemento de la lista de clientes -->
                                    <c:forEach var="cliente" items="${clientes}" varStatus="status" >
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${cliente.nombre}</td> 
                                            <td>${cliente.apellido}</td>
                                            <td>${cliente.nroDoc}</td>
                                            <td>${cliente.tipDoc}</td>
                                            <td>${cliente.nacionalidad}</td>
                                            <td>${cliente.email}</td>
                                            <td>${cliente.telefono}</td>
                                            <td>
                                            <fmt:formatDate pattern = "yyyy-MM-dd" value = "${cliente.fechaNacimiento}"/>                                                
                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/ServletCliente?accion=editar&idCliente=${cliente.id}"
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
