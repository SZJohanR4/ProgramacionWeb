/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.uniminutero.banco;

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

    public void insert(String user, String password) throws Exception {
        String encripcion = md5(password);
        try {
            String querry = "insert into usuarios (`usuario`, `password`) " + " VALUES (" + "'" + user + "'" + "," + "'" + encripcion + "'" + ");";
            java.sql.Statement st = (java.sql.Statement) conexion.createStatement();
            st.executeUpdate(querry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se almacenaron los datos");
        }
    }

    public void select() throws SQLException {
        try {
            String querry = "select * from usuarios";
            java.sql.Statement st = (java.sql.Statement) conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(querry);

            while (resultSet.next()) {
                System.out.println("Usuario: " + resultSet.getString("usuario")
                        + " Password: " + resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }

    private static String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }
}
