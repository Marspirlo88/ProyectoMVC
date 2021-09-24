
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <title>Agregar Cliente</title>
    </head>
    <body>

        <%
            // Map errores = new HashMap();
            // errores= (Map<String,String>)request.getAttribute("errores");

        %>
      
        <form class="row g-3" action="${pageContext.request.contextPath}/ControlServlet?accion=insertar" method="POST" >
  
            <section class="form-register">
                <h1>Agregar cliente</h1>
                <input class ="controls" type="text" name="nombre" id="nombre" placeholder="Ingrese el Nombre">
                <input class ="controls" type="text" name="apellido" id="apellido" placeholder="Ingrese Apellido">
                <input class ="controls" type="email" name="email" id="email" placeholder="Ingrese el email">
                <input class ="controls" type="text" name="telefono" id="telefono" placeholder="Ingrese Telefono">
                <input class ="controls" type="text" name="saldo" id="saldo" placeholder="Ingrese Saldo">
                <br>
                <input type="submit" value="Registrar">

            </section>  





            <a href="Datosagregadors.jsp">Ver Registros</a>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    </body>
</html> 
