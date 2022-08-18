/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cleo.todoapp.util.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author Cleo
 */
public class ConnectionFactory {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:TodoAPP.db";

    /**
     * Get a connection to the database
     *
     * @return Connection object
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            return DriverManager.getConnection(URL, config.toProperties());

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Get a connection to the database
     *
     * @return Connection object
     */
//    public static Connection getConnection() {
//        try {
//            Class.forName(DRIVER);
//            return DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,
//                    "Database connection error", ex);
//            return null;
//        }
//    }
    /**
     *
     * Receive a connection and close it
     *
     * @param con
     *
     */
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Could not close connection", ex);
            }
        }
    }

    /**
     * Receive a connection and a prepared statement and close it
     *
     * @param conn
     * @param stmt
     *
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Could not close PreparedStatement",
                    ex);
        }
    }

    /**
     *
     * Receive a connection, a prepared statement and a result set and close
     * them
     *
     * @param conn
     * @param stmt
     * @param rs
     *
     */
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Could not close PreparedStatement",
                    ex);
        }
    }
}
