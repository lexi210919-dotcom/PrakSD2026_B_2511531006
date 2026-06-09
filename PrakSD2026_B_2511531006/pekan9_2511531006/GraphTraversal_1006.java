package pekan9_2511531006;

import java.util.*;
public class GraphTraversal_1006 {

    private Map<String, List<String>> graph_1006 = new HashMap<>();

    // Menambahkan edge (graf tak berarah)
    public void addEdge(String node1_1006, String node2_1006) {
        graph_1006.putIfAbsent(node1_1006, new ArrayList<>());
        graph_1006.putIfAbsent(node2_1006, new ArrayList<>());
        graph_1006.get(node1_1006).add(node2_1006);
        graph_1006.get(node2_1006).add(node1_1006);
    }
    // Menampilkan graf awal
    public void printGraph() {
        System.out.println("Graf Awal (Adjacency List):");
        for (String node_1006 : graph_1006.keySet()) {
            System.out.print(node_1006 + " -> ");
            List<String> neighbors_1006 =graph_1006.get(node_1006);
            System.out.println(String.join(", ", neighbors_1006));
        }
        System.out.println();
    }

    // DFS rekursif
    public void dfs(String start_1006) {
        Set<String> visited_1006 = new HashSet<>();
        System.out.println("Penelusuran DFS:");
        dfsHelper(start_1006, visited_1006);
        System.out.println();
    }
    private void dfsHelper(String current_1006,Set<String> visited_1006) {
        if (visited_1006.contains(current_1006)) return;
        visited_1006.add(current_1006);
        System.out.print(current_1006 + " ");
        for (String neighbor_1006 : graph_1006.getOrDefault( current_1006,new ArrayList<>())) {
            dfsHelper(neighbor_1006, visited_1006);
        }
    }

    // BFS iteratif
    public void bfs(String start_1006) {
        Set<String> visited_1006 = new HashSet<>();
        Queue<String> queue_1006 = new LinkedList<>();
        queue_1006.add(start_1006);
        visited_1006.add(start_1006);
        System.out.println("Penelusuran BFS:");
        while (!queue_1006.isEmpty()) {
            String current_1006 = queue_1006.poll();
            System.out.print(current_1006 + " ");
            for (String neighbor_1006 :  graph_1006.getOrDefault(current_1006,new ArrayList<>())) {
                if (!visited_1006.contains(neighbor_1006)) {
                    queue_1006.add(neighbor_1006);
                    visited_1006.add( neighbor_1006);
                }
            }
        }
        System.out.println();
    }
    // Main
    public static void main(String[] args) {
        GraphTraversal_1006 graph_1006 =new GraphTraversal_1006();

        // Contoh graf : A-B, A-C, B-D, B-E
        graph_1006.addEdge("A", "B");
        graph_1006.addEdge("A", "C");
        graph_1006.addEdge("B", "D");
        graph_1006.addEdge("B", "E");

        // Cetak graf awal
        System.out.println("Graf Awal adalah: ");
        graph_1006.printGraph();

        // Lakukan penelusuran
        graph_1006.dfs("A");
        graph_1006.bfs("A");
    }
}