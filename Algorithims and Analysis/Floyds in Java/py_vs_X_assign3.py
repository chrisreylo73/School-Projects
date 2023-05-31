"""
<Christian Lopez>
"""

# could be useful for Dijkstra
from queue import PriorityQueue

# for timing checks
import time

# use a very large number as placeholder for infinity
import sys
INF = sys.maxsize


def adjMatFromFile(filename):
    """ Create an adj/weight matrix from a file with verts, neighbors, and weights. """
    f = open(filename, "r")
    n_verts = int(f.readline())
    print(f" n_verts = {n_verts}")
    adjmat = [[INF] * n_verts for i in range(n_verts)]
    for i in range(n_verts):
        adjmat[i][i] = 0
    for line in f:
        int_list = [int(i) for i in line.split()]
        vert = int_list.pop(0)
        assert len(int_list) % 2 == 0
        n_neighbors = len(int_list) // 2
        neighbors = [int_list[n] for n in range(0, len(int_list), 2)]
        distances = [int_list[d] for d in range(1, len(int_list), 2)]
        for i in range(n_neighbors):
            adjmat[vert][neighbors[i]] = distances[i]
    f.close()
    # print(adjmat)
    return adjmat


def printAdjMat(mat, width=3):
    """ Print an adj/weight matrix padded with spaces and with vertex names. """
    res_str = '     ' + ' '.join([str(v).rjust(width, ' ')
                                 for v in range(len(mat))]) + '\n'
    res_str += '    ' + '-' * ((width + 1) * len(mat)) + '\n'
    for i, row in enumerate(mat):
        row_str = [str(elem).rjust(width, ' ') if elem <
                   INF else ' 999' for elem in row]
        res_str += ' ' + str(i).rjust(2, ' ') + ' |' + ' '.join(row_str) + "\n"
    print(res_str)


def floyd(W):

    # Copies the input matrix W and stores as variable distance
    # orignial ideas were the following however I think it isn't the right way to do it.
    # dist = W
    # dist = W.copy()
    dist = [row[:] for row in W]
    # Finds the number of vertices
    numVertices = len(W)
    # Traverse through every possible path from vertex i,j,k
    for x in range(numVertices):
        for y in range(numVertices):
            for z in range(numVertices):
                dist[y][z] = min(dist[y][z], dist[y][x] + dist[x][z])
    return dist


def assign03_main():
    """ Demonstrate the functions, starting with creating the graph. """
    g = adjMatFromFile("py_vs_X_assign3.txt")
    # Run Floyd's algorithm
    start_time = time.time()
    res_floyd = floyd(g)
    elapsed_time_floyd = time.time() - start_time
    print(f"  Floyd's elapsed time: {elapsed_time_floyd:.2f}")
    printAdjMat(res_floyd, 3)


# Check if the program is being run directly (i.e. not being imported)
if __name__ == '__main__':
    assign03_main()
