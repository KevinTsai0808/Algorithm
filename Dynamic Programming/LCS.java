import java.util.Scanner;

public class LCS {

	//c紀錄共同子字串的元素數量
	//b紀錄箭頭方向(0為左上箭頭 1為左箭頭 2為上箭頭 )
	private int[][] c;
	private int[][] b;

	public void LongestCommonSubsequence(String[] x, String[] y) {
		int m = x.length + 1;
		int n = y.length + 1;
		c = new int[m][n];
		b = new int[m][n];
		for(int i = 0; i < m; i++) {
			c[i][0] = 0;
		}
		for(int i = 0; i < n; i++) {
			c[0][i] = 0;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(x[i-1].equals(y[j-1])) {
					//相同則LCS為x、y的前一個的LCS再加一
					c[i][j] = c[i-1][j-1] + 1;
					b[i][j] = 0;
				}
				//不相同時則比較x的前一個還是y的前一個的LCS較長
				else if(c[i-1][j] >= c[i][j-1] ) {
					c[i][j] = c[i-1][j];
					b[i][j] = 2; 
				}
				else {
					c[i][j] = c[i][j-1];
					b[i][j] = 1;
				}
			}
		}
		System.out.println("Length of LCS : " + c[m-1][n-1]);
		System.out.print("Longest Common Subsequence : < ");
		PrintLCScontent(x, m, n);
		System.out.print(">");
	}
	
	private void PrintLCScontent(String[] x, int m, int n){
		if(m == 1 || n == 1) {
			return;
		}
		if(b[m-1][n-1] == 0) {
			PrintLCScontent(x, m-1, n-1);
			System.out.print(x[m-2] + " ");
		}
		else if(b[m-1][n-1] == 2) {
			PrintLCScontent(x, m-1, n);
		}
		else {
			PrintLCScontent(x, m, n-1);
		}		
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- 輸入序列x ----------\n");
		userinput = sc.nextLine();
		String[] x = userinput.split(" ");
		
		System.out.println("---------- 輸入序列y ----------\n");
		userinput = sc.nextLine();
		String[] y = userinput.split(" ");
		sc.close();
		
		LCS lcs = new LCS();
		lcs.LongestCommonSubsequence(x, y);
	}

}
