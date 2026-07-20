class Solution {
    int perimeter = 0;
    Set<List<Integer>> visited;

    public int islandPerimeter(int[][] grid) {
    visited = new HashSet<>();

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 1) {
                dfs(grid, i, j);
                return perimeter;
            }
        }
    }

    return 0;
}

    private void dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if(grid[r][c]==0){
            return ;
        }

        if (visited.contains(List.of(r, c))) {
            return;
        }

        visited.add(List.of(r, c));
        

        if ((r - 1) < 0) {
            perimeter++;
        } else {
            if (grid[r - 1][c] == 0) {
                perimeter++;
            }
        }
        if ((c - 1) < 0) {
            perimeter++;

        } else {
            if (grid[r][c - 1] == 0) {
                perimeter++;
            }
        }
        if ((r + 1) >= grid.length) {
            perimeter++;
        } else {
            if (grid[r + 1][c] == 0) {
                perimeter++;
            }
        }
        if ((c + 1) >= grid[0].length) {
            perimeter++;
        } else {
            if (grid[r][c + 1] == 0) {
                perimeter++;
            }
        }
        

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);

    }
}