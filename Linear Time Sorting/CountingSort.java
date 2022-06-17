import java.util.Scanner;
import java.util.Arrays;

public class CountingSort {
	
	private int k;
	private int[] A;
	private int[] B;
	
	public CountingSort(int arr1[], int arr2[], int k) {
		this.k = k;
		this.A = arr1;
		this.B = arr2;
	}
	
	public int[] sort() {
		int[] c = new int[k];
		//計算數字出現幾次
 		for(int i = 0; i < A.length; i++) {
			c[A[i] -1 ] += 1;
		}
 		
 		//計算小於等於此數字的數有幾個
 		for(int j = 1; j < c.length; j++) {
 			c[j] += c[j-1];
 		}
 		
 		//從最後一個元素往前保證stable
 		for(int k = A.length-1; k >= 0; k--) {
 			B[c[A[k]-1]- 1] = A[k];
 			c[A[k]-1] -= 1;
 		}
 		return B; 
	}
	
	public void Print(int[] arr) {
		System.out.println("\n---------- OUTPUT ----------\n");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- INPUT ----------\n");
		userinput = sc.nextLine();
		sc.close();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] input = new int[Input.length];
		int k = 0;
		for(int i =0 ; i < input.length ; i++) {
			input[i] =  Integer.parseInt(Input[i]);
			if(input[i] > k) {
				k = input[i];
			}
		}
		int []output = new int[input.length];
		
		
		CountingSort CS = new CountingSort(input,output , k);
		CS.sort();
		CS.Print(output);
	}
	
	
	
}
