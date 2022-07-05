import java.util.Scanner;

public class Knapsack {
	int[][] c;
	int[][] b;
	public void ZeroOneKnapsack(int W, int[] v, int[] w) {
		//c[i][j]表示在最大可容納重量為j的情況下，考慮完第 i 個物品後的總價值
		c = new int[v.length+1][W+1] ;
		b = new int[v.length+1][W+1];
		for(int i = 0; i < v.length + 1; i++ ) {
			c[i][0] = 0;
		}
		for(int i = 0; i < W+1; i++ ) {
			c[0][i] = 0;
		}
		for(int i = 1; i < v.length + 1; i++) {
			for(int j = 1; j < W+1; j++) {
				//物品重量大於最大可容納重量
				if(w[i-1] > j) {
					c[i][j] = c[i-1][j];
					b[i][j] = 0;
				}
				//放此物品的總價值大於不放此物品
				//j-w[i-1]的作用在於預留空間給目前的物品
				else if(c[i-1][j-w[i-1]] + v[i-1] > c[i-1][j]) {
					c[i][j] = c[i-1][j-w[i-1]] + v[i-1];
					b[i][j] = 1;
				}
				else {
					c[i][j] = c[i-1][j];
					b[i][j] = 0;
				}
			}
		}
		System.out.println("總價值：" + c[v.length][W-1]);
		PrintResult(W, v.length, w);
		
	}

	private void PrintResult(int W, int l, int[] w) {
		if(W <= 0 || l == 0) {
			return;
		}
		
		if(b[l][W] == 1) {
			PrintResult(W-w[l-1], l-1, w);
			System.out.println("物品" + l + "： Yes");
		}
		else {
			PrintResult(W, l-1, w);
			System.out.println("物品" + l + "： No");
		}
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---------- 輸入各物品的重量 ----------\n");
		userinput = sc.nextLine();
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] w = new int[Input.length];
		for(int i =0 ; i < Input.length ; i++) {
			w[i] =  Integer.parseInt(Input[i]);
		}
		
		System.out.println("---------- 輸入各物品的價值 ----------\n");
		userinput = sc.nextLine();
		String[] Input2 = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] v = new int[Input2.length];
		for(int i =0 ; i < Input2.length ; i++) {
			v[i] =  Integer.parseInt(Input2[i]);
		}
		
		System.out.println("---------- 輸入背包可容納重量 ----------\n");
		int W = sc.nextInt();
		sc.close();
		
		Knapsack ks = new Knapsack();
		ks.ZeroOneKnapsack(W, v, w);
	}
}
