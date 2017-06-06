/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendadecontactos;

import static agendadecontactos.Connect.createConnection;
import static agendadecontactos.Connect.selectRestaurants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static agendadecontactos.Connect.insertContacto;

/**
 *
 * @author USER
 */
public class AgendaDeContactos {

    /**
     * @param args the command line arguments
     */
    
//    private static String dbURL = "jdbc:derby://localhost:1527/restaurant;create=true;user=root;password=root;";
//    private static String tableName = "restaurants";
//    // jdbc Connection
//    private static Connection conn = null;
//    private static Statement stmt = null;
    
    public static void main(String[] args) {
//        SlashScreen m = new SlashScreen();
//        m.setSize(820, 284);
//        m.setLocationRelativeTo(null);
//        m.setVisible(true);
        
        //createConnection();
        //insertContacto(0, "Jesus", "87188", "jesus@correo.com");
        //selectRestaurants();
        GUI g = new GUI();
        g.setVisible(true);
    }
    
//    public static void createConnection()
//    {
//        try
//        {
//            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
//            //Get a connection
//            conn = DriverManager.getConnection(dbURL); 
//        }
//        catch (Exception except)
//        {
//            except.printStackTrace();
//        }
//    }
//    
//    private static void insertRestaurants(int id, String restName, String cityName)
//    {
//        try
//        {
//            stmt = conn.createStatement();
//            stmt.execute("insert into " + tableName + " values (" +
//                    id + ",'" + restName + "','" + cityName +"')");
//            stmt.close();
//        }
//        catch (SQLException sqlExcept)
//        {
//            sqlExcept.printStackTrace();
//        }
//    }

    
    
}
