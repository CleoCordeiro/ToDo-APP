/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.cleo.todoapp.view;

import br.com.cleo.todoapp.controller.ProjectController;
import br.com.cleo.todoapp.model.Project;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Cleo
 */
public class ProjectDialogScreen extends javax.swing.JDialog {

    private final ProjectController projectDAO;
    private final Project project;
    private final boolean save;

    /**
     * Creates new form ProjectDialogScreen
     * Constructor from save
     * 
     * @param parent
     * @param modal
     */
    public ProjectDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        project = new Project();
        projectDAO = new ProjectController();
        hideErrorFields();
        save = true;
    }

    /**
     * Constructor from update
     * 
     * @param parent
     * @param modal
     * @param project : project to update
     */
    public ProjectDialogScreen(java.awt.Frame parent, boolean modal, Project project) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.project = project;
        projectDAO = new ProjectController();
        hideErrorFields();
        save = false;
        setFields();
    }

    /**
     * This method set the fields of the form if custructor is from update
     */
    private void setFields() {
        jTextFieldProjectName.setText(project.getName());
        jTextAreaProjectDescription.setText(project.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelToolBar = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelIco = new javax.swing.JLabel();
        jPanel = new javax.swing.JPanel();
        jLabelName = new javax.swing.JLabel();
        jTextFieldProjectName = new javax.swing.JTextField();
        jLabelProjectDescription = new javax.swing.JLabel();
        jScrollPaneDescription = new javax.swing.JScrollPane();
        jTextAreaProjectDescription = new javax.swing.JTextArea();
        jLabelErrorName = new javax.swing.JLabel();
        JPanelBanner = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(null);
        setResizable(false);

        jPanelToolBar.setBackground(new java.awt.Color(0, 153, 102));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitle.setText("Projeto");

        jLabelIco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelIco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelIcoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
                jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelToolBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIco, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        jPanelToolBarLayout.setVerticalGroup(
                jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanelToolBarLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanelToolBarLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelIco, javax.swing.GroupLayout.DEFAULT_SIZE, 48,
                                                        Short.MAX_VALUE))
                                        .addContainerGap()));

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabelName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelName.setText("Nome");

        jTextFieldProjectName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldProjectName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldProjectNameKeyPressed(evt);
            }
        });

        jLabelProjectDescription.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelProjectDescription.setText("Descrição");

        jTextAreaProjectDescription.setColumns(20);
        jTextAreaProjectDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreaProjectDescription.setRows(5);
        jTextAreaProjectDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaProjectDescriptionKeyPressed(evt);
            }
        });
        jScrollPaneDescription.setViewportView(jTextAreaProjectDescription);

        jLabelErrorName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelErrorName.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErrorName.setText("O campo nome é obrigatório");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelName, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelErrorName, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelProjectDescription,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                                        .addComponent(jTextFieldProjectName, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(6, 6, 6)));
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelErrorName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProjectName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelProjectDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        JPanelBanner.setBackground(new java.awt.Color(162, 219, 248));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projeto.png"))); // NOI18N

        javax.swing.GroupLayout JPanelBannerLayout = new javax.swing.GroupLayout(JPanelBanner);
        JPanelBanner.setLayout(JPanelBannerLayout);
        JPanelBannerLayout.setHorizontalGroup(
                JPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE));
        JPanelBannerLayout.setVerticalGroup(
                JPanelBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPanelBannerLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, Short.MAX_VALUE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JPanelBanner, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }

    /**
     * Listener enter key pressed.
     * call SaveOrUpdateProject method.
     * 
     * @param evt : KeyEvent enter key pressed.
     */
    private void jTextFieldProjectNameKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextFieldProjectNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SaveOrUpdate();
        }
    }

    /**
     * Listener enter key pressed.
     * call SaveOrUpdateProject method.
     * 
     * @param evt : KeyEvent enter key pressed.
     */
    private void jTextAreaProjectDescriptionKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextAreaProjectDescriptionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SaveOrUpdate();
        }
    }

    /**
     * Listener button clicked.
     * call SaveOrUpdateProject method.
     * 
     * @param evt : ActionEvent button clicked.
     */
    private void jLabelIcoMousePressed(java.awt.event.MouseEvent evt) {
        SaveOrUpdate();
    }

    /**
     * Save or update project.
     */
    private void SaveOrUpdate() {
        if (jTextFieldProjectName.getText().isBlank()) {
            showErrorFields(jLabelErrorName);
        } else {
            hideErrorFields();
            project.setName(jTextFieldProjectName.getText());
            project.setDescription(jTextAreaProjectDescription.getText());
            try {
                if (this.save) {
                    projectDAO.save(project);
                    JOptionPane.showMessageDialog(rootPane, "Projeto salvo com sucesso", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    project.setId(project.getId());
                    projectDAO.update(project);
                }
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                this.dispose();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ProjectDialogScreen dialog = new ProjectDialogScreen(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBanner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelErrorName;
    private javax.swing.JLabel jLabelIco;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelProjectDescription;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JTextArea jTextAreaProjectDescription;
    private javax.swing.JTextField jTextFieldProjectName;
    // End of variables declaration//GEN-END:variables

    /**
     * Hide error fields.
     */
    public final void hideErrorFields() {
        jLabelErrorName.setVisible(false);
    }

    /**
     * Show error fields.
     * 
     * @param label : JLabel error fields.
     */
    public void showErrorFields(JLabel label) {
        label.setVisible(true);
    }
}
