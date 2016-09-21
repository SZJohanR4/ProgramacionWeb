/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi_parcial;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Sebastian Urrea
 */
@WebService(serviceName = "Operaciones")
public class Operaciones {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cancelar_credito")
    public boolean cancelar_credito(@WebParam(name = "id") int id) {
        Cliente cl = new Cliente();
        try {
            if (cl.cancelar_credito(id)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    @WebMethod(operationName = "pedir_credito")
    public Boolean pedir_credito(@WebParam(name = "cantidad") int cantidad, @WebParam(name = "id") int id, @WebParam(name = "tipo_credito") String tipo_credito) {
        Cliente cl = new Cliente();
        try {
            if (cl.pedir_credito(cantidad, id, tipo_credito)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @WebMethod(operationName = "crear_cuenta")
    public Boolean crear_cuenta(@WebParam(name = "estado_cuenta") String estado_cuenta, @WebParam(name = "numero_cuenta") int numero_cuenta, @WebParam(name = "sucursal") String sucursal, @WebParam(name = "saldo") int saldo) {
        try {
            Administrador admin = new Administrador();
            if (admin.crear_cuenta(estado_cuenta, sucursal, numero_cuenta, saldo)) {
                System.out.println("entre al crear cuenta de servicion.java");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "eliminar_cliente")
    public Boolean eliminar_cliente(@WebParam(name = "id") int id) {
        try {
            Administrador admin = new Administrador();
            if (admin.eliminar_cliente(id)) {
                System.out.println("entre al eliminar de servicion.java");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "crear_cliente")
    public Boolean crear_cliente(@WebParam(name = "documento") int documento, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "sueldo") int sueldo, @WebParam(name = "cliente_potencial") String cliente_potencial, @WebParam(name = "telefono") int telefono, @WebParam(name = "id_password") int id_password, @WebParam(name = "id_cuenta") int id_cuenta, @WebParam(name = "id_historial") int id_historial) {
        try {
            Administrador admin = new Administrador();
            if (admin.agregar_cliente(documento, nombre, apellido, sueldo, cliente_potencial, telefono, id_password, id_cuenta, id_historial)) {
                System.out.println("entre al eliminar de servicion.java");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "transaccion")
    public Boolean transaccion(@WebParam(name = "cantidad") int cantidad, @WebParam(name = "id") int id) {
        try {
            Cliente cliente = new Cliente();
            if (cliente.transaccion(cantidad, id)) {
                System.out.println("entre al transaccion de servicion.java");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @WebMethod(operationName = "consultar_informacion")
    public String consultar_informacion(@WebParam(name = "id_cuenta") int id_cuenta) {
        String resultado = "";
        try {
            Persona persona = new Persona();
            String[] result = persona.consultar_informacion(id_cuenta);

            for (int i = 0; i < result.length; i++) {
                resultado = resultado + result[i];
                resultado = resultado + " ";
            }
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "cedula") String cedula, @WebParam(name = "password") String password, @WebParam(name = "nivel") String nivel) {
        String result = "";
        try {
            Persona persona = new Persona();
            result = persona.login(cedula, password, nivel);
        } catch (Exception ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    

}

/**
 * Web service operation
 */
/**
 * Web service operation
 */
