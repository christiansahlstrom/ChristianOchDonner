/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminprojectrad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Christian von Sahlström
 */
public class DBhandler {

    Connection conn = null;
    String dbName = "corebase";
    String user = "root";
    String pwd = "rooot";

    public void connectingDatabase() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Hitta instancen");
        } catch (Exception ex) {
            System.out.println("Ingen instance funnen");
        }

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/" + dbName
                    + "?user=" + user + "&password=" + pwd);
            System.out.println("Connecta till " + dbName);
        } catch (Exception ex) {
            System.out.println("Ingen connection");
            System.out.println(ex);
        }

    }

    public void fetchingDataIntoEmployee(int id, String name) {

        Statement statement = null;
        ResultSet rs = null;
        try {
            // Connection conn must already be created 
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                System.out.println(rs.getString("id") + ":"
                        + rs.getString("name"));

            }
            System.out.println("Andra try success");
        } catch (Exception ex) {
            System.out.println("Andra try fail");
            ex.printStackTrace();
        } finally {
            // Close the ResultSet and the Statement 
        }

        try {
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(
                    "INSERT INTO person " + "VALUES "
                    + "(" + id + ",'"
                    + name + "')");

            System.out.println("Funkar i tredje try");
            System.out.println(rowsAffected);
        } catch (Exception e) {
            System.out.println("Funkar inte i tredje try");
            System.out.println(e);
        }

    }

}
