<%-- 
    Document   : agregarCliente
    Created on : 15/09/2021, 12:09:11 PM
    Author     : Enrique Ruiz
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
        <section id="clientes">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="card-header">
                                <h4>
                                    ${param.accion=="agregar"?"Crear Usuario":param.accion=="editar"?"Editar Usuario":"XXX"}
                                </h4>
                            </div>
                            <form action="${pageContext.request.contextPath}/ServletCliente?accion=${param.accion=="agregar"?"insertar":"modificar"}"
                                  method="POST" class="was-validated">

                                <div class="modal-body">
                                    <div class="form-group">
                                        <input name="idCliente" type="hidden" value="${cliente != null ? cliente.id : ""}">

                                        <label for="nombre">Nombre</label>
                                        <input type="text" value="${cliente != null ? cliente.nombre : ""}"
                                               class="form-control" name="nombre" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" value="${cliente!=null?cliente.apellido:""}"
                                               class="form-control" name="apellido" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nro_doc">Nro Docuemnto</label>
                                        <input type="text" value="${cliente!=null?cliente.nroDoc:""}"
                                               class="form-control" name="nro_doc" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo_doc">Tipo Documento</label>
                                        <input type="text" value="${cliente!=null?cliente.tipDoc:""}"
                                               class="form-control" name="tipo_doc" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="nacionalidad">Nacionalidad</label>
                                        <input type="text" value="${cliente!=null?cliente.nacionalidad:""}"
                                               class="form-control" name="nacionalidad" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" value="${cliente!=null?cliente.email:""}"
                                               class="form-control" name="email" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Teléfono</label>
                                        <input type="telefono" value="${cliente!=null?cliente.telefono:""}"
                                               class="form-control" name="telefono" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="fecha_nacimeinto">Fecha Nacimiento</label>
                                        <input name="fechaNacimiento"
                                               <c:choose>                  
                                                   <c:when test = "${cliente!=null}">
                                                       value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${cliente.fechaNacimiento}"/>"
                                                   </c:when>         
                                                   <c:otherwise>value=""</c:otherwise>
                                               </c:choose>
                                               class="form-control datepicker" data-date-format="yyyy-mm-dd" 
                                               required>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit">Guardar</button>
                                </div>    
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>   
        <script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/node_modules/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.datepicker').datepicker({
                    format: 'yyyy-mm-dd'
                });
            });
        </script>
    </body>    
</html>    