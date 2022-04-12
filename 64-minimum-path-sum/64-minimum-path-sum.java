class Solution {
    public int minPathSum(int[][] grid) {
        
        // calc 0th in x, y
		for (int x = 1; x < grid[0].length; x += 1) 
			grid[0][x] = grid[0][x - 1] + grid[0][x];
		for (int y = 1; y < grid.length; y += 1)
			grid[y][0] = grid[y - 1][0] + grid[y][0];

		// calc 1 ~ Nth in x, y
		for (int y = 1; y < grid.length; y += 1)
			for (int x = 1; x < grid[0].length; x += 1)				
				grid[y][x] = grid[y][x] + Math.min(grid[y][x - 1], grid[y - 1][x]);

		return grid[grid.length - 1][grid[0].length - 1];
    }
}