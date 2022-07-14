//Method1: choose nodes
import java.util.PriorityQueue;

public class PrimMST {
	private int [][] Adj;
	private int key[];
	private int p[];
	private int visited[];
	private int v;
	private int total_cost = 0;
	
	
	public PrimMST(int nodes) {
		Adj = new int[nodes][nodes];
		key = new int [nodes];
		p = new int [nodes];
		visited = new int [nodes];
		v = nodes;
	}
	
	public void addEdges(int source, int dest, int weight) {
		Adj[source][dest] = weight;	
		Adj[dest][source] = weight;	
	}
	
	public int findIndex(int key, int[] visited) {
		for(int i = 0; i < v; i++) {
			if(this.key[i] == key && visited[i] == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public void MST(int source) {
		System.out.println("Following are the edges in the constructed MST : ");
		PriorityQueue<Integer> vertices = new PriorityQueue<Integer>();
		key[source] = 0;
		vertices.add(key[0]);
		 
		for(int i = 1; i < v; i++) {
			key[i] = Integer.MAX_VALUE;
			vertices.add(key[i]);
		}
		
		while(!vertices.isEmpty()) {
			int u = findIndex(vertices.remove(), visited);
			visited[u] = 1;
			total_cost += key[u];
			System.out.println(p[u] + " to " + u + " , cost : " + key[u]);
			for(int i = 0; i < v; i++) {
				if(Adj[u][i] != 0 && key[i] > Adj[u][i] && visited[i] == 0) {
					vertices.remove(key[i]);
					key[i] = Adj[u][i];
					vertices.add(key[i]);
					p[i] = u;
				}
			}
		}
		
		System.out.println("Minimum Cost Spanning Tree : " + total_cost);
		
	}
	
	
	public static void main(String[] args) {
		PrimMST graph = new PrimMST(6);
		graph.addEdges(0, 1, 4);
		graph.addEdges(0, 2, 3);
		graph.addEdges(1, 2, 1);
		graph.addEdges(1, 3, 2);
		graph.addEdges(2, 3, 4);
		graph.addEdges(3, 4, 2);
		graph.addEdges(4, 5, 6);
		graph.MST(0);

	}

}


//Method1: choose edges
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//
//
//public class PrimMST {
//	private LinkedList<Edge> Adj[];
//	//ArrayList<Edge> edge = new ArrayList<Edge>();
//	private int key[];
//	private int p[];
//	private int visited[];
//	private int v;
//	private int total_cost = 0;
//	
//	
//	@SuppressWarnings("unchecked")
//	public PrimMST(int nodes) {
//		Adj =new LinkedList[nodes];
//		key = new int [nodes];
//		p = new int [nodes];
//		visited = new int [nodes];
//		v = nodes;
//		for(int i = 0; i < Adj.length; i++) {
//			Adj[i] = new LinkedList<Edge>();
//			p[i] = -1;
//		}
//	}
//	
//	public void addEdges(int source, int dest, int weight) {
//		Adj[source].add(new Edge(source, dest, weight));
//		Adj[dest].add(new Edge(dest, source, weight));
//	}
//	
//	public void MST(int source) {
//		System.out.println("Following are the edges in the constructed MST : ");
//		PriorityQueue<Edge> vertices = new PriorityQueue<Edge>();
//		for(int i = 0; i < v; i++) {
//			key[i] = Integer.MAX_VALUE;
//		}
//		key[source] = 0;
//		visited[source] = 1;
//		for(int i = 0; i < Adj[source].size(); i++) {	
//			vertices.add(Adj[source].get(i));
//		}
//		while(!vertices.isEmpty()) {
//			Edge cur = vertices.remove();
//			if(visited[cur.dest] == 1) {
//				continue;
//			}
//			key[cur.dest] = cur.weight;	
//			visited[cur.dest] = 1;
//			System.out.println(cur.source + " to " + cur.dest + " , cost : " + cur.weight);
//			total_cost += cur.weight;
//			for(int i = 0; i < Adj[cur.dest].size(); i++) {	
//				vertices.add(Adj[cur.dest].get(i));				
//			}
//		}
//		System.out.println("Minimum Cost Spanning Tree : " + total_cost);
//		
//	}
//	
//	public class Edge implements Comparable<Edge>{
//		int source;
//		int dest;
//		int weight;
//		
//		public Edge(int s, int d, int w) {
//			this.source = s;
//			this.dest = d;
//			this.weight = w;
//		}
//		@Override
//		public int compareTo(Edge e) {
//			return this.weight - e.weight;
//		}
//	}
//	
//	public static void main(String[] args) {
//		PrimMST graph = new PrimMST(6);
//		graph.addEdges(0, 1, 4);
//		graph.addEdges(0, 2, 3);
//		graph.addEdges(1, 2, 1);
//		graph.addEdges(1, 3, 2);
//		graph.addEdges(2, 3, 4);
//		graph.addEdges(3, 4, 2);
//		graph.addEdges(4, 5, 6);
//		graph.MST(0);
//
//	}
//
//}


