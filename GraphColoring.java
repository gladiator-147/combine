public class GraphColoring {

    static boolean isSafe(int v, int[][] graph, int[] color, int c, int V) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false;
        }
        return true;
    }

    static boolean graphColoringUtil(int[][] graph, int[] color, int V, int m, int v) {
        if (v == V)
            return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c, V)) {
                color[v] = c;
                if (graphColoringUtil(graph, color, V, m, v + 1))
                    return true;
                color[v] = 0;
            }
        }

        return false;
    }

    static boolean graphColoring(int[][] graph, int V, int m) {
        int[] color = new int[V];

        if (!graphColoringUtil(graph, color, V, m, 0)) {
            System.out.println("Solution does not exist!");
            return false;
        }

        System.out.print("Solution found: ");
        for (int i = 0; i < V; i++) {
            System.out.print(color[i] + " ");
        }
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        int m = 3;

        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        graphColoring(graph, V, m);
    }
}
