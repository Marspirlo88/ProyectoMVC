<%-- 
    Document   : Datosagregadors
    Created on : 6 sep. 2021, 1:36:23 a. m.
    Author     : Marco
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos traidos desde la base de datos</title>

    </head>
    <body>
       
        <h1>Datos traidos desde la base de datos</h1>
        <br>
        
        <ul>
            <c:forEach var="cliente"  items="${lista}">
                <li>${clientes.idCliente} ${cliente.nombre} ${cliente.apellido} ${cliente.saldo} </li>  
                </c:forEach>
        </ul>
        <br>
        <a href="WEB-INF/../agregar.jsp">Agregar cliente</a>
        
        
    </body>
</html>
