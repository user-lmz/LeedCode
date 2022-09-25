package test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution675_new {
    @Test
    public void test() {
        Integer[][] a = {{2, 3, 4}, {0, 0, 5}, {8, 7, 6}};
        List<List<Integer>> arr =
                Arrays.stream(a)
                        .map(Arrays::asList)
                        .collect(Collectors.toList());
        System.out.println(cutOffTree(arr));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> tree = new ArrayList<>();
        int row = forest.size();
        int col = forest.get(0).size();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (forest.get(i).get(j) > 1) {
                    tree.add(new int[]{i, j});
                }
            }
        }
        tree.sort(Comparator.comparingInt(a -> forest.get(a[0]).get(a[1])));

        int cx = 0;
        int cy = 0;
        int ans = 0;
        for(int i = 0; i < tree.size(); i++) {
            int step = bfs(forest, cx, cy, tree.get(i)[0], tree.get(i)[1]);
            if(step == -1)
                return -1;
            ans += step;
            cx = tree.get(i)[0];
            cy = tree.get(i)[1];
        }
        return ans;
    }
    public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }

        int row = forest.size();
        int col = forest.get(0).size();
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[row][col];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for(int i = 0; i < sz; i++) {
                int[] cell = queue.poll();
                int cx = cell[0];
                int cy = cell[1];
                for(int j = 0; j < 4; j++) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if(nx >= 0 && nx < row && ny >= 0 && ny < col) {
                        if(!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if(nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
