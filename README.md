# Student Grade Tracker (Java Swing GUI)

## Overview

Student Grade Tracker is a Java Swing-based desktop application that allows users to manage student grades efficiently. The application enables users to add student records, calculate performance statistics, and generate a detailed summary report.

## Features

* Add student names and grades.
* Store student records using ArrayList.
* Generate a comprehensive student report.
* Calculate:

  * Average Score
  * Highest Score
  * Lowest Score
* Display total number of students.
* Input validation for:

  * Empty student names
  * Invalid grade entries
  * Grade range (0–10)
* Clear all student records.
* GUI-based interface built with Java Swing.
* Automatic report generation timestamp.

## Technologies Used

* Java
* Java Swing
* ArrayList
* Event Handling (ActionListener)

## Project Structure

StudentGradeTrackerGUI.java

* Student Class

  * Stores student name and grade.

* StudentGradeTrackerGUI Class

  * Handles GUI components.
  * Manages student data.
  * Generates reports and statistics.

## Sample Report

===== STUDENT REPORT =====

Name: Lasya | Grade: 9.5

Name: Sarva | Grade: 9.3

Name: Ravi | Grade: 9.1

Total Students: 3

Average Score: 9.30

Highest Score: 9.5 (Lasya)

Lowest Score: 9.1 (Ravi)

Generated On: 2026-06-08T12:15:00

## How to Run

### Compile

javac StudentGradeTrackerGUI.java

### Run

java StudentGradeTrackerGUI

## Learning Outcomes

This project demonstrates:

* Java Object-Oriented Programming (OOP)
* GUI Development using Swing
* Event-Driven Programming
* Data Management using ArrayList
* Input Validation and Error Handling
* Report Generation and Statistical Analysis

## Future Enhancements

* Store student data in files or databases.
* Export reports to PDF.
* Use JTable for displaying records.
* Add search and update functionality.
* Improve GUI layout using BorderLayout/GridBagLayout.

## Author

Modili Lasya Anjana

B.Tech Computer Science and Engineering

Vignan's Lara Institute of Technology and Science
