import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Q6 extends JFrame {

    private JTextArea textArea;

    public Q6() {
        setTitle("Simple Text Editor");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem selectAllItem = new JMenuItem("Select All");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(selectAllItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        newItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        cutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.cut();
            }
        });

        copyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.copy();
            }
        });

        pasteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.paste();
            }
        });

        selectAllItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        if (java.awt.GraphicsEnvironment.isHeadless()) {
            runConsoleVersion();
            return;
        }
        new Q6();
    }

    private static void runConsoleVersion() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String clipboard = "";

        while (true) {
            System.out.println("\nSimple Text Editor");
            System.out.println("1. View text");
            System.out.println("2. Append a line");
            System.out.println("3. New / Clear");
            System.out.println("4. Cut all text");
            System.out.println("5. Copy all text");
            System.out.println("6. Paste at end");
            System.out.println("7. Select all");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                case "7":
                    System.out.println("----- Text -----");
                    System.out.println(text.length() == 0 ? "(empty)" : text.toString());
                    System.out.println("----------------");
                    break;
                case "2":
                    System.out.print("Line to append: ");
                    text.append(scanner.nextLine()).append(System.lineSeparator());
                    break;
                case "3":
                    text.setLength(0);
                    System.out.println("Text cleared.");
                    break;
                case "4":
                    clipboard = text.toString();
                    text.setLength(0);
                    System.out.println("Text cut to the editor clipboard.");
                    break;
                case "5":
                    clipboard = text.toString();
                    System.out.println("Text copied to the editor clipboard.");
                    break;
                case "6":
                    text.append(clipboard);
                    System.out.println("Clipboard pasted at the end.");
                    break;
                case "8":
                    scanner.close();
                    return;
                default:
                    System.out.println("Choose an option from 1 to 8.");
            }
        }
    }
}
