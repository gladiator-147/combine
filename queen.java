public class queen {
    static int N = 4;
    static int board[][] = new int[N][N];

    public static void main(String[] args) {
        solve(0);
    }

    static boolean solve(int row) {
        if (row == N) {
            print();
            return true;
        }
        for (int col = 0; col < N; col++) {
            if (safe(row, col)) {
                board[row][col] = 1;
                if (solve(row + 1)) return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    static boolean safe(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) return false;
            if (c - (r - i) >= 0 && board[i][c - (r - i)] == 1) return false;
            if (c + (r - i) < N && board[i][c + (r - i)] == 1) return false;
        }
        return true;
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            System.out.println();
}
}
}