/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendadecontactos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Connect {

    public static String dbURL = "jdbc:derby://localhost:1527/contactos;create=true;user=APP;password=APP;";
    public static String tableName = "listacontactos";
    // jdbc Connection
    public static Connection conn = null;
    public static Statement stmt = null;

    public static void createConnection() {
        try {
            //stmt.executeUpdate("SET SCHEMA APP");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    public static void insertContacto(int id, String nombre, String telefono, String correo) {
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values ("
                    + id + ",'" + nombre + "','" + telefono + "','" + correo + "')");
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    public static void updateContacto(int id, String nombre, String telefono, String correo) {
        String updateTableSQL = "UPDATE " + tableName + " SET nombre = ?, telefono = ?, correo = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            createConnection();
            preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, telefono);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, id);

            // execute update SQL stetement
            preparedStatement.executeUpdate();
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    public static void removeContacto(int id)// throws SQLException
    {
        String deleteSQL = "DELETE FROM listacontactos WHERE ID = ?";
        PreparedStatement preparedStatement = null;

        try {
            createConnection();
            preparedStatement = conn.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, 1);

            // execute delete SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is deleted!");

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    public static void fillTable(JTable table) {
        try {
            createConnection();

            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();

            //To remove previously added rows
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = results.getMetaData().getColumnCount();
            while (results.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = results.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(results.getRow() - 1, row);
            }

            results.close();
            conn.close();
        } catch (SQLException s) {

        }
    }

    public static void selectRestaurants() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();

            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    public static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {

        }

    }
}
