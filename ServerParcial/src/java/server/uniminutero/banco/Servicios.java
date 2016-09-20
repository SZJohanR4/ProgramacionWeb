/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.uniminutero.banco;

import com.sun.xml.fastinfoset.util.StringArray;
import java.sql.SQLException;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author johan
 */
@WebService(serviceName = "Servicios")
public class Servicios {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "crear_cuenta")
    public Boolean crear_cuenta(@WebParam(name = "estado_cuenta") String estado_cuenta, @WebParam(name = "numero_cuenta") int numero_cuenta, @WebParam(name = "sucursal") String sucursal, @WebParam(name = "saldo") int saldo) throws ClassNotFoundException, SQLException, Exception {
        Administrador admin = new Administrador();
        if (admin.crear_cuenta(estado_cuenta, sucursal, numero_cuenta, saldo)) {
            System.out.println("entre al crear cuenta de servicion.java");
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar_cliente")
    public Boolean eliminar_cliente(@WebParam(name = "id") int id) throws SQLException, Exception {
        Administrador admin = new Administrador();
        if (admin.eliminar_cliente(id)) {
            System.out.println("entre al eliminar de servicion.java");
            return true;
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crear_cliente")
    public Boolean crear_cliente(@WebParam(name = "documento") int documento, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "sueldo") int sueldo, @WebParam(name = "cliente_potencial") String cliente_potencial, @WebParam(name = "telefono") int telefono, @WebParam(name = "id_password") int id_password, @WebParam(name = "id_cuenta") int id_cuenta, @WebParam(name = "id_historial") int id_historial) throws SQLException, Exception {
        Administrador admin = new Administrador();
        if (admin.agregar_cliente(documento, nombre, apellido, sueldo, cliente_potencial, telefono, id_password, id_cuenta, id_historial)) {
            System.out.println("entre al eliminar de servicion.java");
            return true;
        }
        return false;
    }

    /**
     *---------------------CLIENTE-------------------------
     */
    @WebMethod(operationName = "transaccion")
    public Boolean transaccion(@WebParam(name = "cantidad") int cantidad, @WebParam(name = "id") int id) throws SQLException, Exception {
       Cliente cliente=new Cliente();
      if( cliente.transaccion(cantidad, id)){
          System.out.println("entre al transaccion de servicion.java");
            return true;
      }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "pedir_cresito")
    public Boolean pedir_cresito(@WebParam(name = "cantidad") int cantidad, @WebParam(name = "id") int id, @WebParam(name = "tipo_credito") String tipo_credito) throws SQLException, Exception {
         Cliente cliente=new Cliente();
         if(cliente.pedir_credito(cantidad, id, tipo_credito)){
             return true;
         }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelar_credito")
    public Boolean cancelar_credito(@WebParam(name = "id") int id) throws SQLException, Exception {
        Cliente cliente=new Cliente();
        if(cliente.cancelar_credito(id)){
            return true;
        }
        return false;
    }

    /**
     * -----------------------------------------PErsona
     */
    @WebMethod(operationName = "consultar_informacion")
    public String[] consultar_informacion(@WebParam(name = "id_cuenta") String id_cuenta) throws SQLException, Exception {
       Persona persona=new Persona();
        String []result=persona.consultar_informacion(id_cuenta);
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "cedula") String cedula, @WebParam(name = "password") String password, @WebParam(name = "nivel") String nivel) throws SQLException, Exception {
       Persona persona=new Persona();
        String result=persona.login(cedula, password, nivel);
        return result;
    }
    




    
    
    



}
