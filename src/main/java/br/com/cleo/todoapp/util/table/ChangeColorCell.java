/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cleo.todoapp.util.table;

import java.awt.Color;
import java.awt.Component;
import java.time.LocalDateTime;
import javax.swing.JTable;

/**
 *
 * @author Cleo
 */
public class ChangeColorCell {

    public static Component ChangeColorCell(JTable table, int row, Component component) {
        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        LocalDateTime deadline = taskTableModel.getTasks().get(row).getDeadline();
        boolean completed = taskTableModel.getTasks().get(row).isCompleted();

        if (!completed) {
            LocalDateTime now = LocalDateTime.now();
            component.setBackground(
                    deadline.isBefore(now) ? Color.RED
                    : deadline.toLocalDate().isEqual(now.toLocalDate()) ? Color.YELLOW
                    : Color.WHITE
            );
        } else {
            component.setBackground(Color.GREEN);
        }
        return component;
    }

    public static void ChangeColorCell(JTable table, int row, Component component, boolean isSelected) {
        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        LocalDateTime deadline = taskTableModel.getTasks().get(row).getDeadline();
        boolean completed = taskTableModel.getTasks().get(row).isCompleted();

        if (isSelected) {
            component.setBackground(table.getSelectionBackground());
        } else {
            if (!completed) {
                LocalDateTime now = LocalDateTime.now();
                component.setBackground(
                        deadline.isBefore(now) ? Color.RED
                        : deadline.toLocalDate().isEqual(now.toLocalDate()) ? Color.YELLOW
                        : Color.WHITE
                );
            } else {
                component.setBackground(Color.GREEN);
            }

        }
    }
}
