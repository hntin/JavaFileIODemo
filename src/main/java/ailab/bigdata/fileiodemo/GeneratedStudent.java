package ailab.bigdata.fileiodemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeneratedStudent {

    private int id;
    private String name;
    private double gpa;

    // Default constructor
    public GeneratedStudent() {
    }

    // Parameterized constructor
    public GeneratedStudent(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Method to write list of students to "students.txt"
    public static void writeStudentsToFile(ArrayList<GeneratedStudent> students) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (GeneratedStudent student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGpa());
                writer.newLine();
            }
        }
    }

    // Method to read "students.txt" and create student objects
    public static ArrayList<GeneratedStudent> readStudentsFromFile() throws IOException {
        ArrayList<GeneratedStudent> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int studentId = Integer.parseInt(parts[0].trim());
                    String studentName = parts[1].trim();
                    double studentGpa = Double.parseDouble(parts[2].trim());
                    students.add(new GeneratedStudent(studentId, studentName, studentGpa));
                }
            }
        }
        return students;
    }
}
