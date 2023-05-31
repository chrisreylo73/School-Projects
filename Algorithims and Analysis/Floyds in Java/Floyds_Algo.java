import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Name: Christian Lopez
 * Credits:
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 * https://www.programiz.com/dsa/floyd-warshall-algorithm
 * https://chat.openai.com/ for docStrings
 */
public class Floyds_Algo {
	private static final int INF = Integer.MAX_VALUE;

	/**
	 * Reads an adjacency matrix from a file and returns it as a 2D array.
	 *
	 * @param filename the name of the file to read
	 * @return a 2D array representing the adjacency matrix of the graph
	 * @throws NumberFormatException if the file contains a non-integer value
	 * @throws IOException           if there is an error reading the file
	 */
	public static int[][] adjMatFromFile(String filename) throws NumberFormatException, IOException {
		// Open the input file for reading
		BufferedReader f = new BufferedReader(new FileReader(filename));
		int n_verts = Integer.parseInt(f.readLine());
		System.out.printf(" n_verts = %d\n", n_verts);
		int[][] adjmat = new int[n_verts][n_verts];
		for (int i = 0; i < n_verts; i++) {
			Arrays.fill(adjmat[i], INF);
			adjmat[i][i] = 0;
		}

		// String line;
		for (String line = f.readLine(); line != null; line = f.readLine()) {
			String[] strList = line.split(" ");
			int[] intList = new int[strList.length];
			for (int i = 0; i < strList.length; i++) {
				intList[i] = Integer.parseInt(strList[i]);
			}
			int vert = intList[0];
			intList = Arrays.copyOfRange(intList, 1, intList.length);
			assert intList.length % 2 == 0;
			int n_neighbors = intList.length / 2;
			int[] neighbors = new int[n_neighbors];
			int[] distances = new int[n_neighbors];
			for (int i = 0; i < n_neighbors; i++) {
				neighbors[i] = intList[2 * i];
				distances[i] = intList[2 * i + 1];
			}
			for (int i = 0; i < n_neighbors; i++) {
				adjmat[vert][neighbors[i]] = distances[i];
			}
		}
		f.close();
		return adjmat;
	}

	/**
	 * Computes the shortest distances between all pairs of vertices in a graph
	 * using Floyd's algorithm.
	 * 
	 * @param W the weighted adjacency matrix of the graph
	 * @return a 2D array representing the shortest distances between all pairs of
	 *         vertices
	 */
	// Takes in adjacency Matrix (W)
	public static int[][] floyd(int[][] W) {
		// Get the number of vertices in the graph.
		int numVert = W.length;
		// Initialize a 2D array to store the shortest distances.
		int[][] dist = new int[numVert][numVert];
		// Copy the input weights into the distances array.
		for (int i = 0; i < numVert; i++) {
			for (int j = 0; j < numVert; j++) {
				dist[i][j] = W[i][j];
			}
		}
		// Find the shortest paths between all pairs of vertices.
		for (int k = 0; k < numVert; k++) {
			for (int i = 0; i < numVert; i++) {
				for (int j = 0; j < numVert; j++) {
					// If the distance from i to j is greater than the distance from i to k plus
					// the distance from k to j, update the distance from i to j to be the sum of
					// the distances from i to k and from k to j.
					if (dist[i][k] != INF && dist[k][j] != INF &&
							dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		// Return the 2D array of shortest distances between all pairs of vertices.
		return dist;
	}

	/**
	 * Prints the given 2D array representing an adjacency matrix with the given
	 * width for each element.
	 * 
	 * @param mat   the 2D array representing the adjacency matrix to be printed
	 * @param width the width for each element in the printed matrix
	 */
	public static void printAdjMat(int[][] mat, int width) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.printf("%4d, ", mat[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws NumberFormatException, IOException {
		try {
			int[][] matrix = Floyds_Algo.adjMatFromFile("py_vs_X_assign3.txt");
			long start = System.currentTimeMillis();
			int[][] solution = Floyds_Algo.floyd(matrix);
			long end = System.currentTimeMillis();
			System.out.println("My algorithm solution (or first part of it): ");
			Floyds_Algo.printAdjMat(solution, 3);
			System.out.println("My algorithm runtime (in milliseconds): " + (end - start));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
	}
}