package br.com.cleo.todoapp.controller;

import br.com.cleo.todoapp.model.Task;
import br.com.cleo.todoapp.util.table.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class TaskController {

    /**
     * Save a task in the database
     * 
     * @param task Receive a task and save in the database
     * @return Task object with the id of the task saved in the database
     */
    public Task save(Task task) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO tasks(name, description, is_completed, deadline,"
                + " createdAt, updatedAt, projects_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setBoolean(3, task.isCompleted());
            stmt.setObject(4, task.getDeadline());
            stmt.setObject(5, task.getCreatedAt());
            stmt.setObject(6, task.getUpdatedAt());
            stmt.setInt(7, task.getProjectId());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                task.setId(generatedKeys.getInt(1));
            } else {
                Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to get task id");
            }
            return task;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to save task", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return null;

    }

    /**
     * Update a task in the database
     * 
     * @param task Receive a task and update in the database
     * @return Task object updated in the database
     */
    public Task update(Task task) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "UPDATE tasks SET name = ?, description = ?, is_completed = ?, deadline =?,"
                + " createdAt = ?, updatedAt = ?, projects_id = ? WHERE id = ?";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setBoolean(3, task.isCompleted());
            stmt.setObject(4, task.getDeadline());
            stmt.setObject(5, task.getCreatedAt());
            stmt.setObject(6, LocalDateTime.now());
            stmt.setInt(7, task.getProjectId());
            stmt.setInt(8, task.getId());
            int executeUpdate = stmt.executeUpdate();
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO,
                    executeUpdate > 0 ? "Task updated successfully" : "Task update failed");

            return task;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to save task", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return null;

    }

    /**
     * Delete a task in the database
     * 
     * @param id Receive the id of the task and delete in the database
     * @return boolean true if the task was deleted successfully
     */
    public boolean removeById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM tasks WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            Logger.getLogger(TaskController.class.getName()).log(Level.INFO, "Successful deleting task");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "Unable to delete task", ex);
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return false;
    }

    /**
     * Get all tasks from the database filtered by project id
     * 
     * @param projectId Receive the id of the project and return all tasks of
     *                  the project
     * @return List of tasks of the project
     */
    public List<Task> getAll(int projectId) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM tasks WHERE projects_id = ?";
        PreparedStatement stmt;
        List<Task> tasks = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setCompleted(rs.getBoolean("is_completed"));
                task.setDeadline(LocalDateTime.parse(rs.getString("deadline"), DateTimeFormatter.ISO_DATE_TIME));
                task.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setProjectId(rs.getInt("projects_id"));
                tasks.add(task);
            }
            return tasks;
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "No tasks found", ex);
        }

        return null;

    }

    /**
     * Get the task from the database filtered by id
     * 
     * @param id Receive the id of the task and return the task
     * @return Task object
     */
    public Task findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM tasks WHERE id = ?";
        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setCompleted(rs.getBoolean("is_completed"));
                task.setDeadline(LocalDateTime.parse(rs.getString("deadline"), DateTimeFormatter.ISO_DATE_TIME));
                task.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setProjectId(rs.getInt("projects_id"));
                return task;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "No task found", ex);
        }

        return null;

    }

    /**
     * Get the task from the database filtered by name
     * 
     * @param name
     * @return Task object
     */
    public Task findByName(String name) {
        Connection conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM tasks WHERE name = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
                task.setCompleted(rs.getBoolean("is_completed"));
                task.setDeadline(LocalDateTime.parse(rs.getString("deadline"), DateTimeFormatter.ISO_DATE_TIME));
                task.setCreatedAt(LocalDateTime.parse(rs.getString("createdAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setUpdatedAt(LocalDateTime.parse(rs.getString("updatedAt"), DateTimeFormatter.ISO_DATE_TIME));
                task.setProjectId(rs.getInt("projects_id"));
                return task;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, "No task found", ex);
        }

        return null;

    }
}
