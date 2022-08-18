/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cleo.todoapp.util;

import br.com.cleo.todoapp.util.table.ConnectionFactory;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDB {

    /**
     * Create the database and the tables
     * if they don't exist.
     */
    public static void createDB() {
        Connection conn = ConnectionFactory.getConnection();
        if (!checkExistDB(conn)) {
            createTableProjects(conn);
            createTableTasks(conn);
        }

        ConnectionFactory.closeConnection(conn);
    }

    /**
     * Check if the database exists.
     *
     * @param conn : Connection to the database.
     * @return true if the database exists.
     */
    private static boolean checkExistDB(Connection conn) {
        try {
            DatabaseMetaData databaseMetaData = conn.getMetaData();

            try (ResultSet rs = databaseMetaData.getTables(null, null, null, new String[] { "TABLE" })) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Create the table projects.
     *
     * @param conn : Connection to the database.
     */
    public static void createTableProjects(Connection conn) {
        try {
            PreparedStatement stmt;

            String sql = """
                       CREATE TABLE IF NOT EXISTS projects (
                       id INTEGER PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       description VARCHAR(255) NOT NULL,
                       createdAt datetime NOT NULL,
                       updatedAt datetime NOT NULL)
                    """;

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Create the table tasks.
     *
     * @param conn : Connection to the database.
     */
    public static void createTableTasks(Connection conn) {
        try {
            PreparedStatement stmt;
            String sql = """
                       CREATE TABLE IF NOT EXISTS tasks (
                       id INTEGER PRIMARY KEY,
                       name VARCHAR(50) NOT NULL,
                       description VARCHAR(255) NOT NULL,
                       is_completed BOOLEAN NOT NULL,
                       deadline datetime NOT NULL,
                       createdAt datetime NOT NULL,
                       updatedAt datetime NOT NULL,
                       projects_id INT NOT NULL,
                       CONSTRAINT fk_tasks_projects
                       FOREIGN KEY (projects_id)
                       REFERENCES projects (id)
                       ON DELETE CASCADE
                       ON UPDATE CASCADE);
                    """;

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
