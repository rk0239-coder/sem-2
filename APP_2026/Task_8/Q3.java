import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        new Q3();
    }
}
