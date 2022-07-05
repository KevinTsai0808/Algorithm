
import java.util.Scanner;

public class AssemblyLineScheduleing {
	
	int f1[];
	int f2[];
	int l1[];
	int l2[];
	int f;
	int l;
	
	public int Assembly(int a[][], int t[][], int e [], int x[],int n) {
		f1 = new int[n];
		f2 = new int[n];
		l1 = new int [n];
		l2 = new int [n];
		f1[0] = e[0] + a[0][0];
		f2[0] = e[1] + a[1][0];
		
		for(int i = 1; i < n; i++) {
			//第一條裝配線
			if(f1[i-1] + a[0][i] <= f2[i-1] + t[1][i-1] + a[0][i]) {
				f1[i] = f1[i-1] + a[0][i];
				l1[i] = 1;
			}
			else {
				f1[i] = f2[i-1] + t[1][i-1] + a[0][i];
				l1[i] = 2;
			}
			
			//第二條裝配線
			if(f2[i-1] + a[1][i] <= f1[i-1] + t[0][i-1] + a[1][i]) {
				f2[i] = f2[i-1] + a[1][i];
				l2[i] = 2;
			}
			else {
				f2[i] = f1[i-1] + t[0][i-1] + a[1][i];
				l2[i] = 1;
			}
		}
		
		if(f1[n-1] + x[0] <= f2[n-1] + x[1]) {
			f = f1[n-1] + x[0];
			l = 1;
		}
		else {
			f =  f2[n-1] + x[1];
			l = 2;
		}
		
		return f;		
	}	
	
	public void PrintStations(int n) {
		int i = l;
		System.out.println("line " + l + " , station " + n);
		for(int j = n-1; j >= 1; j--) {
			if(i == 1) {
				System.out.println("line " + l1[j] + " , station " + j);
				i = l1[j];
			}
			else{
				System.out.println("line " + l2[j] + " , station " + j);
				i = l2[j];
			}
		}
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		//第一條裝配線
		System.out.println("---------- 第一條裝配線的 cost ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int n = Input.length;
		int[][] a = new int[2][n];
		for(int i =0 ; i < n ; i++) {
			a[0][i] =  Integer.parseInt(Input[i]);
		}
		
		//第二條裝配線
		System.out.println("---------- 第二條裝配線的 cost ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input2 = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		for(int i =0 ; i < n ; i++) {
			a[1][i] =  Integer.parseInt(Input2[i]);
		}
		
		//第一條裝配線換到第二條裝配線的時間
		System.out.println("---------- 第一條裝配線換到第二條裝配線的時間 ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input3 = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[][] t = new int[2][n-1];
		for(int i =0 ; i < n-1 ; i++) {
			t[0][i] =  Integer.parseInt(Input3[i]);
		}
		
		//第一條裝配線換到第二條裝配線的時間
		System.out.println("---------- 第二條裝配線換到第條裝配線的時間 ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input4 = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		for(int i =0 ; i < n-1 ; i++) {
			t[1][i] =  Integer.parseInt(Input4[i]);
		}
		
		//輸入前置costs及結束costs
		System.out.println("---------- 輸入前置costs及結束costs ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input5 = userinput.split(" ");
		
		//String陣列中每一元素存入int陣列
		int[] e = new int[2];
		int[] x = new int[2];
		for(int i = 0 ; i <= 1 ; i++) {
			e[i] =  Integer.parseInt(Input5[i]);
			x[i] =  Integer.parseInt(Input5[i+2]);
		}
		
		sc.close();
		
		System.out.println("\n---------- OUTPUT ----------\n");
		AssemblyLineScheduleing z = new AssemblyLineScheduleing();
		System.out.println("總costs : " + z.Assembly(a, t, e, x, n));
		z.PrintStations(n);
	}
}
