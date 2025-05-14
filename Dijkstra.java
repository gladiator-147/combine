class Dijkstra {

    static final int V = 6;
    static final int INF = 99999;

    static String[] landmarks = {
        "College", "Library", "Hostel", "Canteen", "Station", "Mall"
    };

    static void display(int[] dist) {
        System.out.println("\nLandmark\tDistance from College");
        for (int i = 0; i < V; i++) {
            System.out.println(landmarks[i] + "\t\t" + dist[i]);
        }
    }

    static void Dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int min = INF, u = -1;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && dist[v] <= min) {
                    min = dist[v];
                    u = v;
                }
            }

            if (u == -1) break;

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && 
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        display(dist);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0,  2,  4,  0,  0,  0},
            {2,  0,  1,  7,  0,  0},
            {4,  1,  0,  3,  5,  0},
            {0,  7,  3,  0,  2,  6},
            {0,  0,  5,  2,  0,  1},
            {0,  0,  0,  6,  1,  0}
        };

        System.out.println("Using Dijkstra's Algorithm to find shortest path from College:");
        Dijkstra(graph, 0);
    }
}
