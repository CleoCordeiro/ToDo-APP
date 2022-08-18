package br.com.cleo.todoapp.util.table;

import static br.com.cleo.todoapp.util.table.ChangeColorCell.ChangeColorCell;
import java.awt.Component;
import java.time.LocalDateTime;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DeadlineColumnCellRendere extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(CENTER);

        TaskTableModel taskTableModel = (TaskTableModel) table.getModel();
        LocalDateTime deadline = taskTableModel.getTasks().get(row).getDeadline();

        ChangeColorCell(table, row, this, isSelected);
        return label;
    }
}
