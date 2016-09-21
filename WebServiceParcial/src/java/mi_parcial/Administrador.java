package mi_parcial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.SQLException;

/**
 *
 * @author johan
 */
public class Administrador extends Persona{

    
    @Override
    public String[] consultar_informacion(int id_cuenta) throws ClassNotFoundException, SQLException, Exception {
        return super.consultar_informacion(id_cuenta); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean crear_cuenta(String estado_cuenta, String sucursal, int numero_cuenta, int saldo) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "INSERT INTO `cuenta`(`id_cuenta`, `estado_cuenta`, `numero_cuenta`, `sucursal`, `saldo`) VALUES ('','" + estado_cuenta + "','" + numero_cuenta + "','" + sucursal + "','" + saldo + "')";
        if (conectar.sql(querry)) {
            System.out.println("entre al crear_cuenta administrador");
            return true;
        }
        conectar.closeConnection();
        return false;
    }

    public boolean eliminar_cliente(int id) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "DELETE FROM `cliente` WHERE `id_cliente`=" + id;
        if (conectar.sql(querry)) {
            System.out.println("entre al eliminar_cliente administrador");
            return true;
        }
        conectar.closeConnection();
        return false;
    }

    public boolean agregar_cliente(int documento, String nombre, String apellido, int sueldo, String cliente_potencial, int telefono, int id_pass, int id_cuenta, int id_historial) throws ClassNotFoundException, SQLException, Exception {
        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "INSERT INTO `cliente`(`id_cliente`, `documento`, `nombre`, `apellido`, `sueldo`, `cliente_potencial`, `telefono`, `id_password_FK`, `id_cuenta_FK`, `id_historial_FK`) VALUES ('','+" + documento + "','" + nombre + "','" + apellido + "','" + sueldo + "','" + cliente_potencial + "','" + telefono + "','" + id_pass + "','" + id_cuenta + "','" + id_historial + "');";
        if (conectar.sql(querry)) {
            System.out.println("entre al eliminar_cliente administrador");
            return true;
        }
        conectar.closeConnection();
        return false;
    }
}
