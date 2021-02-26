package com.techbeesolutions.BankAPI;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BankUserDB {
    Scanner input = new Scanner(System.in);

    ArrayList<BankUserModel> UserAccounts = new ArrayList<>();


    public void addUserDB(BankUserModel user) {//Insert

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://usersdb.ctlcmd5kzm5e.us-west-1.rds.amazonaws.com:3306/UserDB";
        final String USER = "admin";
        final String PASS = "UnlimitedPower!";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO userTable VALUES (" +
                    "'"+user.getBalance()+"', " +
                    "'"+user.getfName()+"', " +
                    "'"+user.getlName()+"', " +
                    "'"+user.getEmail()+"', " +
                    "'"+user.getAccNumber()+"', " +
                    "'"+user.getPhoneNum()+"');";


            stmt.executeUpdate(sql);
            System.out.println("********************************");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserDB(String x) {                      //Remove
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://usersdb.ctlcmd5kzm5e.us-west-1.rds.amazonaws.com:3306/UserDB";
        final String USER = "admin";
        final String PASS = "UnlimitedPower!";

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Choose Email Account to Delete: ");

            String sql = "delete from userTable where Email = " +"'"+ x +"'"+ ";";
            Statement stmt = conn.createStatement();

            System.out.println("Deleted: " + x);


            stmt.executeUpdate(sql);
            System.out.println("********************************");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void updateUserInfoDB(String x) {                      //Update
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://usersdb.ctlcmd5kzm5e.us-west-1.rds.amazonaws.com:3306/UserDB";
        final String USER = "admin";
        final String PASS = "UnlimitedPower!";

        Connection conn = null;

        BankUserModel user = new BankUserModel();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "Update userTable set FirstName = " + "'"+ x +"'"+ "\n where email = " +"'"+ user.getEmail() +"'"+ ";";
            Statement stmt = conn.createStatement();


            stmt.executeUpdate(sql);
            System.out.println("********************************");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<BankUserModel> displayUserDB() {                                           //Display
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://usersdb.ctlcmd5kzm5e.us-west-1.rds.amazonaws.com:3306/UserDB";
        final String USER = "admin";
        final String PASS = "UnlimitedPower!";

        Connection conn = null;

        ArrayList<BankUserModel> userInfo = new ArrayList<BankUserModel>();

        try {
            Class.forName("com.mysql.jdbc.Driver");


            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "select * from UserDB.userTable;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BankUserModel user = new BankUserModel();
                user.setfName(rs.getString("FirstName"));
                user.setlName(rs.getString("LastName"));
                user.setBalance(rs.getFloat("Balance"));
                user.setEmail(rs.getString("Email"));
                userInfo.add(user);
            }


            System.out.println("********************************");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

}
