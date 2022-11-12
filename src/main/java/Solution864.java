import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution864 {
    static int N = 35, K = 6, INF = 0x3f3f3f;

    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][][] dist = new int[N][N][1 << K];
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), cnt = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], INF);
                char c = grid[i].charAt(j);
                if (c == '@') {
                    deque.addLast(new int[]{i, j, 0});
                    dist[i][j][0] = 0;
                } else if (c >= 'a' && c <= 'z') {
                    ++cnt;
                }
            }
        }
        while (!deque.isEmpty()) {
            int[] info = deque.pollFirst();
            int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                char c = grid[nx].charAt(ny);
                if (c == '#') continue;
                if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                int ncur = cur;
                if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                if (ncur == (1 << cnt) - 1) return step + 1;
                if (dist[nx][ny][ncur] == 0 || step + 1 < dist[nx][ny][ncur]) {
                    dist[nx][ny][ncur] = step + 1;
                    deque.addLast(new int[]{nx, ny, ncur});
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(shortestPathAllKeys(new String[]{"@.a.#", "###.#", "b.A.B"}));
    }
}
