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

        <section id="conceptoUP">
            <div class="container">
                <div class="row">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="card-header">
                                <h4>
                                    ${param.accion=="agregar"?"Crear Concepto Uso Pt.":param.accion=="editar"?"Editar Concepto Uso Pt.":"XXX"}
                                </h4>
                            </div>
                            <form id="fmrConceptoUP" class="was-validated">

                                <div class="modal-body">
                                    <div class="form-group">
                                        <input name="id" type="hidden" value="${cc != null ? cc.id : "0"}">

                                        <label for="concepto">Descripción</label>
                                        <input type="text" value="${cc != null ? cc.concepto : ""}"
                                               class="form-control" name="concepto" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="puntosRequeridos">Puntos Requeridos</label>
                                        <input type="number" value="${cc!=null ? cc.puntosRequeridos: ""}"
                                               class="form-control" name="puntosRequeridos" required>
                                    </div>                                    
                                </div>
                                <div class="modal-footer">
                                    <button id="btnConceptoUP" class="btn btn-primary" type="button">Guardar</button>
                                </div>    
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
                                                       


        <script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>   
        <script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>     
        <script>
            $(document).ready(function(){
               $("#frmConceptoUP").on("click",function(){
                   
                   let data = $("#fmrConceptoUP").serialize();
                   
                   $.ajax({
                       url: "${pageContext.request.contextPath}/ServletConceptoUP",
                       method: "${param.accion == "agregar"? "POST" : param.accion == "editar" ? "PUT" : ""}",
                       success: function( Anything data, String textStatus, jqXHR jqXHR){
                           window.alert("Operación Status: "+textStatus);                           
                       },
                       error: function( jqXHR jqXHR, String textStatus, String errorThrown){
                           window.alert("Operación Status: "+textStatus", error: "+errorThrown);
                       },
                       complete: function(jqXHR jqXHR, String textStatus){
                           console.log("Complete redireccionando");
                           window.location = "${pageContext.request.contextPath}/ServletConceptoUP";
                       }        
                   });
               }); 
            });
        </script>
    </body>
</html>
