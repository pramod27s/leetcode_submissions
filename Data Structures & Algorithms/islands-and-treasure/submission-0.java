class Solution {
    Set<List<Integer>> visited = new HashSet<>();
    Queue<List<Integer>> q = new LinkedList<>();
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(List.of(i, j));
                    visited.add(List.of(i, j));
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                List<Integer> node =q.poll();
                int r = node.get(0);
                int c = node.get(1);
                grid[r][c] = dist;
                addRoom(grid, r - 1, c);
                addRoom(grid, r + 1, c);
                addRoom(grid, r, c - 1);
                addRoom(grid, r, c + 1);
            }

            dist++;
        }
    }

    private void addRoom(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length
            || visited.contains(List.of(r, c)) || grid[r][c] == -1) {
            return;
        }

        visited.add(List.of(r, c));
        q.offer(List.of(r, c));
    }
}
