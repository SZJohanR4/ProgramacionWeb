/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.uniminutero.banco;

import java.sql.SQLException;

/**
 *
 * @author johan
 */
public class Administrador extends Persona{
    
    
    
    
    
    public boolean crear_cuenta(String estado_cuenta, String sucursal, int numero_cuenta,int saldo) throws ClassNotFoundException, SQLException, Exception{
          Conexion conectar=new Conexion();
            Conexion.conexionDB();
            String querry="INSERT INTO `cuenta`(`id_cuenta`, `estado_cuenta`, `numero_cuenta`, `sucursal`, `saldo`) VALUES ('','"+estado_cuenta+"','"+numero_cuenta+"','"+sucursal+"','"+saldo+"')";
           if( conectar.insert(querry)){
               System.out.println("entre al crear_cuenta administrador");
               return true;
           }
            conectar.closeConnection();
        return false;
    }
}
