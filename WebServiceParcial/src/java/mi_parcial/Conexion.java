package mi_parcial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class Conexion {

    private static java.sql.Connection conexion = null;

    public static java.sql.Connection conexionDB() throws ClassNotFoundException, SQLException {

        if (conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/prog_web", "root", "");

            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }

        return conexion;
    }

    public void closeConnection() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean sql(String Querry) throws Exception {
        try {
            String querry = Querry;
            System.out.println(querry + " querry en insert");
            java.sql.Statement st = (java.sql.Statement) conexion.createStatement();
            st.executeUpdate(querry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se almacenaron los datos");
            return false;
        }
        return true;
    }

    public String select(String query) throws SQLException {
        String result="";
        try {

            java.sql.Statement st = (java.sql.Statement) conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(query);
            if (resultSet.next()) {
                while (resultSet.next()) {
                    result = resultSet.getString("saldo")+" ";
                    
                }
            } else {

                result = null;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        return result;
    }
    
    
     public String informacion(String query) throws SQLException {
        String result="";
        try {

            java.sql.Statement st = (java.sql.Statement) conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(query);
            if (resultSet.next()) {
                while (resultSet.next()) {
                    result = resultSet.getString("estado_cuenta")+" "+resultSet.getString("numero_cuenta")+" "+resultSet.getString("sucursal")+" "+resultSet.getString("saldo");
                    
                }
            } else {

                result = null;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        return result;
    }

   
}
