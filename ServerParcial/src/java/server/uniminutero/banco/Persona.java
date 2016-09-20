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
public class Persona {

    private String id;
    private String password;
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;

    public String login(String cedula, String password, String nivel) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String resultado = "";
        String querry = "SELECT Usuario,nivel from password where Usuario ='" + cedula + "' AND Pass='" + password + "' AND nivel='" + nivel + "')";
        String result[] = conectar.select(querry).split(" ");
        String nombre = result[0];
        String niveles = result[1];
        if (niveles != null) {
            if (niveles == "admin") {
                resultado = nombre+"ad" ;
            } else {
                resultado = nombre+"cl";

            }
        }else{
            resultado="no existe";
        }

        conectar.closeConnection();
        return resultado;
    }
     public boolean logoff() {
       
        return true;
    }
    public String[] consultar_informacion(String id_cuenta) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String resultado = "";
        String querry = "SELECT * from cuenta where numero_cuenta ='" + id_cuenta + "')";
        String result[] = conectar.informacion(querry).split(" ");
        conectar.closeConnection();
        return result;
    }

}
