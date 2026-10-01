import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Q3 extends JFrame {

    private JTextField nameField;
    private JTextField regNoField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> departmentBox;

    public Q3() {
        setTitle("Student Registration System");
        setSize(420, 320);
        setLayout(new GridLayout(6, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Register Number:"));
        regNoField = new JTextField();
        add(regNoField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        add(genderPanel);

        add(new JLabel("Department:"));
        String[] departments = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
        departmentBox = new JComboBox<>(departments);
        add(departmentBox);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String regNo = regNoField.getText();
                String gender = maleButton.isSelected() ? "Male" :
                        femaleButton.isSelected() ? "Female" : "Not Selected";
                String department = (String) departmentBox.getSelectedItem();

                String message = "Name: " + name +
                        "\nRegister Number: " + regNo +
                        "\nGender: " + gender +
                        "\nDepartment: " + department;

                JOptionPane.showMessageDialog(null, message, "Registration Details",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            runConsoleVersion();
            return;
        }
        new Q3();
    }

    private static void runConsoleVersion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Student Registration System");
        System.out.print("Student name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Register number: ");
        String regNo = scanner.nextLine().trim();

        System.out.print("Gender (1 - Male, 2 - Female, Enter - Not selected): ");
        String genderChoice = scanner.nextLine().trim();
        String gender = "Not Selected";
        if (genderChoice.equals("1")) {
            gender = "Male";
        } else if (genderChoice.equals("2")) {
            gender = "Female";
        }

        String[] departments = {"CSE", "ECE", "MECH", "CIVIL", "IT"};
        System.out.println("Departments:");
        for (int index = 0; index < departments.length; index++) {
            System.out.println((index + 1) + ". " + departments[index]);
        }
        System.out.print("Choose department (1-5): ");
        int departmentChoice = readChoice(scanner, 1, departments.length);

        System.out.println("\nRegistration Details");
        System.out.println("Name: " + name);
        System.out.println("Register Number: " + regNo);
        System.out.println("Gender: " + gender);
        System.out.println("Department: " + departments[departmentChoice - 1]);
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
