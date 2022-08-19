package br.com.cleo.todoapp.controller;

import br.com.cleo.todoapp.model.Project;
import br.com.cleo.todoapp.util.table.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cleo
 */
public class ProjectController {

    /**
     * Save a project in the database
     * 
     * @param project Receive a project and save in the database
     * @return Project object with the id of the project saved in the database
     */
    public boolean save(Project project) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO projects(name, description, createdAt, updatedAt) VALUES(?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setObject(3, project.getCreatedAt());
            stmt.setObject(4, project.getUpdatedAt());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to save project", ex);
            throw new RuntimeException(ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    /**
     * Update a project in the database
     * 
     * @param project Receive a project and update in the database
     * @return Project object with the id of the project updated in the database
     */
    public Project update(Project project) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE projects SET name = ?, description = ?, updatedAt = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDescription());
            stmt.setObject(3, LocalDateTime.now());
            stmt.setInt(4, project.getId());
            int executeUpdate = stmt.executeUpdate();
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO,
                    executeUpdate > 0 ? "Task updated successfully" : "Task update failed");
            return project;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to update project", ex);

        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return null;
    }

    /**
     * Delete a project in the database
     * 
     * @param id Receive the id of the project to be deleted
     * @return true if the project was deleted successfully
     * @throws Exception
     */
    public boolean removeById(int id) throws Exception {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM projects WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            throw new Exception("Unable to delete project", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    /**
     * Find a project by id in the database
     * 
     * @param id Receive the id of the project to be found
     * @return Project object with the id of the project found in the database
     */
    public Project findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM projects WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                project.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                return project;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to find project", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    /**
     * Find projects by name in the database
     * 
     * @param name Receive the name of the project to be found
     * @return Project object with the id of the project found in the database
     */
    public Project findByName(String name) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM projects WHERE name = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                project.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                project.setTasks(new TaskController().getAll(project.getId()));
                return project;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to find project", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }

    /**
     * Find all projects in the database
     * 
     * @return List of projects found in the database
     */
    public List<Project> getAll() {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM projects";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Project> projects = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setDescription(rs.getString("description"));
                project.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                project.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                project.setTasks(new TaskController().getAll(project.getId()));
                projects.add(project);
            }
            return projects;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to find project", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
}
