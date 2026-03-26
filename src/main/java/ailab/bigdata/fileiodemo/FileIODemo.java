package ailab.bigdata.fileiodemo;

import java.io.IOException;
import java.util.ArrayList;

public class FileIODemo {

    public static void main(String[] args) {
        System.out.println("=========================");
        /*ReadTextFile rf = new ReadTextFile();
        ArrayList result = rf.readNumberFromLine("/home/tinhuynh/Documents/numbers.text");
        System.out.println("Sum:" + result.get(0));
        System.out.println("The number of lines is a number: " + result.get(1));
        System.out.println("The number of lines is NOT a number: " + result.get(2));*/

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "A ", 7.5));
        students.add(new Student(2, "B ", 7.6));
        students.add(new Student(3, "C ", 7.7));
        Student s = new Student();
        try {
            s.writeStudents("/home/tinhuynh/Documents/students.txt", students);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            students = s.readStudents("/home/tinhuynh/Documents/students.txt");
            System.out.println(students.get(0).getId() 
                    + students.get(0).getName() + 
                    students.get(0).getGpa());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=========================");
    }
}
