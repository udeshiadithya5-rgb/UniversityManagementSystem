package hash;

import model.Student;
import java.util.LinkedList;

public class StudentHashTable {
    private static final int TABLE_SIZE = 101;
    private LinkedList<Student>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public StudentHashTable() {
        this.table = new LinkedList[TABLE_SIZE];
        this.size = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String studentId) {
        int hash = 0;
        for (int i = 0; i < studentId.length(); i++) {
            hash = (hash * 31 + studentId.charAt(i)) % TABLE_SIZE;
        }
        return Math.abs(hash);
    }

    public void insert(Student student) {
        int index = hashFunction(student.getStudentId());
        for (Student s : table[index]) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Duplicate ID in hash table!");
                return;
            }
        }
        table[index].add(student);
        size++;
    }

    public Student search(String studentId) {
        int index = hashFunction(studentId);
        for (Student s : table[index]) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    public boolean delete(String studentId) {
        int index = hashFunction(studentId);
        for (int i = 0; i < table[index].size(); i++) {
            if (table[index].get(i).getStudentId().equals(studentId)) {
                table[index].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public void displayStats() {
        int collisions = 0;
        int maxChain = 0;
        for (LinkedList<Student> bucket : table) {
            if (bucket.size() > 1) {
                collisions += bucket.size() - 1;
            }
            maxChain = Math.max(maxChain, bucket.size());
        }
        System.out.println("\n========== HASH TABLE STATISTICS ==========");
        System.out.println("Table Size: " + TABLE_SIZE);
        System.out.println("Total Students: " + size);
        System.out.println("Load Factor: " + String.format("%.4f", (double) size / TABLE_SIZE));
        System.out.println("Total Collisions: " + collisions);
        System.out.println("Longest Chain: " + maxChain);
        System.out.println("============================================\n");
    }

    public int getSize() { return size; }
}