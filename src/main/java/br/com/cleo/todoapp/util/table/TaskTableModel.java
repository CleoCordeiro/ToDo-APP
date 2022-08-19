package br.com.cleo.todoapp.util.table;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.cleo.todoapp.model.Task;

public class TaskTableModel extends AbstractTableModel {

    private final String[] columns = { "id", "Name", "Description", "Prazo", "Tarefa Concluida", "Editar", "Excluir" };
    private List<Task> tasks = new ArrayList<>();


    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return List.of(4, 5, 6).contains(columnIndex);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return tasks.isEmpty() ? Object.class
                : this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                tasks.get(rowIndex).getId();
            case 1 ->
                tasks.get(rowIndex).getName();
            case 2 ->
                tasks.get(rowIndex).getDescription();
            case 3 ->
                DateTimeFormatter.ofPattern("HH:mm dd/MM/y").format(tasks.get(rowIndex).getDeadline());
            case 4 ->
                tasks.get(rowIndex).isCompleted();
            case 5 ->
                "";
            case 6 ->
                "";
            default ->
                null;
        };
    }

    public void clear() {
        tasks.clear();
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        fireTableDataChanged();
    }

}
