import model.Student;
import linkedlist.StudentLinkedList;
import stack.ActionStack;
import queue.ServiceQueue;
import tree.StudentBST;
import hash.StudentHashTable;
import graph.Graph;
import graph.GraphTraversal;

import java.util.Scanner;

/**
 * ============================================================
 * CIT300 - Graded Practical Assignment 1
 * University Student Record and Campus Route Management System
 * ============================================================
 * 
 * Group Members:
 *   23DA2-0366 - K.A.D.U. Adithya     (Linked List)
 *   23DA2-0155 - W.A.H. Maduranga     (Stack & Queue)
 *   23DA2-0216 - W.I. Sandakelum      (BST & Hashing)
 *   23DA2-0255 - Manodya Ravikubura   (Graph & BFS/DFS)
 * ============================================================
 */
public class Main {

    // ==================== GLOBAL DATA STRUCTURES ====================
    private static StudentLinkedList studentList = new StudentLinkedList();
    private static ActionStack actionStack = new ActionStack();
    private static ServiceQueue serviceQueue = new ServiceQueue();
    private static StudentBST studentBST = new StudentBST();
    private static StudentHashTable studentHash = new StudentHashTable();
    private static Graph campusGraph = new Graph();
    private static Scanner scanner = new Scanner(System.in);

    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║   UNIVERSITY STUDENT RECORD & CAMPUS ROUTE MANAGEMENT    ║");
        System.out.println("║              CIT300 - Graded Practical Assignment 1       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        loadSampleData();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice (1-16): ");

            switch (choice) {
                case 1: addStudentRecord(); break;
                case 2: updateStudentRecord(); break;
                case 3: deleteStudentRecord(); break;
                case 4: displayAllRecords(); break;
                case 5: addServiceRequest(); break;
                case 6: processNextRequest(); break;
                case 7: displayRecentActions(); break;
                case 8: displayStudentsBST(); break;
                case 9: searchStudentHashing(); break;
                case 10: addCampusLocation(); break;
                case 11: removeCampusLocation(); break;
                case 12: addCampusConnection(); break;
                case 13: removeCampusConnection(); break;
                case 14: displayCampusConnections(); break;
                case 15: traverseCampus(); break;
                case 16:
                    running = false;
                    System.out.println("\n Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid choice! Please enter 1-16.");
            }
        }
        scanner.close();
    }

    // ==================== MENU DISPLAY ====================
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records using Linked List");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Recent Actions using Stack");
        System.out.println("8.  Display Students using BST");
        System.out.println("9.  Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations (BFS/DFS)");
        System.out.println("16. Exit");
        System.out.println("================================");
    }

    // ==================== 1. ADD STUDENT ====================
    private static void addStudentRecord() {
        System.out.println("\n--- ADD STUDENT RECORD ---");
        String id = getStringInput("Enter Student ID: ");
        String name = getStringInput("Enter Name: ");
        String programme = getStringInput("Enter Programme: ");
        double marks = getDoubleInput("Enter Marks (0-100): ");

        if (marks < 0 || marks > 100) {
            System.out.println(" Error: Marks must be between 0 and 100!");
            return;
        }

        Student student = new Student(id, name, programme, marks);

        if (studentList.addStudent(student)) {
            studentBST.insert(student);
            studentHash.insert(student);
            actionStack.pushAction("Added student: " + id + " - " + name);
        }
    }

    // ==================== 2. UPDATE STUDENT ====================
    private static void updateStudentRecord() {
        System.out.println("\n--- UPDATE STUDENT RECORD ---");
        String id = getStringInput("Enter Student ID to update: ");

        if (studentList.findStudent(id) == null) {
            System.out.println(" Error: Student not found!");
            return;
        }

        String name = getStringInput("Enter New Name: ");
        String programme = getStringInput("Enter New Programme: ");
        double marks = getDoubleInput("Enter New Marks (0-100): ");

        if (marks < 0 || marks > 100) {
            System.out.println(" Error: Marks must be between 0 and 100!");
            return;
        }

        if (studentList.updateStudent(id, name, programme, marks)) {
            refreshTreeAndHash();
            actionStack.pushAction("Updated student: " + id);
        }
    }

    // ==================== 3. DELETE STUDENT ====================
    private static void deleteStudentRecord() {
        System.out.println("\n--- DELETE STUDENT RECORD ---");
        String id = getStringInput("Enter Student ID to delete: ");

        Student deleted = studentList.deleteStudent(id);
        if (deleted != null) {
            studentHash.delete(id);
            refreshTreeAndHash();
            actionStack.pushAction("Deleted student: " + id + " - " + deleted.getName());
        }
    }

    // ==================== 4. DISPLAY ALL (LINKED LIST) ====================
    private static void displayAllRecords() {
        studentList.displayAll();
    }

    // ==================== 5. ADD SERVICE REQUEST ====================
    private static void addServiceRequest() {
        System.out.println("\n--- ADD SERVICE REQUEST ---");
        String studentId = getStringInput("Enter Student ID: ");
        System.out.println("Request Types: 1. Transcript  2. ID Card  3. Hostel  4. Library  5. Other");
        String type = getStringInput("Enter Request Type: ");
        String description = getStringInput("Enter Description: ");

        String requestText = "Student: " + studentId + " | Type: " + type + " | Details: " + description;
        serviceQueue.addRequest(requestText);
        actionStack.pushAction("Added service request for: " + studentId);
    }

    // ==================== 6. PROCESS NEXT REQUEST ====================
    private static void processNextRequest() {
        System.out.println("\n--- PROCESS NEXT SERVICE REQUEST ---");
        String processed = serviceQueue.processNextRequest();

        if (processed != null) {
            System.out.println(" Processing: " + processed);
            actionStack.pushAction("Processed service request: " + processed);
        }
        serviceQueue.displayQueue();
    }

    // ==================== 7. DISPLAY RECENT ACTIONS ====================
    private static void displayRecentActions() {
        actionStack.displayActions();
    }

    // ==================== 8. DISPLAY STUDENTS (BST) ====================
    private static void displayStudentsBST() {
        System.out.println("\n--- DISPLAY STUDENTS USING BST ---");
        studentBST.displayInOrder();
    }

    // ==================== 9. SEARCH STUDENT (HASHING) ====================
    private static void searchStudentHashing() {
        System.out.println("\n--- SEARCH STUDENT USING HASHING ---");
        String id = getStringInput("Enter Student ID to search: ");

        long startTime = System.nanoTime();
        Student found = studentHash.search(id);
        long endTime = System.nanoTime();

        if (found != null) {
            System.out.println("Student Found:");
            System.out.println("   " + found);
            System.out.println("  Search time: " + (endTime - startTime) + " ns");
        } else {
            System.out.println(" Student not found!");
        }
        studentHash.displayStats();
    }

    // ==================== 10. ADD CAMPUS LOCATION ====================
    private static void addCampusLocation() {
        System.out.println("\n--- ADD CAMPUS LOCATION ---");
        String location = getStringInput("Enter Location Name: ");
        // YOUR Graph.java method takes ONE parameter
        campusGraph.addLocation(location);
        actionStack.pushAction("Added campus location: " + location);
    }

    // ==================== 11. REMOVE CAMPUS LOCATION ====================
    private static void removeCampusLocation() {
        System.out.println("\n--- REMOVE CAMPUS LOCATION ---");
        String location = getStringInput("Enter Location Name to remove: ");

        // YOUR method returns void, so we check first
        if (campusGraph.containsLocation(location)) {
            campusGraph.removeLocation(location);
            actionStack.pushAction("Removed campus location: " + location);
        } else {
            System.out.println(" Location not found!");
        }
    }

    // ==================== 12. ADD CAMPUS CONNECTION ====================
    private static void addCampusConnection() {
        System.out.println("\n--- ADD CAMPUS CONNECTION ---");
        String loc1 = getStringInput("Enter First Location: ");
        String loc2 = getStringInput("Enter Second Location: ");
        // YOUR method returns void
        campusGraph.addConnection(loc1, loc2);
        actionStack.pushAction("Added connection: " + loc1 + " <--> " + loc2);
    }

    // ==================== 13. REMOVE CAMPUS CONNECTION ====================
    private static void removeCampusConnection() {
        System.out.println("\n--- REMOVE CAMPUS CONNECTION ---");
        String loc1 = getStringInput("Enter First Location: ");
        String loc2 = getStringInput("Enter Second Location: ");
        // YOUR method returns void
        campusGraph.removeConnection(loc1, loc2);
        actionStack.pushAction("Removed connection: " + loc1 + " <--> " + loc2);
    }

    // ==================== 14. DISPLAY CAMPUS CONNECTIONS ====================
    private static void displayCampusConnections() {
        // YOUR method is called displayGraph()
        campusGraph.displayGraph();
    }

    // ==================== 15. TRAVERSE CAMPUS (BFS/DFS) ====================
    private static void traverseCampus() {
        System.out.println("\n--- TRAVERSE CAMPUS LOCATIONS ---");
        String start = getStringInput("Enter starting location: ");

        System.out.println("Select traversal method:");
        System.out.println("1. BFS (Breadth-First Search)");
        System.out.println("2. DFS (Depth-First Search)");
        System.out.println("3. Find Shortest Path");
        int choice = getIntInput("Enter choice (1-3): ");

        switch (choice) {
            case 1:
                GraphTraversal.bfs(campusGraph, start);
                actionStack.pushAction("Performed BFS from: " + start);
                break;
            case 2:
                GraphTraversal.dfs(campusGraph, start);
                actionStack.pushAction("Performed DFS from: " + start);
                break;
            case 3:
                String end = getStringInput("Enter destination location: ");
                GraphTraversal.findShortestPath(campusGraph, start, end);
                actionStack.pushAction("Found path: " + start + " -> " + end);
                break;
            default:
                System.out.println(" Invalid choice!");
        }
    }

    // ==================== HELPER: REFRESH TREE AND HASH ====================
    private static void refreshTreeAndHash() {
        studentBST = new StudentBST();
        studentHash = new StudentHashTable();
        System.out.println("Tree and Hash table refreshed.");
    }

    // ==================== LOAD SAMPLE DATA ====================
    private static void loadSampleData() {
        System.out.println("\n Loading sample data...");

        Student s1 = new Student("23DA2-0366", "K.A.D.U. Adithya", "Applied IT", 85.5);
        Student s2 = new Student("23DA2-0155", "W.A.H. Maduranga", "Applied IT", 78.0);
        Student s3 = new Student("23DA2-0216", "W.I. Sandakelum", "Applied IT", 92.0);
        Student s4 = new Student("23DA2-0255", "Manodya Ravikubura", "Applied IT", 88.5);

        studentList.addStudent(s1);
        studentList.addStudent(s2);
        studentList.addStudent(s3);
        studentList.addStudent(s4);

        studentBST.insert(s1);
        studentBST.insert(s2);
        studentBST.insert(s3);
        studentBST.insert(s4);

        studentHash.insert(s1);
        studentHash.insert(s2);
        studentHash.insert(s3);
        studentHash.insert(s4);

        // YOUR Graph.addLocation() takes ONE parameter
        campusGraph.addLocation("Main Gate");
        campusGraph.addLocation("Library");
        campusGraph.addLocation("Admin Building");
        campusGraph.addLocation("Canteen");
        campusGraph.addLocation("Lecture Hall A");
        campusGraph.addLocation("Hostel");

        campusGraph.addConnection("Main Gate", "Admin Building");
        campusGraph.addConnection("Main Gate", "Library");
        campusGraph.addConnection("Admin Building", "Canteen");
        campusGraph.addConnection("Library", "Lecture Hall A");
        campusGraph.addConnection("Canteen", "Hostel");
        campusGraph.addConnection("Lecture Hall A", "Hostel");

        System.out.println(" Sample data loaded successfully!\n");
    }

    // ==================== INPUT VALIDATION HELPERS ====================
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a decimal number.");
            }
        }
    }
}