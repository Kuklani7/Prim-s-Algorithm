Minimum Spanning Tree (MST) using Prim’s Algorithm

Tech Stack: Java, Arrays, ArrayList, File I/O, Graph Algorithms

This project computes a Minimum Spanning Tree (MST) from a graph represented as an adjacency matrix using Prim’s Algorithm. The implementation is optimized to run in 
𝑂
(
𝑛
2
)
O(n
2
) time by directly working on the matrix and maintaining the best possible connection (edge and parent) for each node. The final output is a parent array that represents the MST structure.

I also built parser utilities to read graph data directly from input files and convert it into the required adjacency matrix format. A Driver.java file is used to connect everything together, handling input, invoking the MST logic, and producing the final output, making the entire workflow clean and easy to test.
