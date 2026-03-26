package ailab.bigdata.fileiodemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private double gpa;

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

    public Student(){
        
    }
    
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public ArrayList readStudents(String fileName) throws IOException {
        ArrayList students = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;       
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            float gpa = Float.parseFloat(parts[2]);
            students.add(new Student(id, name, gpa));
        }
        reader.close();
        return students;
    }

    public void writeStudents(String fileName, ArrayList<Student> students) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (Student s : students) {
            writer.write(s.id + "," + s.name + "," + s.gpa);
            writer.newLine();
        }
        writer.close();
    }

}
