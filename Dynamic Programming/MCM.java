import java.util.Scanner;

public class MCM {
	
	private int[][] m;
	private int[][] s;
	
	public void MatrixChainOrder(int[] p){
		int n = p.length - 1;
		int sentinel = Integer.MAX_VALUE;
		//m紀錄cost
		//s紀錄切割點
		m = new int[n][n];
		s = new int[n][n];
		for(int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		//l矩陣鏈長度
		for(int l = 2; l <= n; l++) {
			for(int i = 0; i <= n-l; i++) {
				int j = i+l-1;
				m[i][j] = sentinel;
				//k表示切割點
				for(int k = i; k < j;k++) {
					int q = m[i][k] + m[k+1][j] + p[i] * p[k+1] * p[j+1];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;		
					}
				}
			}
		}
		System.out.println("Minimum cost of parenthesization is : " + m[0][n-1]);
		System.out.print("Parenthesization output : " );
		 PrintOptimalParens(s, 0, n-1);
	}
	
	private void PrintOptimalParens(int[][] s,int i,int j) {
		if(i == j) {
			System.out.print("A" + (i+1));
		}
		else {
			System.out.print("(");
			PrintOptimalParens(s, i, s[i][j]);
			PrintOptimalParens(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- 依序輸入A1、A2、A3...... ----------\n");
		userinput = sc.nextLine();
		sc.close();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] output = new int[Input.length];
		for(int i =0 ; i < output.length ; i++) {
			output[i] =  Integer.parseInt(Input[i]);
		}
		
		MCM mcm = new MCM();
		mcm.MatrixChainOrder(output);
	}

}
