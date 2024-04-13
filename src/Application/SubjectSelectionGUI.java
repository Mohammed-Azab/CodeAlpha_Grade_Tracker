package Application;
import DataBase.Cloud;
import DataBase.DataRepository;
import DataBase.Subject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SubjectSelectionGUI extends javax.swing.JFrame {
    Cloud c= new Cloud();
    DataRepository DR;

    public SubjectSelectionGUI() {
        initComponents();
        setTitle("Grade Tracker");
        setIcon();
        setSize(380, 430);
        setLocationRelativeTo(null);
    }

  private void initComponents() {

      JPanel jPanel1 = new JPanel();
      JLabel jLabel1 = new JLabel();
    jComboBox1 = new javax.swing.JComboBox<>();
      JButton jButton1 = new JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setResizable(false);

    jLabel1.setText("Select a Subject:");


      jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(c.getAllSubjectNames()));

    jButton1.setText("Submit");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap(100, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel1)
                                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                            .addContainerGap(100, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap(100, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1)
                            .addContainerGap(100, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel1, BorderLayout.CENTER);

    pack();
}



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedSubject = (String) jComboBox1.getSelectedItem();
        if (c.isDataExist(selectedSubject)) {
            Subject subj= c.getSubjectByName(selectedSubject);
            DR = new DataRepository(subj);
            Results core = new Results(subj);
            core.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Grades for " + selectedSubject + " are not available yet.", "Subject Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    private void setIcon() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/Application/icons/logo.png");
            assert inputStream != null;
            BufferedImage iconImage = ImageIO.read(inputStream);


            setIconImage(iconImage);
        } catch (IOException ex) {
            System.out.println("Error loading icon image: " + ex.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubjectSelectionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubjectSelectionGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> jComboBox1;
}
