package Application;

import DataBase.Cloud;
import DataBase.DataRepository;
import DataBase.Subject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Results extends JFrame {
    Cloud c = new Cloud();
    DataRepository DR;

    private void initComponents(String[] studentNames, double[] grades, int[] studentIds, String subjectName) {
        setTitle("Grade Tracker");
        setIcon();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Student ranking, " + subjectName);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Rank");
        tableModel.addColumn("Student ID");
        tableModel.addColumn("Student Name");
        tableModel.addColumn("Grade");

        // Populate the table model with data
        for (int i = 0; i < studentNames.length; i++) {
            Object[] rowData = {(i + 1), studentIds[i], studentNames[i], grades[i]};
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        double highestGrade = DR.getHighestGrade();
        double smallestGrade = DR.getLowestGrade();
        double averageGrade = DR.getAverage();

        JLabel statsLabel = new JLabel("Highest Grade: " + highestGrade + " | Smallest Grade: " + smallestGrade + " | Average Grade: " + averageGrade);
        statsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statsLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        mainPanel.add(statsLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
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

    public Results(Subject subject) {
        DR = new DataRepository(subject);
        initComponents(DR.getAllNamesInRanking(), DR.getAllGradesInRanking(), DR.getAllIdsInRanking(), subject.getName());
    }

    public Results() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Results::new);
    }
}
