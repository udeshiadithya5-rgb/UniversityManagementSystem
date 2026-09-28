package graph;  

import java.util.*;

public class Graph {

    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.out.println("Invalid location name.");
            return;
        }
        location = location.trim();
        if (adjacencyList.containsKey(location)) {
            System.out.println("Location already exists.");
            return;
        }
        adjacencyList.put(location, new ArrayList<>());
        System.out.println(location + " added successfully.");
    }

    public void removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location does not exist.");
            return;
        }
        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }
        adjacencyList.remove(location);
        System.out.println(location + " removed successfully.");
    }

    public void addConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            System.out.println("One or both locations do not exist.");
            return;
        }
        if (location1.equals(location2)) {
            System.out.println("A location cannot connect to itself.");
            return;
        }
        if (adjacencyList.get(location1).contains(location2)) {
            System.out.println("Connection already exists.");
            return;
        }
        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);
        System.out.println("Connection added: " + location1 + " <-> " + location2);
    }

    public void removeConnection(String location1, String location2) {
        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            System.out.println("One or both locations do not exist.");
            return;
        }
        if (!adjacencyList.get(location1).contains(location2)) {
            System.out.println("Connection does not exist.");
            return;
        }
        adjacencyList.get(location1).remove(location2);
        adjacencyList.get(location2).remove(location1);
        System.out.println("Connection removed: " + location1 + " <-> " + location2);
    }

    public void displayGraph() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }
        System.out.println("\n--- Campus Network ---");
        for (String location : adjacencyList.keySet()) {
            System.out.print(location + " -> ");
            List<String> neighbours = adjacencyList.get(location);
            if (neighbours.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", neighbours));
            }
        }
    }

    public List<String> getNeighbours(String location) {
        if (!adjacencyList.containsKey(location)) {
            return Collections.emptyList();
        }
        return adjacencyList.get(location);
    }

    public boolean containsLocation(String location) {
        return adjacencyList.containsKey(location);
    }
}