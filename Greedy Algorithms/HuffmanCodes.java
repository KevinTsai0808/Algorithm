import java.util.*;

public class HuffmanCodes {
	
	PriorityQueue<Codes> queue = new PriorityQueue<Codes>(new Codes());
	int cost = 0;
	
	public void addActivity(char cha, int fre) {
		queue.add(new Codes(cha, fre));
	}
	
	public void HC() {
		Codes root = new Codes();
		int n = queue.size();
		for(int i = 0; i < n-1; i++) {
			Codes x = queue.poll();		
			Codes y = queue.poll();
			Codes z = new Codes();
			z.fre = x.fre + y.fre;
			z.left = x;
			z.right = y;
			queue.add(z);
			if(i == n-2) {
				 root = z;
				 
			}	
		}
		printResult(root, " ");
		System.out.println("");
		System.out.print("Total Cost : "+ cost);
	}
	
	public void printResult(Codes root, String string) {
		if(root.left == null && root.right == null) {
			System.out.print(root.cha + " : " + string);
			cost += (root.fre * (string.length()-1));
		}
		else{
			printResult(root.left,string + "0");
			System.out.println("");
			printResult(root.right,string + "1");
		}
	}
	
	
	
	
	public class Codes implements Comparator<Codes>{
		int fre;
		char cha;
		String finalCodes;
		Codes left;
		Codes right;
		//Codes root;
		
		public Codes() {}
		public Codes(char cha, int fre){
			this.cha = cha;
			this.fre = fre;
		}
		
		@Override
		public int  compare(Codes a, Codes b) {
			if(a.fre > b.fre) {
				return 1;
			}
			else if(a.fre < b.fre) {
				return -1;
			}
			else {
				return 0;
			}		
		}
	}
	
	public static void main(String[] args) {
		HuffmanCodes hc = new HuffmanCodes();
		hc.addActivity('f', 5);
		hc.addActivity('e', 9);
		hc.addActivity('c', 12);
		hc.addActivity('b', 13);
		hc.addActivity('d', 16);
		hc.addActivity('a', 45);
		hc.HC();
	}

}
