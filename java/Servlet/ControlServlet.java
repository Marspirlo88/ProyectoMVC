
package Servlet;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;


 @WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet{
   

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       this.defaul(req, resp);
  
        }   

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String accion = req.getParameter("accion");
        switch(accion){
            case "insertar":
                this.insertarCliente(req, resp);
        break;
        }
       
 }
    private  void defaul(HttpServletRequest req ,HttpServletResponse resp) throws ServletException ,IOException{
     try {
            List<Cliente> clientes = new ClienteDaoJDBC().listar();
            HttpSession session = req.getSession();
            
            session.setAttribute("lista",clientes);
            System.out.println("clientes  :  " + clientes);
          resp.sendRedirect("Datosagregadors.jsp");
        } catch (SQLException ex) {
             String error = "error en la traer datos de la conexion"  + "   : " + ex;
             System.out.println(error);
        }
     
    
    }
    
    
    
    private void insertarCliente(HttpServletRequest request ,HttpServletResponse response) throws ServletException ,IOException{
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");
    String telefono = request.getParameter("telefono");
    double saldo = Double.parseDouble(request.getParameter("saldo"));
    
   Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
   cliente.getNombre();
int registros =0;

registros = new ClienteDaoJDBC().insertar(cliente);
      this.defaul(request, response);
    }
    
    private void actualizar (HttpServletRequest req ,HttpServletResponse resp){
    
    
    }
    

 }