
package datos;

import java.sql.*;
import datos.Conexion;
import dominio.Cliente;
import java.util.*;

public class ClienteDaoJDBC {
   
   String agregarbd = "INSERT INTO cliente(id_cliente,nombre,apellido,email,telefono.saldo) VALUES(?,?,?,?,?,?)";
   String selec =  "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + " FROM cliente";

 
    private static final String buscar = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + " FROM cliente WHERE id_cliente = ?";
    
    private static final String agregar="INSERT INTO cliente(nombre, apellido, email, telefono, saldo) VALUES(?,?,?,?,?) ";
  
    private static final String actualizar="UPDATE cliente SET nombre=?,apellido=?,email=?,telefono=?,saldo=? WHERE id_cliente=?";
    
    private static final String borrar ="DELETE FROM cliente WHERE id_clientes =?";
    
    Conexion cn;
   Cliente cliente = new Cliente();
   
   
   
   
   public List<Cliente> listar() throws SQLException{
    Connection conn = null;
    
     PreparedStatement ps = null;
    ResultSet rs= null;
    Cliente cliente = null;
    List<Cliente> clientes = new ArrayList<>();
    
       try {
           conn=Conexion.getConnection();
         ps=conn.prepareStatement(selec);
     rs = ps.executeQuery();
           while (rs.next()) {               
               int idCliente = rs.getInt("id_cliente");
               
               String nombre= rs.getString("nombre");
             String apellido = rs.getString("apellido");
             String email = rs.getString("email");
             String telefono = rs.getString("telefono");
             double saldo = rs.getDouble("saldo");
             
             //El Construtor de la clase Cliente
             cliente = new Cliente(idCliente,nombre,apellido,email,telefono,saldo);
             clientes.add(cliente);
           }
           
           System.out.println("Conexion exitosa");
       } catch (Exception e) {
           
           System.out.println("error en la conexion");
       }
       finally{
       Conexion.close(rs);
       Conexion.close(ps);
       Conexion.close(conn);
       }
       
   return clientes;
   }
   
   public int insertar(Cliente cliente){
   Connection con = null ;
   PreparedStatement ps = null;
   int filas=0;
       try {
           con = Conexion.getConnection();
           ps=con.prepareStatement(agregar);
           ps.setString(1,cliente.getNombre());
           ps.setString(2,cliente.getApellido());
           ps.setString(3, cliente.getEmail());
           ps.setString(4,cliente.getTelefono());
           ps.setDouble(5, cliente.getSaldo());
           filas = ps.executeUpdate();
           
       } catch (Exception e) {
           System.out.println("error en la consulta oara agregar usuario  :   " + e);
       }
       finally{
       Conexion.close(ps);
       Conexion.close(con);
       }
   return filas;
   
   
   }

   public Cliente encontrar(Cliente cliente) throws SQLException{
  Connection con = null;
  PreparedStatement ps = null;
  ResultSet rs = null;
  
       try {
           con = Conexion.getConnection();
           ps=con.prepareStatement(buscar);
           ps.setInt(1, cliente.getIdCliente());
           rs=ps.executeQuery();
           rs.absolute(1);
           
           
             String nombre= rs.getString("nombre");
             String apellido = rs.getString("apellido");
             String email = rs.getString("email");
             String telefono = rs.getString("telefono");
             double saldo = rs.getDouble("saldo");
             
             //El Construtor de la clase Cliente
          cliente.setNombre(nombre);
         cliente.setApellido(apellido);
         cliente.setEmail(email);
         cliente.setTelefono(telefono);
         cliente.setSaldo(saldo);
           
       } catch (Exception e) {
       }
       
       finally{
       Conexion.close(ps);
       Conexion.close(rs);
       }
  
   return cliente;
   }
   public int actualizar (Cliente cliente){
    Connection con = null ;
   PreparedStatement ps = null;
   int filas=0;
       try {
           con = Conexion.getConnection();
           ps=con.prepareStatement(actualizar);
           ps.setString(1,cliente.getNombre());
           ps.setString(2,cliente.getApellido());
           ps.setString(3, cliente.getEmail());
           ps.setString(4,cliente.getTelefono());
           ps.setDouble(5, cliente.getSaldo());
           ps.setInt(6,cliente.getIdCliente());
           filas = ps.executeUpdate();
           
       } catch (Exception e) {
           System.out.println("error en la consulta oara agregar usuario  :   " + e);
       }finally{
       Conexion.close(ps);
       Conexion.close(con);
       }
   return filas;
   
   }
   public int eliminar (Cliente cliente){
   Connection con = null;
   PreparedStatement ps = null;
   int filas =0;
       try {
           con=Conexion.getConnection();
           ps=con.prepareStatement(borrar);
           ps.setInt(1, cliente.getIdCliente());
           filas=ps.executeUpdate();
           
       } catch (Exception e) {
       }
       finally{
       Conexion.close(ps);
       
       }
       return filas;
   }
   
   
   
}