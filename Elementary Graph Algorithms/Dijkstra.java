import java.util.*;



public class Dijkstra {
	private LinkedList<Vertices> Adj[];
	//private LinkedList<Integer> Adj[];
	private int v;
	private int[] p;
	private int[] d;
	
	
	@SuppressWarnings("unchecked")
	public Dijkstra(int v) {
		this.v = v;
		d = new int[v];
		p = new int[v];
		Adj = new LinkedList[v];
		for(int i = 0; i < Adj.length; i++) {
			Adj[i] = new LinkedList<Vertices>();
		}
	}
	
	public void addEdges(int source, int dest, int weight) {
		Adj[source].add(new Vertices(dest, weight));	
	}
	
	
	
	private int findIndex(int key) {
		for(int i = 0; i < v; i++) {
			if(d[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	private void initialize_single_source(int source) {
		for(int i = 0; i < v; i++) {
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		d[source] = 0;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void relax(int u, Vertices v, PriorityQueue queue) {
		if(d[v.dest] > d[u] + v.weight) {
			queue.remove(d[v.dest]);
			d[v.dest] = d[u] + v.weight;
			p[v.dest] = u;
			queue.add( d[u] + v.weight);
		}
	}
	
	public class Vertices {
		int weight;
		int dest;
		
		public Vertices(int dest, int weight) {
			this.weight = weight;
			this.dest = dest;
		}
	}
	
	// Don't allow negative weight edge
	public void dijkstra(int source) {
		PriorityQueue<Integer> queue= new  PriorityQueue<Integer>();
		initialize_single_source(source);
		for(int i = 0; i < v; i++) {
			queue.add(d[i]);
		}
		while(!queue.isEmpty()) {
			int u = findIndex(queue.poll());
			for(int i = 0; i < Adj[u].size(); i++) {
				relax(u, Adj[u].get(i), queue);
			}
		}
		printInfo(source);
	}
	
	public void printInfo(int source){
		for(int i = 0; i < v; i++) {
			System.out.println("Distance From Source Node " + source + " To Node " + i + " : " + d[i]);
		}
		System.out.println("--------------------------------------");
		for(int i = 0; i < v; i++) {
			System.out.print("Path From Source Node " + source + " To Node " + i + " : " );
			printspath(i, "");
			System.out.println();
		}
	}
	public void printspath(int v, String string) {
		if(v == 0) {
			System.out.print(v);
			return;
		}
		printspath(p[v], string+"v");
		System.out.print(" -> " + v );
	}
	
	public static void main(String[] args) {
		Dijkstra d = new Dijkstra(5);
		
		d.addEdges(0, 1, 10);
		d.addEdges(0, 2, 5);
		d.addEdges(1, 2, 2);
		d.addEdges(1, 3, 1);
		d.addEdges(2, 1, 3);
		d.addEdges(2, 4, 2);
		d.addEdges(2, 3, 9);
		d.addEdges(4, 0, 7);
		d.addEdges(4, 3, 6);
		d.addEdges(3, 4, 4);
		d.dijkstra(0);

	}

}
