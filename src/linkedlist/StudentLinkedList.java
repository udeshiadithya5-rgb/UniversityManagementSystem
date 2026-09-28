package linkedlist;

import model.Student;

public class StudentLinkedList {
    private StudentNode head;
    private int size;

    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean addStudent(Student student) {
        if (findStudent(student.getStudentId()) != null) {
            System.out.println("Error: Student ID already exists!");
            return false;
        }

        StudentNode newNode = new StudentNode(student);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Student added successfully!");
        return true;
    }

    public Student findStudent(String studentId) {
        StudentNode current = head;
        while (current != null) {
            if (current.data.getStudentId().equals(studentId)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public boolean updateStudent(String studentId, String newName, String newProgramme, double newMarks) {
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Error: Student not found!");
            return false;
        }
        student.setName(newName);
        student.setProgramme(newProgramme);
        student.setMarks(newMarks);
        System.out.println("Student updated successfully!");
        return true;
    }

    public Student deleteStudent(String studentId) {
        if (head == null) {
            System.out.println("Error: List is empty!");
            return null;
        }

        if (head.data.getStudentId().equals(studentId)) {
            Student deleted = head.data;
            head = head.next;
            size--;
            System.out.println("Student deleted successfully!");
            return deleted;
        }

        StudentNode current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equals(studentId)) {
                Student deleted = current.next.data;
                current.next = current.next.next;
                size--;
                System.out.println("Student deleted successfully!");
                return deleted;
            }
            current = current.next;
        }

        System.out.println("Error: Student not found!");
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n========== ALL STUDENT RECORDS ==========");
        StudentNode current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.data);
            current = current.next;
            count++;
        }
        System.out.println("Total: " + size + " students");
        System.out.println("=========================================\n");
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return head == null; }
}