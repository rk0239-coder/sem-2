import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Q4 extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox rememberMeBox;
    private JCheckBox notificationsBox;

    public Q4() {
        setTitle("User Login");
        setSize(350, 280);
        setLayout(new GridLayout(6, 1, 8, 8));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        userPanel.add(usernameField);
        add(userPanel);

        JPanel passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        passPanel.add(passwordField);
        add(passPanel);

        rememberMeBox = new JCheckBox("Remember Me");
        add(rememberMeBox);

        notificationsBox = new JCheckBox("Receive Notifications");
        add(notificationsBox);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                String preferences = "";
                if (rememberMeBox.isSelected()) {
                    preferences += "Remember Me enabled. ";
                }
                if (notificationsBox.isSelected()) {
                    preferences += "Notifications enabled.";
                }

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                } else {
                    String message = "Welcome, " + username + "!\n" + preferences;
                    JOptionPane.showMessageDialog(null, message, "Login Successful",
                            JOptionPane.INFORMATION_MESSAGE);
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
        new Q4();
    }

    private static void runConsoleVersion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Login");
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Login failed: enter both username and password.");
            scanner.close();
            return;
        }

        System.out.print("Remember me? (y/n): ");
        boolean rememberMe = scanner.nextLine().trim().equalsIgnoreCase("y");
        System.out.print("Receive notifications? (y/n): ");
        boolean notifications = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.println("Welcome, " + username + "!");
        if (rememberMe) {
            System.out.println("Remember Me enabled.");
        }
        if (notifications) {
            System.out.println("Notifications enabled.");
        }
        scanner.close();
    }
}
