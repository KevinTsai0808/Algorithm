import java.util.Stack;
import java.util.LinkedList;

public class TopologicalSort {
	private LinkedList<Integer> Adj[];
	//color用來表示狀態(0:白 1:灰 2:黑)
	private int[] color;
	private int time;
	private int[] p;
	private int[] d;
	private int[] f;
	@SuppressWarnings("unchecked")
	public TopologicalSort(int nodes) {
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
	public void Depth_First_Search(int source, Stack output){
		DFS_visit(source, output);	
		for(int i = 0; i < Adj.length; i++) {
			if(color[i] == 0) {
				DFS_visit(i, output);	
			}
		}
	}
	
	private int checkBackward() {
		int check = 0;
		for(int i = 0; i < Adj.length; i++) {
			for(int j = 0; j < Adj[i].size(); j++) {
				if(d[Adj[i].get(j)] <= d[i] && f[Adj[i].get(j)] >= f[i]) {
					check = 1;
					System.out.println("Backward Edge Exist : " + i + " to " + Adj[i].get(j));
				}
			}
		}
		return check;
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void DFS_visit(int u, Stack output) {
		color[u] = 1;
		time++;
		d[u] = time;
		for(int i = 0; i < Adj[u].size(); i++) {
			int v = Adj[u].get(i);
			if(color[v] == 0) {
				p[v] = u;
				DFS_visit(v, output);
			}
		}
		color[u] = 2;
		time++;
		f[u] = time;
		output.push(u);	
	}
	
	public void Sort(int source) {
		Stack<Integer> output = new Stack<Integer>();
		//step1 : do DFS & check whether exist backward edge
		Depth_First_Search(source, output);
		if(checkBackward() == 0) {
			//step2 : return node in order of finish time
			System.out.println("Following is a Topological Sort of the given graph : ");
			while(!output.isEmpty()) {
				int curnode = output.pop();
				System.out.print(curnode + " ");
			}
		}
		else {
			System.out.println("Can't Do Topological Sort!");
		}		
	}
	
	public static void main(String args[]) {	 
		//example with no backward edge
//		TopologicalSort t = new TopologicalSort(9);
//        t.addEdge(0, 1);
//        t.addEdge(0, 3);
//        t.addEdge(1, 2);
//        t.addEdge(3, 2);
//        t.addEdge(5, 6);
//        t.addEdge(5, 7);
//        t.addEdge(6, 3);
//        t.addEdge(6, 7);
//        t.addEdge(8, 7);
//        t.Sort(0);
		
		//example with  backward edge
		TopologicalSort t = new TopologicalSort(8);
		t.addEdge(0, 1);
		t.addEdge(0, 4);
		t.addEdge(1, 2);
		t.addEdge(1, 4);
		t.addEdge(2, 3);
		t.addEdge(3, 1);
		t.addEdge(5, 6);
		t.addEdge(5, 7);
		t.addEdge(6, 0);
		t.addEdge(6, 4);
		t.addEdge(7, 5);
		t.addEdge(7, 6);
		t.Sort(0);
	}
}
