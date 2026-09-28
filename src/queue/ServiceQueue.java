package queue;  // ADDED: Package declaration

public class ServiceQueue {

    private static class RequestNode {
        String request;
        RequestNode next;

        RequestNode(String request) {
            this.request = request;
            this.next = null;
        }
    }

    private RequestNode front;
    private RequestNode rear;
    private int size;

    public ServiceQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void addRequest(String request) {
        if (request == null || request.trim().isEmpty()) {
            System.out.println("Cannot add an empty service request.");
            return;
        }
        RequestNode newNode = new RequestNode(request);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Request added: " + request);
    }

    public String processNextRequest() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No service request to process.");
            return null;
        }
        String request = front.request;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return request;
    }

    public String peekRequest() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return front.request;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("\nNo pending service requests.");
            return;
        }
        System.out.println("\n===== SERVICE REQUEST QUEUE =====");
        RequestNode current = front;
        int number = 1;
        while (current != null) {
            System.out.println(number + ". " + current.request);
            current = current.next;
            number++;
        }
        System.out.println("=================================");
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}