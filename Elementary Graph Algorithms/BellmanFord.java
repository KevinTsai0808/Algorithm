import java.util.ArrayList;
public class BellmanFord {
	private int[] d;
	private int[] p;
	private int v;
	private int source;
	private ArrayList<Edges> edge = new ArrayList<Edges>();
	
	public BellmanFord(int v, int source) {
		d = new int[v];
		p = new int[v];
		this.v = v;
		this.source = source;
	}

	public void addEdges(int s, int d, int w) {
		edge.add(new Edges(s, d, w));
	}
	
	private void initialize_single_source(int source) {
		for(int i = 0; i < v; i++) {
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		d[source] = 0;
	}
	
	private void relax(Edges e) {
		if(d[e.dest] > d[e.source] + e.weight) {
			d[e.dest] = d[e.source] + e.weight;
			p[e.dest] = e.source;
		}
	}
	
	public class Edges{
		int source;
		int dest;
		int weight;
		public Edges(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	
	public void bellman() {
		initialize_single_source(source);
		for(int i = 0; i < v-1; i++) {
			for(int j = 0; j < edge.size(); j++) {
				relax(edge.get(j));
			}
		}
		//做完relax後，所有節點都記錄了最短距離，若存在負權重的迴圈
		//則無法計算出最短距離（Negative Weight Cycle not means Negative Weight Edge）
		for(int i = 0; i < edge.size(); i++) {
			if(d[edge.get(i).dest] > d[edge.get(i).source] + edge.get(i).weight) {
				System.out.println("Exist Negative Weight Cycle");
				return;
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
		BellmanFord bf = new BellmanFord(5, 0);
		bf.addEdges(0, 1, 6);
		bf.addEdges(0, 2, 7);
		bf.addEdges(1, 2, 8);
		bf.addEdges(1, 3, 5);
		bf.addEdges(3, 1, -2);
		bf.addEdges(2, 3, -3);
		bf.addEdges(1, 4, -4);
		bf.addEdges(2, 4, 9);
		bf.addEdges(4, 3, 7);
		bf.addEdges(4, 0, 2);
		bf.bellman();
	}

}
