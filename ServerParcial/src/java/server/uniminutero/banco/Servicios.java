/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.uniminutero.banco;

import java.sql.SQLException;
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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crear_cuenta")
    public Boolean crear_cuenta(@WebParam(name = "estado_cuenta") String estado_cuenta, @WebParam(name = "numero_cuenta") int numero_cuenta, @WebParam(name = "sucursal") String sucursal, @WebParam(name = "saldo") int saldo) throws ClassNotFoundException, SQLException, Exception {
        Administrador admin=new Administrador();
        if(admin.crear_cuenta(estado_cuenta, sucursal, numero_cuenta, saldo)){
            System.out.println("entre al crear cuenta de servicion.java");
        return true;
    }
        return false;
    }
}
