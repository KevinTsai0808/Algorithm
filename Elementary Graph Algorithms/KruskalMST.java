import java.util.*;


public class KruskalMST {
	ArrayList<Edge> edge = new ArrayList<Edge>();
	// 用來處理 disjoint sets
	Subset[] subset;
	int V;
	int result = 0;
	int count = 0;
	public KruskalMST(int v) {
		this.V = v;
		this.subset = new Subset[v];
	}
	// 每次加入邊時會有三個 attrebutes:source, destination, weight
	public void addEdges(int s, int d, int w) {
		edge.add(new Edge(s, d, w));
		edge.add(new Edge(d, s, w));
	}
	
	public void MST() {
		System.out.println("Following are the edges in the constructed MST : ");
		//存放構成 MST 的邊
		ArrayList<Edge> output = new ArrayList<Edge>();
		for(int i = 0; i < V; i++) {
			subset[i] = new Subset(); 
			subset[i].make_set(i);
		}
		//實作 Comparable 介面並 override compareTo 方法
		//使排序的依據為 override 的方法
		Collections.sort(edge);
		while(result < V-1) {
			Edge cur = edge.get(count);
			int x = find_set(subset, cur.source);
			int y = find_set(subset, cur.dest);
			//兩集合不同則結合
			if(x != y) {
				result += 1;
				output.add(cur);
				union(cur.source, cur.dest, subset);
			}
			count++;
		}
		int total_cost = 0;
		for(int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i).source + " to " + output.get(i).dest + " , cost : " + output.get(i).weight);
			total_cost += output.get(i).weight;
		}
		System.out.println("Minimum Cost Spanning Tree : " + total_cost);
	}
	
	
	
	
	
	public int find_set(Subset[] subset, int i) {
		if(subset[i].parent != i) {
			return find_set(subset, subset[i].parent);
		}
		return i;
	}
	
	public void union(int x, int y, Subset[] subset) {
		int x1 = find_set(subset, x);
		int x2 = find_set(subset, y);
		if(x1 != x2) {
			if(subset[x1].rank < subset[x2].rank ) {
				subset[x1].parent = x2;
			}
			else if(subset[x1].rank > subset[x2].rank){
				subset[x2].parent = x1;
			}
			else {
				subset[x1].parent = x2;
				subset[x2].rank ++;
			}
		}
	}
		
	public class Edge implements Comparable<Edge>{
		int source;
		int dest;
		int weight;
		
		public Edge(int s, int d, int w) {
			this.source = s;
			this.dest = d;
			this.weight = w;
		}
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	public class Subset{
		int parent;
		int rank;
		
		public void make_set(int a) {
			this.parent = a;
			this.rank = 0;
		}
	}
	
	public static void main(String args[]) {
		KruskalMST graph = new KruskalMST(6);
		graph.addEdges(0, 1, 4);
		graph.addEdges(0, 2, 3);
		graph.addEdges(1, 2, 1);
		graph.addEdges(1, 3, 2);
		graph.addEdges(2, 3, 4);
		graph.addEdges(3, 4, 2);
		graph.addEdges(4, 5, 6);
		graph.MST();
	}
}
