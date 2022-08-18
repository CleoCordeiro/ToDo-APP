/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cleo.todoapp.util.table;

import static br.com.cleo.todoapp.util.table.ChangeColorCell.ChangeColor;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Cleo
 */
public class CheckBoxEditorRenderer extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor {

    private final CheckBoxPanel editor = new CheckBoxPanel();
    private final CheckBoxPanel renderer = new CheckBoxPanel();

    class CheckBoxPanel extends JPanel {

        public final JCheckBox button = new JCheckBox();

        public CheckBoxPanel() {
            super(new GridBagLayout());
            add(button);
            button.setOpaque(false);
        }

    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        renderer.button.setSelected((boolean) value);
        ChangeColor(table, row, (Component) renderer, isSelected);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        ChangeColor(table, row, (Component) renderer, isSelected);
        editor.button.setSelected((boolean) value);

        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.button.isSelected();
    }

    public JCheckBox getCheckbox() {
        return editor.button;
    }

}
