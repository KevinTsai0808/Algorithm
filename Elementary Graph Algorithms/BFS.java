import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class BFS {
	private LinkedList<Integer> Adj[];
	private Queue<Integer> queue =new LinkedList<Integer>();
	private int[] color;
	private int[] d;
	private int[] p;
	//constructor
	@SuppressWarnings("unchecked")
	public BFS(int nodes) {
		Adj = new LinkedList[nodes];
		d = new int[nodes];
		p = new int[nodes];
		for(int i = 0; i < Adj.length; i++) {
			Adj[i] = new LinkedList<Integer>();
			d[i] = -1;
			p[i] = -1;
		}
	}
	
	public void addEdge(int source, int dest) {
		Adj[source].add(dest);
	}
 
	public void Breadth_First_Search(int source) {
		System.out.println("Breadth First Traversal for the graph is:");
		//color用來表示狀態(0:白 1:灰 2:黑)
		color = new int[Adj.length];
		color[source] = 1;
		p[source] = source;
		d[source] = 0;
		queue.add(source);
		while(!queue.isEmpty()) {
			int u = queue.remove();
			System.out.print(u + " ");
			for(int i=0; i<Adj[u].size(); i++) {
				int v = Adj[u].get(i);
				if(color[v] == 0) {
					color[v] = 1;
					d[v] = d[u] + 1;
					p[v] = u;
					queue.add(v);
				}
			}
			color[u] = 2;
		}
		System.out.println("");
		Printdp();	
	}
	
	private void Printdp() {
		System.out.println("");
		System.out.println("Distance from root to node i:");
		System.out.println(Arrays.toString(d));
		System.out.println("");
		System.out.println("Parent node of node i:");
		System.out.println(Arrays.toString(p));
	}
	
	
	
	
	public static void main(String[] args) {
		
		BFS b = new BFS(5);	 
        b.addEdge(0, 1);
        b.addEdge(0, 3);
        b.addEdge(1, 4);
        b.addEdge(2, 5);
        b.addEdge(2, 4);
        b.addEdge(3, 1);
        b.addEdge(4, 3);
        b.Breadth_First_Search(0);
	}

}
