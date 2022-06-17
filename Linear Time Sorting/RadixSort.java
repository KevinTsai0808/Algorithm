import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
	
	private int [] A;
	public RadixSort(int arr[]) {
		this.A = arr;
	}
	
	
	private int findMax(int arr[]) {
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			} 
		}
		return max;
	}
	

	public int[] Sort() {
		int digit = 0;
		int exp = 1;
		int max = findMax(A);
		while(max >= 1) {
			max /= 10;
			digit += 1;
		};
		for(int i = 1; i <= digit; i++) {	
			CountingSort(A, exp);
			exp *= 10;
		}
		return A;
	}
	
	private int[] CountingSort(int[] arr, int exp) {
		int[] c = new int[10];
		int[] output = new int[arr.length];
		
		//計算數字出現幾次
 		for(int i = 0; i < arr.length; i++) {
			c[(arr[i]/exp)%10] += 1;
		}
 		
 		//計算小於等於此數字的數有幾個
 		for(int j = 1; j < c.length; j++) {
 			c[j] += c[j-1];
 			
 			
 		}
 		System.out.println(" " );
 		//從最後一個元素往前保證stable
 		for(int k = arr.length-1; k >= 0; k--) {
 			output[c[(arr[k]/exp)%10]- 1] = arr[k];
 			c[(arr[k]/exp)%10] -= 1;
 		}
 		
 		for(int i = 0; i < arr.length; i++) {
 			arr[i] = output[i];
 		}
 		
 		
 		return arr; 
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
		int[] output = new int[Input.length];
		for(int i =0 ; i < output.length ; i++) {
			output[i] =  Integer.parseInt(Input[i]);
		}
		
		RadixSort RS = new RadixSort(output);
		RS.Sort();
		RS.Print(output);
	}
}
