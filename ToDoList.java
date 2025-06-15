import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/* <applet code="ToDoList" width=500 height=400></applet> */
public class ToDoList extends Applet implements ActionListener {
    TextField taskInput;
    Button addButton, deleteButton, markCompleteButton;
    List taskList;
    ArrayList<String> tasks = new ArrayList<>();

    public void init() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240)); // Light gray background for the applet

        // Top Panel for input and buttons
        Panel topPanel = new Panel();
        topPanel.setBackground(new Color(200, 200, 255)); // Light blue background for the top panel

        taskInput = new TextField(30);
        addButton = new Button("Add Task");
        deleteButton = new Button("Delete Task");
        markCompleteButton = new Button("Mark Complete");

        // Set button colors
        addButton.setBackground(new Color(100, 200, 100)); // Green for adding tasks
        deleteButton.setBackground(new Color(200, 100, 100)); // Red for deleting tasks
        markCompleteButton.setBackground(new Color(100, 100, 200)); // Blue for marking tasks complete

        // Set button text color
        addButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);
        markCompleteButton.setForeground(Color.WHITE);

        // Add action listeners
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);
        markCompleteButton.addActionListener(this);

        // Add components to the top panel
        topPanel.add(taskInput);
        topPanel.add(addButton);
        topPanel.add(deleteButton);
        topPanel.add(markCompleteButton);
        add(topPanel, BorderLayout.NORTH);

        // Task List
        taskList = new List(10);
        taskList.setBackground(new Color(255, 255, 255)); // White background for the task list
        taskList.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font for task list
        add(taskList, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Add Task")) {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskList.add(task);
                taskInput.setText("");
            }
        } else if (command.equals("Delete Task")) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
                taskList.remove(selectedIndex);
            }
        } else if (command.equals("Mark Complete")) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                String completedTask = "[Done] " + tasks.get(selectedIndex);
                tasks.set(selectedIndex, completedTask);
                taskList.replaceItem(completedTask, selectedIndex);
                
            }
        }
    }
}
