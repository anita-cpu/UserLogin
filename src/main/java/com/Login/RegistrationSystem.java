package com.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters for username, password, first name, last name
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

public class RegistrationSystem {
    private static Map<String, User> users = new HashMap<>();
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField usernameField;
    private static JPasswordField passwordField;
    private static JTextField firstNameField;
    private static JTextField lastNameField;

    public static void main(String[] args) {
        createAndShowGUI();
    }

   public static void createAndShowGUI() {
    frame = new JFrame("User Registration/Login");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel(new GridLayout(7, 2));

    panel.add(new JLabel("Username:"));
    usernameField = new JTextField();
    panel.add(usernameField);

    panel.add(new JLabel("Password:"));
    passwordField = new JPasswordField();
    panel.add(passwordField);

    panel.add(new JLabel("First Name:"));
    firstNameField = new JTextField();
    panel.add(firstNameField);
    firstNameField.setVisible(true);

    panel.add(new JLabel("Last Name:"));
    lastNameField = new JTextField();
    panel.add(lastNameField);
    lastNameField.setVisible(true);

    JButton actionButton = new JButton("Register");
    actionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (actionButton.getText().equals("Register")) {
                registerUser();
            } else {
                loginUser();
            }
        }
    });
    panel.add(actionButton);

    JButton toggleButton = new JButton("Switch to Login");
    toggleButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (toggleButton.getText().equals("Switch to Login")) {
                actionButton.setText("Login");
                toggleButton.setText("Switch to Registration");
                firstNameField.setVisible(false);
                lastNameField.setVisible(false);
            } else {
                actionButton.setText("Register");
                toggleButton.setText("Switch to Login");
                firstNameField.setVisible(true);
                lastNameField.setVisible(true);
            }
        }
    });
    panel.add(toggleButton);

    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
}

    public static void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        // Check username format
        if (!checkUserName(username)) {
            JOptionPane.showMessageDialog(frame, "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }

        // Check password complexity
        if (!checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(frame, "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        }

        // Create new user
        User newUser = new User(username, password, firstName, lastName);
        users.put(username, newUser);
        JOptionPane.showMessageDialog(frame, "Registration successful!\nUsername successfully captured.\nPassword successfully captured.");
    }

    public static void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Check if user exists and password matches
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(frame, "Welcome " + user.getFirstName() + ", " + user.getLastName() + ". It is great to see you again.");
            } else {
                JOptionPane.showMessageDialog(frame, "Password incorrect. Please try again.");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Username incorrect. Please try again.");
        }
    }

    public static boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public static boolean checkPasswordComplexity(String password) {
        // Regex pattern for password complexity
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
