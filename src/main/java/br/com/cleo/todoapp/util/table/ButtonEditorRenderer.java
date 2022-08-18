package br.com.cleo.todoapp.util.table;

import static br.com.cleo.todoapp.util.table.ChangeColorCell.ChangeColor;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * Custom cell editor and renderer for the table.
 * 
 * @author Cleo
 */
public class ButtonEditorRenderer extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor {

    private final CheckBoxPanel editor = new CheckBoxPanel();
    private final CheckBoxPanel renderer = new CheckBoxPanel();
    private String icon;

    class CheckBoxPanel extends JPanel {

        public final JButton button = new JButton();

        public CheckBoxPanel() {
            super(new GridBagLayout());
            add(button);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
        }

    }

    /**
     * 
     * @param icon the icon to set to the button.
     */
    public ButtonEditorRenderer(String icon) {
        this.icon = icon;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        this.renderer.button.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));

        ChangeColor(table, row, (Component) renderer, isSelected);
        return renderer;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        this.editor.button.setIcon(new ImageIcon(getClass().getClassLoader().getResource(icon)));
        ChangeColor(table, row, (Component) renderer, isSelected);
        return editor;
    }

    @Override
    public Object getCellEditorValue() {
        return editor.button.isSelected();
    }

    public JButton getCheckbox() {
        return editor.button;
    }

}
