import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if (GraphicsEnvironment.isHeadless()) {
            runConsoleVersion();
            return;
        }
        new Q5();
    }

    private static void runConsoleVersion() {
        Scanner scanner = new Scanner(System.in);
        String[] courses = {"Java Programming", "Data Structures", "DBMS", "Computer Networks", "Operating Systems"};
        List<String[]> registrations = new ArrayList<>();

        while (true) {
            System.out.println("\nStudent Course Management");
            System.out.println("1. Add registration");
            System.out.println("2. Remove registration");
            System.out.println("3. List registrations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = readChoice(scanner, 1, 4);

            if (choice == 1) {
                System.out.print("Student name: ");
                String studentName = scanner.nextLine().trim();
                if (studentName.isEmpty()) {
                    System.out.println("Student name cannot be empty.");
                    continue;
                }

                for (int index = 0; index < courses.length; index++) {
                    System.out.println((index + 1) + ". " + courses[index]);
                }
                System.out.print("Choose a course (1-5): ");
                int courseChoice = readChoice(scanner, 1, courses.length);
                registrations.add(new String[]{studentName, courses[courseChoice - 1]});
                System.out.println("Registration added.");
            } else if (choice == 2) {
                if (registrations.isEmpty()) {
                    System.out.println("There are no registrations to remove.");
                    continue;
                }
                printRegistrations(registrations);
                System.out.print("Registration number to remove: ");
                int registrationChoice = readChoice(scanner, 1, registrations.size());
                registrations.remove(registrationChoice - 1);
                System.out.println("Registration removed.");
            } else if (choice == 3) {
                printRegistrations(registrations);
            } else {
                return;
            }
        }
    }

    private static void printRegistrations(List<String[]> registrations) {
        if (registrations.isEmpty()) {
            System.out.println("No registrations yet.");
            return;
        }
        for (int index = 0; index < registrations.size(); index++) {
            String[] registration = registrations.get(index);
            System.out.println((index + 1) + ". " + registration[0] + " | " + registration[1] + " | Enrolled");
        }
    }

    private static int readChoice(Scanner scanner, int minimum, int maximum) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= minimum && choice <= maximum) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
                // Keep prompting until a valid menu option is entered.
            }
            System.out.print("Enter a number from " + minimum + " to " + maximum + ": ");
        }
    }
}
