import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q5 extends JFrame {

    private JList<String> courseList;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField studentNameField;

    public Q5() {
        setTitle("Student Course Management System");
        setSize(650, 420);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] courses = {"Java Programming", "Data Structures", "DBMS", "Computer Networks", "Operating Systems"};
        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(courseList);
        listScrollPane.setPreferredSize(new Dimension(200, 300));

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Available Courses"), BorderLayout.NORTH);
        leftPanel.add(listScrollPane, BorderLayout.CENTER);

        String[] columnNames = {"Student Name", "Course", "Enrollment Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField(15);
        topPanel.add(studentNameField);

        JButton addButton = new JButton("Add Registration");
        JButton removeButton = new JButton("Remove Registration");
        topPanel.add(addButton);
        topPanel.add(removeButton);

        add(leftPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);
        add(topPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameField.getText();
                String selectedCourse = courseList.getSelectedValue();

                if (studentName.isEmpty() || selectedCourse == null) {
                    JOptionPane.showMessageDialog(null,
                            "Please enter a student name and select a course.",
                            "Missing Information", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                tableModel.addRow(new Object[]{studentName, selectedCourse, "Enrolled"});
                studentNameField.setText("");
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please select a row in the table to remove.",
                            "No Selection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Q5();
    }
}
