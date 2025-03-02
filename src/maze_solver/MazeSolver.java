package maze_solver;

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {

    // Directions for moving in the maze: up, down, left, right
    private static final int[] DIRECTIONS_X = {-1, 1, 0, 0};
    private static final int[] DIRECTIONS_Y = {0, 0, -1, 1};

    public static int findShortestPath(int[][] maze, int startX, int startY, int endX, int endY) {
        int n = maze.length;  // Number of rows
        int m = maze[0].length;  // Number of columns

        // Check if start or end is blocked
        if (maze[startX][startY] == 1 || maze[endX][endY] == 1) {
            return -1;
        }

        // Initialize visited array to keep track of visited cells
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;

        // Queue for BFS, storing the current position and distance from the start
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});  // {x, y, distance}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // If we've reached the destination
            if (x == endX && y == endY) {
                return distance;
            }

            // Explore all possible moves (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTIONS_X[i];
                int newY = y + DIRECTIONS_Y[i];

                // Check if the new position is within bounds, walkable, and not visited
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maze[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, distance + 1});
                }
            }
        }

        // No valid path found
        return -1;
    }
}
