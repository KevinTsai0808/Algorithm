import java.util.LinkedList;


public class DFS {
	
	private LinkedList<Integer> Adj[];
	//color用來表示狀態(0:白 1:灰 2:黑)
	private int[] color;
	private int time;
	private int[] p;
	private int[] d;
	private int[] f;
	
	@SuppressWarnings("unchecked")
	public DFS(int nodes) {
		Adj = new LinkedList[nodes];
		d = new int[nodes];
		f = new int[nodes];
		p = new int[nodes];
		color = new int[nodes];
		for(int i = 0; i < Adj.length; i++) {
			Adj[i] = new LinkedList<Integer>();
			p[i] = -1;
		}
	}

	public void addEdge(int source, int dest) {
		Adj[source].add(dest);
	}
	
	public void Depth_First_Search(int source){
		System.out.println("Depth First Traversal for the graph is:");
		System.out.print(source + " ");
		DFS_visit(source);	
		for(int i = 0; i < Adj.length; i++) {
			if(color[i] == 0) {
				System.out.print(i + " ");
				DFS_visit(i);	
			}
		}
		System.out.println(" ");
		for(int i = 0; i < Adj.length; i++) {
			System.out.println(" ");
			System.out.print("Start/Finish time of node" + i + " : ");
			System.out.println(d[i] + "/" + f[i]);
		}
		
	}
	
	private void DFS_visit(int u) {
		color[u] = 1;
		time++;
		d[u] = time;
		for(int i = 0; i < Adj[u].size(); i++) {
			int v = Adj[u].get(i);
			if(color[v] == 0) {
				p[v] = u;
				System.out.print(v + " ");
				DFS_visit(v);
			}
		}
		color[u] = 2;
		time++;
		f[u] = time;
	}
	
	public static void main(String[] args) {
		DFS d = new DFS(5);	 
        d.addEdge(0, 1);
        d.addEdge(0, 2);
        d.addEdge(1, 2);
        d.addEdge(2, 1);
        d.addEdge(2, 3);
        d.addEdge(3, 3);
        d.addEdge(4, 3);
        d.Depth_First_Search(2);

	}

}
