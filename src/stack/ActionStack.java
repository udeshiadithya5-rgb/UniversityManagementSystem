package stack;  // ADDED: Package declaration

public class ActionStack {
    private static class ActionNode {
        String action;
        ActionNode next;

        ActionNode(String action) {
            this.action = action;
            this.next = null;
        }
    }

    private ActionNode top;
    private int size;

    public ActionStack() {
        top = null;
        size = 0;
    }

    public void pushAction(String action) {
        if (action == null || action.trim().isEmpty()) {
            System.out.println("Cannot add an empty action.");
            return;
        }
        ActionNode newNode = new ActionNode(action);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Action added: " + action);
    }

    public String popAction() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No action to remove.");
            return null;
        }
        String action = top.action;
        top = top.next;
        size--;
        return action;
    }

    public String peekAction() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return top.action;
    }

    public void displayActions() {
        if (isEmpty()) {
            System.out.println("\nNo recent actions.");
            return;
        }
        System.out.println("\n===== RECENT ACTIONS =====");
        ActionNode current = top;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.action);
            current = current.next;
            number++;
        }
        System.out.println("==========================");
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }
}