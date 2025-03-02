import java.util.Scanner;

import static maze_solver.MazeSolver.findShortestPath;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input maze dimensions
        System.out.print("Enter the number of rows (N): ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns (M): ");
        int m = scanner.nextInt();

        // Input maze configuration
        int[][] maze = new int[n][m];
        System.out.println("Enter the maze configuration (0 for walkable, 1 for blocked) and use spaces to separate the blocks:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }

        // Input start and end coordinates
        System.out.print("Enter the start coordinates (x, y): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        System.out.print("Enter the end coordinates (x, y): ");
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();

        // Call the function to find the shortest path
        int result = findShortestPath(maze, startX, startY, endX, endY);

        // Output the result
        if (result != -1) {
            System.out.println("Shortest path length: " + result);
        } else {
            System.out.println("No valid path found.");
        }

        scanner.close();
    }
}