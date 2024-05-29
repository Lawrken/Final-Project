import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Login extends JFrame implements ActionListener {

    private JLabel welcomeText;
    private JLabel logoText;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Map<String, String> userDatabase;
    private JButton customizeButton;
    private JButton customizeBackgroundButton;
    private JLabel labelUsername;
    private JLabel labelPassword;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        userDatabase = Signup.loadUserDatabase();

        setTitle("Login");
        setSize(400, 600);
        getContentPane().setBackground(Color.decode("#FFFFCC"));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setSize(400, 600);
        panel.setLocation(50, 50);
        panel.setBorder(BorderFactory.createEmptyBorder(32, 32, 32, 32));
        panel.setOpaque(false);

        welcomeText = new JLabel("Welcome to", SwingConstants.CENTER);
        welcomeText.setFont(new Font("Poppins", Font.PLAIN, 32));
        welcomeText.setForeground(new Color(99, 88, 220));
        welcomeText.setBounds(10, 10, 380, 40);
        panel.add(welcomeText);

        logoText = new JLabel("ToDoList", SwingConstants.CENTER);
        logoText.setFont(new Font("Raleway ExtraBold", Font.BOLD, 64));
        logoText.setForeground(new Color(99, 88, 220));
        logoText.setBounds(10, 60, 380, 80);
        panel.add(logoText);

        labelUsername = new JLabel("Username:");
        labelUsername.setBounds(10, 150, 76, 20);
        labelUsername.setFont(new Font("Poppins", Font.PLAIN, 15));
        panel.add(labelUsername);

        usernameField = new JTextField();
        usernameField.setBounds(10, 170, 370, 35);
        usernameField.setBackground(Color.WHITE);
        usernameField.setForeground(Color.GRAY);
        usernameField.setFont(new Font("Poppins", Font.PLAIN, 15));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.add(usernameField);

        labelPassword = new JLabel("Password:");
        labelPassword.setBounds(10, 215, 76, 20);
        labelPassword.setFont(new Font("Poppins", Font.PLAIN, 15));
        panel.add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 235, 370, 35);
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Poppins", Font.PLAIN, 15));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 285, 250, 50);
        loginButton.setBackground(new Color(99, 88, 220));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Poppins", Font.BOLD, 15));
        loginButton.setBorder(BorderFactory.createEmptyBorder());
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(this);
        panel.add(loginButton);

        customizeButton = new JButton("Customize Color");
        customizeButton.setBounds(70, 340, 250, 50);
        customizeButton.setForeground(Color.WHITE);
        customizeButton.setBackground(new Color(99, 88, 220));
        customizeButton.setBorder(null);
        customizeButton.setFocusPainted(false);
        customizeButton.setFocusable(false);
        customizeButton.setRequestFocusEnabled(false);
        customizeButton.setRolloverEnabled(false);
        customizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizeButtonActionPerformed(evt);
            }  
        });
        panel.add(customizeButton);

        customizeBackgroundButton = new JButton("Customize Background");
        customizeBackgroundButton.setBounds(70, 395, 250, 50);
        customizeBackgroundButton.setFont(new Font("Poppins", Font.BOLD, 14));
        customizeBackgroundButton.setForeground(Color.WHITE);
        customizeBackgroundButton.setBackground(new Color(99, 88, 220));
        customizeBackgroundButton.setBorder(null);
        customizeBackgroundButton.setFocusPainted(false);
        customizeBackgroundButton.setFocusable(false);
        customizeBackgroundButton.setRequestFocusEnabled(false);
        customizeBackgroundButton.setRolloverEnabled(false);
        customizeBackgroundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizeBackgroundButtonActionPerformed(evt);
            }
        });
        panel.add(customizeBackgroundButton);
        
        JLabel signupLabel = new JLabel("<HTML><U>Don't have an account?</U></HTML>", JLabel.CENTER);
        signupLabel.setForeground(Color.BLACK);
        signupLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        signupLabel.setBounds(40, 500, 300, 35);
        signupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new Signup();
                dispose();
            }
        });
        panel.add(signupLabel);
        
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (validateLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful");
                new TaskList().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateLogin(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return password.equals(userDatabase.get(username));
        } else {
            return false;
        }
    }
    private void customizeButtonActionPerformed(ActionEvent evt) {
        Color newColor = JColorChooser.showDialog(this, "Choose Background Color", getBackground());
        if (newColor != null) {
            welcomeText.setForeground(newColor); 
            logoText.setForeground(newColor); 
            usernameField.setForeground(newColor); 
            labelPassword.setForeground(newColor);
            labelUsername.setForeground(newColor);
            loginButton.setBackground(newColor); 
            customizeButton.setBackground(newColor); 
            customizeBackgroundButton.setBackground(newColor);
        }
    }

    private void customizeBackgroundButtonActionPerformed(ActionEvent evt) {
        Color newColor = JColorChooser.showDialog(this, "Choose Background Color", getBackground());
        if (newColor != null) {
            getContentPane().setBackground(newColor);
        }
    }


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
