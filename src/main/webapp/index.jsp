<%-- 
    Document   : index
    Created on : 14/09/2021, 06:07:48 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Control Fidelización Clientes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css">

    </head>            
    <body>
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
                        <a href="#" class="btn btn-primary btn-block"
                           data-toggle="modal" data-target="#agregarClienteModal">
                            <i class="fas fa-plus"></i> Agregar Cliente
                        </a>
                    </div>
                </div>
            </div>
        </section>


        <script src="${pageContext.request.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>   
        <script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>


    </body>
</html>
