import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TaskList extends JFrame {

    private ArrayList<Task> tasks;
    private JButton customizeBackgroundButton;

    public TaskList() {
        tasks = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        showTasks = new JButton();
        jScrollPane1 = new JScrollPane();
        TaskListTable = new JTable();
        signout = new JButton();
        taskcomplete = new JButton();
        logoText = new JLabel();
        welcomeText1 = new JLabel();
        idInput = new JTextField();
        showTasks = new JButton();
        jScrollPane3 = new JScrollPane();
        descInput = new JTextArea();
        titleInput = new JTextField();
        addtask = new JButton();
        customizeButton = new JButton();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#FFFFCC"));
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(500, 850));

        welcomeText1.setFont(new Font("Poppins", 0, 30));
        welcomeText1.setForeground(new Color(99, 88, 220));
        welcomeText1.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText1.setText("Welcome, User!");
        add(welcomeText1);

        logoText.setFont(new Font("Raleway ExtraBold", 1, 64));
        logoText.setForeground(new Color(99, 88, 220)); // Colored component
        logoText.setText("ToDoList");
        add(logoText);

        titleInput.setFont(new Font("Poppins", 0, 14));
        titleInput.setForeground(new Color(128, 128, 128));
        titleInput.setBorder(BorderFactory.createTitledBorder(null, "Task Title", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new Font("Poppins", 0, 12), new Color(153, 153, 153)));
        titleInput.setCaretColor(new Color(99, 88, 220));
        titleInput.setDisabledTextColor(new Color(255, 255, 255));
        titleInput.setDoubleBuffered(true);
        titleInput.setDragEnabled(true);
        titleInput.setSelectedTextColor(new Color(0, 0, 0));
        titleInput.setPreferredSize(new Dimension(400, 40));
        titleInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                titleInputActionPerformed(evt);
            }
        });
        add(titleInput);

        descInput.setColumns(20);
        descInput.setFont(new Font("Poppins", 0, 12));
        descInput.setForeground(new Color(128, 128, 128));
        descInput.setRows(5);
        descInput.setBorder(BorderFactory.createTitledBorder(null, "Task Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new Font("Poppins", 0, 12), new Color(128, 128, 128)));
        jScrollPane3.setViewportView(descInput);

        add(jScrollPane3);

        addtask.setBackground(new Color(99, 88, 220)); // Colored component
        addtask.setFont(new Font("Poppins", 0, 12));
        addtask.setForeground(new Color(255, 255, 255));
        addtask.setText("Add Task");
        addtask.setBorderPainted(false);
        addtask.setPreferredSize(new Dimension(300, 20));
        addtask.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addtaskActionPerformed(evt);
            }
        });
        add(addtask);

        TaskListTable.setFont(new Font("Poppins", 0, 10));
        TaskListTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Task ID", "Task Title", "Task Description"
                }
        ));
        jScrollPane1.setPreferredSize(new Dimension(450, 270));
        jScrollPane1.setViewportView(TaskListTable);

        add(jScrollPane1);

        signout.setBackground(new Color(99, 88, 220)); // Colored component
        signout.setFont(new Font("Poppins", 0, 12));
        signout.setForeground(new Color(255, 255, 255));
        signout.setText("Sign Out");
        signout.setBorderPainted(false);
        signout.setPreferredSize(new Dimension(150, 30));
        signout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });
        add(signout);

        showTasks.setBackground(new Color(99, 88, 220)); // Colored component
        showTasks.setFont(new Font("Poppins", 0, 12));
        showTasks.setForeground(new Color(255, 255, 255));
        showTasks.setText("Refresh");
        showTasks.setBorderPainted(false);
        showTasks.setPreferredSize(new Dimension(150, 30));
        showTasks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showTasks2ActionPerformed(evt);
            }
        });
        add(showTasks);

        taskcomplete.setBackground(new Color(99, 88, 220)); // Colored component
        taskcomplete.setFont(new Font("Poppins", 0, 12));
        taskcomplete.setForeground(new Color(255, 255, 255));
        taskcomplete.setText("Mark Task As Completed");
        taskcomplete.setBorderPainted(false);
        taskcomplete.setPreferredSize(new Dimension(200, 30));
        taskcomplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                taskcompleteActionPerformed(evt);
            }
        });
        add(taskcomplete);

        idInput.setFont(new Font("Poppins", 0, 14));
        idInput.setForeground(new Color(128, 128, 128));
        idInput.setBorder(BorderFactory.createTitledBorder(null, "Enter TaskID", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new Font("Poppins", 0, 12), new Color(153, 153, 153)));
        idInput.setCaretColor(new Color(99, 88, 220));
        idInput.setDisabledTextColor(new Color(255, 255, 255));
        idInput.setDoubleBuffered(true);
        idInput.setDragEnabled(true);
        idInput.setSelectedTextColor(new Color(0, 0, 0));
        idInput.setPreferredSize(new Dimension(300, 40));
        idInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });
        add(idInput);

        customizeButton.setBackground(new Color(128, 128, 128)); // Colored component
        customizeButton.setFont(new Font("Poppins", 0, 12));

        customizeButton.setText("Customize Color");
        customizeButton.setBorderPainted(false);
        customizeButton.setPreferredSize(new Dimension(300, 30));
        customizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizeButtonActionPerformed(evt);
            }
        });
        add(customizeButton);
        
        customizeBackgroundButton = new JButton("Customize Background");
        customizeBackgroundButton.setFont(new Font("Poppins", Font.BOLD, 12));
        customizeBackgroundButton.setBackground(new Color(99, 88, 220)); 
        customizeButton.setForeground(new Color(255, 255, 255));
        customizeButton.setBorderPainted(false);
        customizeButton.setPreferredSize(new Dimension(300, 30));
        customizeBackgroundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                customizeBackgroundButtonActionPerformed(evt);
            }
        });
        add(customizeBackgroundButton);

        pack();
    }

    private void showTasksActionPerformed(ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) TaskListTable.getModel();
        model.setRowCount(0);
        for (Task task : tasks) {
            model.addRow(new Object[]{task.getId(), task.getTitle(), task.getDescription()});
        }
    }

    private void signoutActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    private void taskcompleteActionPerformed(ActionEvent evt) {
        int taskId;
        try {
            taskId = Integer.parseInt(idInput.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Task ID!");
            return;
        }

        boolean taskRemoved = tasks.removeIf(task -> task.getId() == taskId);

        if (taskRemoved) {
            JOptionPane.showMessageDialog(this, "Task marked as completed!");
        } else {
            JOptionPane.showMessageDialog(this, "Task not found!");
        }

        idInput.setText("");
        showTasksActionPerformed(evt);
    }

    private void showTasks2ActionPerformed(ActionEvent evt) {
        showTasksActionPerformed(evt);
    }

    private void idInputActionPerformed(ActionEvent evt) {
    }

    private void titleInputActionPerformed(ActionEvent evt) {
    }

    private void addtaskActionPerformed(ActionEvent evt) {
        String title = titleInput.getText();
        String description = descInput.getText();

        if (title.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both title and description.");
            return;
        }

        int newId = tasks.size() + 1;
        Task newTask = new Task(newId, title, description);
        tasks.add(newTask); 

        titleInput.setText("");
        descInput.setText("");
        showTasksActionPerformed(evt);
    }

    private void customizeButtonActionPerformed(ActionEvent evt) {
        Color newColor = JColorChooser.showDialog(this, "Choose Background Color", getBackground());
        if (newColor != null) {
            welcomeText1.setForeground(newColor);
            logoText.setForeground(newColor);
            addtask.setBackground(newColor);
            signout.setBackground(newColor);
            showTasks.setBackground(newColor);
            taskcomplete.setBackground(newColor);
            customizeButton.setBackground(newColor);
        }
    }
    private void customizeBackgroundButtonActionPerformed(ActionEvent evt) {
        Color newColor = JColorChooser.showDialog(this, "Choose Background Color", getBackground());
        if (newColor != null) {
            getContentPane().setBackground(newColor);
        }
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaskList().setVisible(true);
            }
        });
    }

    private JTable TaskListTable;
    private JButton addtask;
    private JTextArea descInput;
    private JTextField idInput;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JLabel logoText;
    private JButton showTasks;
    private JButton signout;
    private JButton taskcomplete;
    private JTextField titleInput;
    private JLabel welcomeText1;
    private JButton customizeButton;

    private class Task {
        private int id;
        private String title;
        private String description;

        public Task(int id, String title, String description) {
            this.id = id;
            this.title = title;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}