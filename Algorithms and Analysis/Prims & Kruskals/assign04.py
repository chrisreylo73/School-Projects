"""
Assign 04 - <Christian Lopez>
Credits:
    * Worked with Sean Kruse on Prims Algorithim.
    * Documentation was done by https://chat.openai.com/chat
    * https://www.freecodecamp.org/news/prims-algorithm-explained-with-pseudocode/
    * https://www.geeksforgeeks.org/prims-algorithm-simple-implementation-for-adjacency-matrix-representation/
    * https://www.geeksforgeeks.org/kruskals-algorithm-simple-implementation-for-adjacency-matrix/
Directions:
    * Complete the graph algorithm functions given below. Note that it may be
      helpful to define auxiliary/helper functions that are called from the
      functions below.  Refer to the README.md file for additional info.

    * NOTE: As with other assignments, please feel free to share ideas with
      others and to reference sources from textbooks or online. However, be sure
      to **cite your resources in your code. Also, do your best to attain a
      reasonable grasp of the algorithm that you are implementing as there will
      very likely be questions related to it on quizzes/exams.

    * NOTE: Remember to add a docstring for each function, and that a reasonable
      coding style is followed (e.g. blank lines between functions).
      Your program will not pass the tests if this is not done!
"""

# for timing checks
import time


def adjMatFromFile(filename):
    """Create an adj/weight matrix from a file with verts, neighbors, and weights."""
    f = open(filename, "r")
    n_verts = int(f.readline())
    print(f" n_verts = {n_verts}")
    adjmat = [[None] * n_verts for i in range(n_verts)]
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
    return adjmat


def prims(W):
    """Preforms Prim's algorithm using W as a weight/adj matrix."""
    # number of verticies
    numVerticies = len(W)
    # Initalize set of edges to empty
    setOfEdges = []
    # Initalize set of vertices to contain only the first one.
    verticiesChecked = []
    verticiesChecked.append(0)
    # Loop until all vertices have been added to the tree
    while len(verticiesChecked) < numVerticies:
        startVertex = 0
        endVertex = 0
        minWeight = float('inf')
        # Iterate over every pair of vertices, checking for the edge with the smallest weight
        for x in range(numVerticies):
            # Check if vertex x is already in the tree if so continue
            if x in verticiesChecked:
                for y in range(numVerticies):
                    if y not in verticiesChecked and W[x][y] is not None:
                        # If the weight of the edge connecting x and y is less than minWeight,
                        # update minWeight and the vertices of the edge
                        if W[x][y] < minWeight:
                            minWeight = W[x][y]
                            startVertex = x
                            endVertex = y
        # Add the end vertex of the edge with the smallest weight to verticiesChecked
        verticiesChecked.append(endVertex)
        # Add the edge with the smallest weight to setOfEdges
        setOfEdges.append((startVertex, endVertex, minWeight))
    # Return minimum spanning tree
    return setOfEdges


def find(i, parent):
    """Preforms a search for the root of the tree."""
    while parent[i] != i:
        i = parent[i]
    return i


def union(i, j, parent):
    """Preforms a union of the trees containing vertices i and j."""
    a = find(i, parent)
    b = find(j, parent)
    parent[a] = b


def kruskals(W):
    """Preforms Kruskal's using W as a weight/adj matrix."""
    numVerticies = len(W)
    # Initalize set of edges to empty
    setOfEdges = []
    # Initialize the `parent` list to keep track of the parent of each vertex
    parent = [i for i in range(numVerticies)]
    while (len(setOfEdges) < numVerticies - 1):
        startVertex = 0
        endVertex = 0
        minWeight = float('inf')
        # Iterate over every pair of vertices, checking for the edge with the smallest weight
        for x in range(numVerticies):
            for y in range(numVerticies):
                # Check if the vertices x and y belong to different trees
                if find(x, parent) != find(y, parent) and W[x][y] is not None:
                    # If the weight of the edge connecting x and y is less than minWeight,
                    # update minWeight and the vertices of the edge
                    if W[x][y] < minWeight:
                        minWeight = W[x][y]
                        startVertex = x
                        endVertex = y
        # Merge the trees containing startVertex and endVertex
        union(startVertex, endVertex, parent)
        # Add the edge with the smallest weight to setOfEdges
        setOfEdges.append((startVertex, endVertex, minWeight))
    # Return the list of edges in the minimum spanning tree
    return setOfEdges


def assign04_main():
    """Demonstrate the functions, starting with creating the graph."""
    g = adjMatFromFile("graph_verts100_A.txt")
    print(g)
    # Run Prim's algorithm
    start_time = time.time()
    res_prim = prims(g)
    elapsed_time_prim = time.time() - start_time
    print(f"Prim's runtime: {elapsed_time_prim:.2f}")

    # Run Kruskal's for a single starting vertex, 2
    start_time = time.time()
    res_kruskal = kruskals(g)
    elapsed_time_kruskal = time.time() - start_time
    print(f"Kruskal's runtime: {elapsed_time_kruskal:.2f}")

    # Check that sum of edges weights are the same for this graph
    cost_prim = sum([e[2] for e in res_prim])
    print("MST cost w/ Prim: ", cost_prim)
    cost_kruskal = sum([e[2] for e in res_kruskal])
    print("MST cost w/ Kruskal: ", cost_kruskal)
    assert cost_prim == cost_kruskal


# Check if the program is being run directly (i.e. not being imported)
if __name__ == '__main__':
    assign04_main()
