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
public class Cliente extends Persona {

    public boolean transaccion(int cantidad, int id) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "INSERT INTO `historial`(`id_historial`, `saldos`, `fecha`) VALUES ('','" + cantidad + "','CURRENT_TIMESTAMP')";
        if (conectar.sql(querry)) {
            System.out.println("entre al crear_cuenta administrador");
            return true;
        }
        conectar.closeConnection();
        return false;
    }

    public boolean pedir_credito(int cantidad, int id) throws ClassNotFoundException, SQLException {

        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "SELECT `saldos` FROM historial WHERE id_historial=" + id + " ORDER BY `fecha` LIMIT 3 ";
        String resultConsult[] = conectar.select(querry).split(" ");
        int saldo1 = Integer.parseInt(resultConsult[0]);
        int saldo2 = Integer.parseInt(resultConsult[1]);
        int saldo3 = Integer.parseInt(resultConsult[2]);
        int sumatoriaSueldo= saldo1 + saldo2 + saldo3;
        
        if(cantidad%30<sumatoriaSueldo){//tengo mayor saldo que la cantidad e mi prestamos
            //si, se aprueba el credito
            return true;
        }else{
            return false;
        }

       
    }
}
