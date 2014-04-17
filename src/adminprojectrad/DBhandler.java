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
    String dbName = "royaladdb";
    String user = "root";
    String pwd = "root";
    private Statement statement = null;

    public void connectingDatabase() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Hitta instancen");
        } catch (Exception ex) {
            System.out.println("Ingen instance funnen");
        }

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://89.160.102.9:3306/" + dbName
                    + "?user=" + user + "&password=" + pwd);
            System.out.println("Connecta till " + dbName);
        } catch (Exception ex) {
            System.out.println("Ingen connection");
            System.out.println(ex);
        }

    }

    public void fetchingDataIntoHotell(String name, String country, String city, String address, String info, String url) {

        try {
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(
                    "Insert into hotel (hotelname,country,city,address,info,imageurl)" + "VALUES "
                    + "('" + name + "','"
                    + country + "','" + city + "','" + address + "','" + info + "','" + url + "');");

            System.out.println("Funkar i tredje try");
            System.out.println(rowsAffected);
        } catch (Exception e) {
            System.out.println("Funkar inte i tredje try pga: ");
            System.out.println(e);
        }
    }

    public void fetchingDataIntoCostumer(int ssn, String fname, String lname, String mail, String address,
            int zip, String cell, String homephone, int hotelid, int flightid) {

        try {
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(
                    "Insert into costumer (ssn,firstname,lastname,mail,address,zipcode,homenumber,cellphone,hotel_hotelid,flight_flightid)"
                    + "VALUES "
                    + "(" + ssn + ",'"
                    + fname + "','" + lname + "','" + mail + "','" + address + "'," + zip + ",'" + homephone + "','" + cell + "',"
                    + hotelid + "," + flightid + ");");

            System.out.println("Funkar i tredje try");
            System.out.println(rowsAffected);
        } catch (Exception e) {
            System.out.println("Funkar inte i tredje try pga: ");
            System.out.println(e);
        }
    }

    public void fetchDataIntoEmployee(String firstName, String lastName, String userName, String password, String ssn) {
        try {
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(
                    "Insert into Employee (firstname,lastname,username,password,ssn)" + "VALUES "
                    + "('" + firstName + "','"
                    + lastName + "','" + userName + "','" + password + "','" + ssn + "');");

            System.out.println("Funkar i tredje try");
            System.out.println(rowsAffected);
        } catch (Exception e) {
            System.out.println("Funkar inte i tredje try pga: ");
            System.out.println(e);
        }
    }

    public void fetchingDataToflight(String company, int seats, String airport) {

        try {
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(
                    "Insert into flight (companyname,passangerseats,airport)" + "VALUES "
                    + "('" + company + "',"
                    + seats + ",'" + airport + "');");

            System.out.println("Funkar i tredje try");
            System.out.println(rowsAffected);
        } catch (Exception e) {
            System.out.println("Funkar inte i tredje try pga: ");
            System.out.println(e);
        }

    }

    public void getCostumerData() throws SQLException {

        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM costumer");
            while (rs.next()) {
                System.out.println(rs.getString("firstname") + ":"
                        + rs.getString("lastname") + rs.getString("mail"));

            }
            System.out.println("Andra try success");
        } catch (Exception ex) {
            System.out.println("Andra try fail" + ex);
        } finally {
            rs.close();
        }
    }

    public void getFlightData() throws SQLException {
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM flight");
            while (rs.next()) {
                System.out.println(rs.getString("companyname")
                        + rs.getString("passangerseats") + rs.getString("airport"));
            }
            System.out.println("Andra try success");
        } catch (Exception ex) {
            System.out.println("Andra try fail" + ex);
        } finally {
            rs.close();
        }
    }

    public void getEmployeeData() throws SQLException {
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println(rs.getString("firstname")
                        + rs.getString("lastname") + rs.getString("ssn"));
            }
            System.out.println("Andra try success");
        } catch (Exception ex) {
            System.out.println("Andra try fail" + ex);
        } finally {
            rs.close();
        }
    }

    public void getHotelData() throws SQLException {

        ResultSet rs = null;

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM hotel");
            while (rs.next()) {
                System.out.println(rs.getString("hotelname")
                        + rs.getString("country") + rs.getString("hotelid"));
            }
            System.out.println("Andra try success");
        } catch (Exception ex) {
            System.out.println("Andra try fail" + ex);
        } finally {
            rs.close();
        }

    }

}
