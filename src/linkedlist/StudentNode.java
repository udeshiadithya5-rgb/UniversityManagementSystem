package linkedlist;

import model.Student;

public class StudentNode {
    Student data;
    StudentNode next;

    public StudentNode(Student data) {
        this.data = data;
        this.next = null;
    }
}