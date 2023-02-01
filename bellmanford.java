import java.util.*;
public class bellmanford {
    private int n[]; //distance
    private int nodes; //no.of nodes
    public bellmanford(int nodes) {
        this.nodes = nodes;
        n = new int[nodes + 1];
    }
    public void calculate(int source, int a[][]) {
        for (int i = 1; i <= nodes; i++) {
            n[i] = 999;
        }
        n[source] = 0;
        for (int k = 1; k <= nodes - 1; k++) {
            for (int i = 1; i <= nodes; i++) {
                for (int j = 1; j <= nodes; j++) {
                    if (a[i][j] != 999) {
                        if (n[j] > n[i] + a[i][j])
                            n[j] = n[i] + a[i][j];
                    }
                }
            }
        }
        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++) {
                if (a[i][j] != 999) {
                    if (n[j] > n[i] + a[i][j]) {
                        System.out.println("Graph contains negative weight cycle");
                        return;
                    }
                }
            }
        }
        for (int i = 1; i <= nodes; i++) {
            System.out.println("\n Distance from source " + source + " to node " + i + " is: " + n[i]);
        }
    }
    public static void main(String[] args) {
        int nodes = 0, source;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        nodes = read.nextInt();
        int a[][] = new int[nodes + 1][nodes + 1];                                  //a= adjacency matrix
        System.out.println("Enter the weighted matrix: ");
        for (int i = 1; i <= nodes; i++) {
            for (int j = 1; j <= nodes; j++) {
                a[i][j] = read.nextInt();
                if (i == j) {
                    a[i][j] = 0;
                    continue;
                }
                if (a[i][j] == 0)
                    a[i][j] = 999;
            }
        }
        System.out.println("Enter the source node: ");
        source = read.nextInt();
        bellmanford bf = new bellmanford(nodes);
        bf.calculate(source, a);
        read.close();
}
}