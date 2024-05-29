import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Signup extends JFrame implements ActionListener {

    private JLabel welcomeText;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private JLabel loginLabel;
    private static final String FILE_PATH = "user_database.txt";
    private static Map<String, String> userDatabase = loadUserDatabase();

    public Signup() {
        setTitle("Signup");
        setSize(400, 500); // Reduced panel size
        getContentPane().setBackground(Color.decode("#FFFFCC"));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setSize(355, 275); // Reduced panel size
        panel.setLocation(50, 50); // Adjusted panel location
        panel.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
        panel.setOpaque(false);

        welcomeText = new JLabel("Welcome!", SwingConstants.CENTER);
        welcomeText.setFont(new Font("Raleway ExtraBold", Font.BOLD,32));
        welcomeText.setBounds(70, 20, 250, 47);
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeText);




        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 120, 76, 20);
        labelUsername.setFont(new Font("Karla", Font.PLAIN, 15));
        panel.add(labelUsername);

        usernameField = new JTextField();
        usernameField.setBounds(10, 140, 370, 35);
        usernameField.setBackground(Color.WHITE);
        usernameField.setForeground(Color.GRAY);
        usernameField.setFont(new Font("Karla", Font.PLAIN, 15));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.add(usernameField);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 185, 76, 20);
        labelPassword.setFont(new Font("Karla", Font.PLAIN, 15));
        panel.add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 205, 370, 35);
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Karla", Font.PLAIN, 15));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.add(passwordField);

        signupButton = new JButton("Signup");
        signupButton.setBounds(95, 255, 200, 35);
        signupButton.setBackground(Color.decode("#84C7AE"));
        signupButton.setForeground(Color.BLACK);
        signupButton.setFont(new Font("Karla", Font.BOLD, 15));
        signupButton.setBorder(BorderFactory.createEmptyBorder());
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupButton.setFocusPainted(false);
        signupButton.addActionListener(this);
        panel.add(signupButton);

        loginLabel = new JLabel("<HTML><U>Already have an account?</U></HTML>", JLabel.CENTER);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginLabel.setFont(new Font("Karla", Font.PLAIN, 14));
        loginLabel.setBounds(90, 300, 200, 35);
        loginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Login();
                dispose();
            }
        });
        panel.add(loginLabel);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (userDatabase.containsKey(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            saveUser(username, password);
            JOptionPane.showMessageDialog(this, "Signup successful");
            dispose();
            new Login();
        }
    }

    private void saveUser(String username, String password) {
        userDatabase.put(username, password);
        saveUserDatabase();
    }

    private static void saveUserDatabase() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(userDatabase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, String> loadUserDatabase() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (Map<String, String>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new HashMap<>();
    }

    public static void main(String[] args) {
        new Signup();
    }
}
