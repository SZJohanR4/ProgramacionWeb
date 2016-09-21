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
public class Cliente extends Persona {

    @Override
    public String[] consultar_informacion(int id_cuenta) throws ClassNotFoundException, SQLException, Exception {
        return super.consultar_informacion(id_cuenta); //To change body of generated methods, choose Tools | Templates.
    }
    
    

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

    public boolean pedir_credito(int cantidad, int id, String tipo_credito) throws ClassNotFoundException, SQLException, Exception {

        Conexion conectar = new Conexion();
        Conexion.conexionDB();
        String querry = "SELECT `saldos` FROM historial WHERE id_historial=" + id + " ORDER BY `fecha` LIMIT 3 ";
        String resultConsult[] = conectar.select(querry).split(" ");
        int saldo1 = Integer.parseInt(resultConsult[0]);
        int saldo2 = Integer.parseInt(resultConsult[1]);
        int saldo3 = Integer.parseInt(resultConsult[2]);
        int sumatoriaSueldo = saldo1 + saldo2 + saldo3;

        return aprobar_credito(cantidad, sumatoriaSueldo, id, tipo_credito);
    }

    private boolean aprobar_credito(int cantidad, int sumatoriaSueldo, int id, String tipo_credito) throws ClassNotFoundException, SQLException, Exception {
        if (cantidad % 30 < sumatoriaSueldo) {//tengo mayor saldo que la cantidad e mi prestamos
            Conexion conectar = new Conexion();
            Conexion.conexionDB();
            String querry = "INSERT INTO `credito_bancario`(`id_credito`, `tipo_credito`, `valor`, `estado`, `fechar_creacion`, `id_cliente_FK`) VALUES ('','" + tipo_credito + "','" + cantidad + "','aprobado','CURRENT_TIMESTAMP','" + id + "')";
            if (conectar.sql(querry)) {
                System.out.println("entre al crear_cuenta administrador");
                return true;
            }
            conectar.closeConnection();
        } else {
            return false;
        }
        return false;
    }
    
    public boolean cancelar_credito(int id) throws ClassNotFoundException, SQLException, Exception{
        Conexion conectar = new Conexion();
            Conexion.conexionDB();
            String querry="UPDATE `credito_bancario` SET `estado`='desaprobado',`fechar_creacion`='CURRENT_TIMESTAMP' WHERE `id_cliente_FK`="+id;
            if (conectar.sql(querry)) {
                System.out.println("entre al cancelar credito administrador");
                return true;
            }
            return false;
            
    }
    
    
}
