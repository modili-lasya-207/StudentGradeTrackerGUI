import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTrackerGUI extends JFrame implements ActionListener {

    // Components
    JLabel nameLabel, gradeLabel,countLabel;
    JTextField nameField, gradeField;
    JButton addButton, reportButton, clearButton;
    JTextArea outputArea;

    ArrayList<Student> students = new ArrayList<>();

    // Constructor
    StudentGradeTrackerGUI() {

        setTitle("Student Grade Tracker");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        nameLabel = new JLabel("Student Name:");
        gradeLabel = new JLabel("Student Grade:");
        countLabel = new JLabel("Students: 0");

        // Text fields
        nameField = new JTextField(20);
        gradeField = new JTextField(20);

        // Buttons
        addButton = new JButton("Add Student");
        reportButton = new JButton("Generate Report");
        clearButton = new JButton("Clear All");
        // Text Area
        outputArea = new JTextArea(18, 40);
        outputArea.setEditable(false);

        // Add action listeners
        addButton.addActionListener(this);
        reportButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        add(nameLabel);
        add(nameField);

        add(gradeLabel);
        add(gradeField);
        add(countLabel);
        add(addButton);
        add(reportButton);
        add(clearButton);

        add(new JScrollPane(outputArea));

        setVisible(true);
    }

    // Button Actions
    public void actionPerformed(ActionEvent e) {

        // Add Student Button
        if (e.getSource() == addButton) {

            try {
                 String name = nameField.getText().trim();

if(name.isEmpty()){
    JOptionPane.showMessageDialog(this,
            "Student name cannot be empty!");
    return;
}

double grade = Double.parseDouble(gradeField.getText());
if(grade < 0 || grade > 10){
    JOptionPane.showMessageDialog(this,
            "Grade must be between 0 and 10!");
    return;
}

                students.add(new Student(name, grade));

                outputArea.append("Added: " + name +
                        " | Grade: " + grade + "\n");

                // Update student count
                countLabel.setText("Students: " + students.size());

                // Clear fields
                nameField.setText("");
                gradeField.setText("");

            }  catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(this,
                "Please enter a valid numeric grade!");
}
        }

        // Generate Report Button
        if (e.getSource() == reportButton) {

            if (students.size() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No student data available!");
                return;
            }

            double total = 0;
            double highest = students.get(0).grade;
            double lowest = students.get(0).grade;

            String highestStudent = students.get(0).name;
            String lowestStudent = students.get(0).name;

            StringBuilder report = new StringBuilder();

            report.append("\n===== STUDENT REPORT =====\n");

            for (Student s : students) {

                report.append("Name: ")
                        .append(s.name)
                        .append(" | Grade: ")
                        .append(s.grade)
                        .append("\n");

                total += s.grade;

                if (s.grade > highest) {
                    highest = s.grade;
                    highestStudent = s.name;
                }

                if (s.grade < lowest) {
                    lowest = s.grade;
                    lowestStudent = s.name;
                }
            }

            double average = total / students.size();
            report.append("\nTotal Students: ")
                    .append(students.size());
            report.append("\nAverage Score: ")
                    .append(String.format("%.2f", average));

            report.append("\nHighest Score: ")
                    .append(highest)
                    .append(" (")
                    .append(highestStudent)
                    .append(")");

            report.append("\nLowest Score: ")
                    .append(lowest)
                    .append(" (")
                    .append(lowestStudent)
                    .append(")");
            report.append("\nGenerated On: ")
                    .append(LocalDateTime.now());        

            outputArea.setText(report.toString());
        }

        // Clear All Button
        if (e.getSource() == clearButton) {
            students.clear();
            outputArea.setText("");
            countLabel.setText("Students: 0");
            JOptionPane.showMessageDialog(this,
            "All records cleared!");
        }
    }

    // Main Method
    public static void main(String[] args) {
        new StudentGradeTrackerGUI();
    }
}