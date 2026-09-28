package tree;

import model.Student;

public class StudentBST {
    private TreeNode root;

    public StudentBST() {
        this.root = null;
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            root = new TreeNode(student);
            return root;
        }

        int comparison = student.getStudentId().compareTo(root.data.getStudentId());
        if (comparison < 0) {
            root.left = insertRec(root.left, student);
        } else if (comparison > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public Student search(String studentId) {
        return searchRec(root, studentId);
    }

    private Student searchRec(TreeNode root, String studentId) {
        if (root == null) {
            return null;
        }

        int comparison = studentId.compareTo(root.data.getStudentId());
        if (comparison == 0) {
            return root.data;
        } else if (comparison < 0) {
            return searchRec(root.left, studentId);
        } else {
            return searchRec(root.right, studentId);
        }
    }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        System.out.println("\n========== STUDENTS (BST - In-order) ==========");
        inOrderRec(root);
        System.out.println("================================================\n");
    }

    private void inOrderRec(TreeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }

    public void displayPreOrder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        System.out.println("\n========== STUDENTS (BST - Pre-order) ==========");
        preOrderRec(root);
        System.out.println("=================================================\n");
    }

    private void preOrderRec(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public boolean isEmpty() { return root == null; }
}