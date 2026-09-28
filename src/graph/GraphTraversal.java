package graph; 

import java.util.*;

public class GraphTraversal {

    public static void bfs(Graph graph, String startLocation) {
        if (!graph.containsLocation(startLocation)) {
            System.out.println("Start location does not exist.");
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(startLocation);
        queue.add(startLocation);

        System.out.println("\nBFS Traversal:");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbour : graph.getNeighbours(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(Graph graph, String startLocation) {
        if (!graph.containsLocation(startLocation)) {
            System.out.println("Start location does not exist.");
            return;
        }
        Set<String> visited = new HashSet<>();
        System.out.println("\nDFS Traversal:");
        dfsRecursive(graph, startLocation, visited);
        System.out.println();
    }

    private static void dfsRecursive(Graph graph, String currentLocation, Set<String> visited) {
        visited.add(currentLocation);
        System.out.print(currentLocation + " ");
        for (String neighbour : graph.getNeighbours(currentLocation)) {
            if (!visited.contains(neighbour)) {
                dfsRecursive(graph, neighbour, visited);
            }
        }
    }

    public static void findShortestPath(Graph graph, String startLocation, String destination) {
        if (!graph.containsLocation(startLocation)
                || !graph.containsLocation(destination)) {
            System.out.println("Start or destination location does not exist.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> previous = new HashMap<>();

        queue.add(startLocation);
        visited.add(startLocation);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destination)) {
                break;
            }
            for (String neighbour : graph.getNeighbours(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    previous.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        if (!visited.contains(destination)) {
            System.out.println("No path found.");
            return;
        }

        List<String> path = new ArrayList<>();
        String current = destination;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);
        System.out.println("\nShortest Path:");
        System.out.println(String.join(" -> ", path));
    }
}