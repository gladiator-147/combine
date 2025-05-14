class BellmanFord {

    static final int V = 5;
    static final int INF = 99999;

    static String[] nodes = {"A", "B", "C", "D", "E"};

    static void display(int[] dist) {
        System.out.println("Node\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(nodes[i] + "\t\t" + dist[i]);
        }
    }

    static void bellmanFord(int[][] edges, int E, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) dist[i] = INF;
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int j = 0; j < E; j++) {
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if (dist[u] != INF && dist[u] + w < dist[v]) {
                System.out.println("\nNegative weight cycle detected!");
                return;
            }
        }

        System.out.println("\nBellman-Ford Results:");
        display(dist);
    }

    static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) dist[i] = INF;
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
                if (!visited[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nDijkstra’s Algorithm Results (May be incorrect due to negative weights):");
        display(dist);
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 6},
            {0, 2, 7},
            {1, 2, 8},
            {1, 3, 5},
            {1, 4, -4},
            {2, 3, -3},
            {2, 4, 9},
            {3, 1, -2},
            {4, 3, 7},
            {4, 0, 2}
        };
        int E = edges.length;

        int[][] adj = new int[V][V];
        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = edge[2];
        }

        System.out.println("Shortest paths from Node A using Bellman-Ford:");
        bellmanFord(edges, E, 0);

        System.out.println("\nShortest paths from Node A using Dijkstra's Algorithm:");
        dijkstra(adj, 0);
    }
}
