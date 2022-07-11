import java.util.LinkedList;
import java.util.Stack;

public class StronglyConnectedComponents {
	private LinkedList<Integer> Adj[];
	//color用來表示狀態(0:白 1:灰 2:黑)
	private int[] color;
	private int time;
	private int[] p;
	private int[] d;
	private int[] f;
	
	@SuppressWarnings("unchecked")
	public StronglyConnectedComponents(int nodes) {
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
		
	@SuppressWarnings("rawtypes")
	private void Depth_First_Search(int source, Stack output, LinkedList<Integer>[] graph){
		DFS_visit(source, output, graph);	
		for(int i = 0; i < graph.length; i++) {
			if(color[i] == 0) {
				DFS_visit(i, output, graph);	
			}
		}
	}
	
	//for step1 DFS(need Stack)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void DFS_visit(int u, Stack output, LinkedList<Integer>[] graph) {
		color[u] = 1;
		time++;
		d[u] = time;
		for(int i = 0; i < graph[u].size(); i++) {
			int v = graph[u].get(i);
			if(color[v] == 0) {
				p[v] = u;
				DFS_visit(v, output, graph);
			}
		}
		color[u] = 2;
		time++;
		f[u] = time;
		output.push(u);	
	}
	
	// for reverse graph DFS(without Stack)
	private void DFS_visit(int u, LinkedList<Integer>[] graph) {
		System.out.print(u);
		color[u] = 1;
		time++;
		d[u] = time;
		for(int i = 0; i < graph[u].size(); i++) {
			int v = graph[u].get(i);
			if(color[v] == 0) {
				p[v] = u;
				DFS_visit(v, graph);
			}
		}
		color[u] = 2;
		time++;
		f[u] = time;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private LinkedList[] reverseGraph(LinkedList[] adj) {
		LinkedList<Integer> reverseAdj[] = new LinkedList[adj.length];
		for(int i = 0; i < adj.length; i++) {
			reverseAdj[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i < adj.length; i++) {
			while(!adj[i].isEmpty()) {
				reverseAdj[(int)adj[i].peek()].add(i);
				adj[i].remove();
			}
		}
		return reverseAdj;
	}
	
	@SuppressWarnings({ "unchecked" })
	public void SCC(int source) {
		System.out.println("Following are strongly connected components in given graph : ");
		//step1:do DFS on graph
		Stack<Integer> output = new Stack<Integer>();
		Depth_First_Search(source, output, Adj);
		//step2:reverse graph
		LinkedList<Integer> reverseAdj[] = reverseGraph(Adj);
		for(int i = 0; i < color.length; i++) {
			color[i] = 0;
		}
		//step3:do DFS on reverse graph and print SCC
		while(!output.isEmpty()) {
			int u = (int)output.pop();
			if(color[u] == 0) {
				DFS_visit(u, reverseAdj);
				System.out.print("  ");
			}
		}	
	}
	
	public static void main(String[] args) {
		StronglyConnectedComponents scc = new StronglyConnectedComponents(8);
		scc.addEdge(0, 4);
		scc.addEdge(1, 2);
		scc.addEdge(1, 3);
		scc.addEdge(2, 1);
		scc.addEdge(4, 0);
		scc.addEdge(5, 0);
		scc.addEdge(5, 2);
		scc.addEdge(5, 6);
		scc.addEdge(6, 2);
		scc.addEdge(6, 7);
		scc.addEdge(7, 5);
		scc.SCC(0);
	}

}
