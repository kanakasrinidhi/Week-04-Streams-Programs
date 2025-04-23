package Javastreams;
import java.io.*;

class Student {
    int rollNumber;
    String name;
    double gpa;

    Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "student_data.dat";

        Student student1 = new Student(101, "John Doe", 3.8);
        Student student2 = new Student(102, "Jane Smith", 3.9);

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(fileName))) {
            dataOut.writeInt(student1.rollNumber);
            dataOut.writeUTF(student1.name);
            dataOut.writeDouble(student1.gpa);

            dataOut.writeInt(student2.rollNumber);
            dataOut.writeUTF(student2.name);
            dataOut.writeDouble(student2.gpa);

            System.out.println("Student details stored successfully.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }

        try (DataInputStream dataIn = new DataInputStream(new FileInputStream(fileName))) {
            while (dataIn.available() > 0) {
                int rollNumber = dataIn.readInt();
                String name = dataIn.readUTF();
                double gpa = dataIn.readDouble();

                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}
