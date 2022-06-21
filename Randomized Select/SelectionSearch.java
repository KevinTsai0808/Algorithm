
import java.util.Scanner;

public class SelectionSearch {

	private void InsertionSort(int[] arr, int l, int r) {
		for(int j = l+1; j <= r ; j++) {
			int key = arr[j];
			int a = j - 1;
			while(a >= 0 && key < arr[a]) {
				arr[a + 1] = arr[a];
				a -- ;
			}
			arr[a + 1] = key;
		}
	}
	
	private int findMedian(int[] arr, int l, int r) {
		InsertionSort(arr, l, r);
		return arr[l+(r-l)/2]; 
	}
	
	private void exchange(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private int Partition(int[] arr, int l, int r, int m) {
		//最後一個元素和medianofmedian交換
		for (int i = l; i < r; i++) {
	        if (arr[i] == m) {
	        	exchange(arr, i, r);
	        	break;
	        }
		}
		
		int pivot = arr[r];
		int i = l - 1;
		for(int j = l; j <= r - 1; j++) {
			if(arr[j] <= pivot) {
				i += 1;
				exchange(arr, j, i);
			}
		}
		exchange(arr, i + 1, r);
		return i + 1;
	}
	
	public int Selectionsearch(int[] arr, int l, int r,  int k) {
		int n = r - l + 1;
		int[] median = new int[(n + 4)/5];
		int lessthanfive = 0;
		int medianofmedian = 0;
		//若search的範圍為1則回傳該位置
		if(n == 1) {
			return arr[l];
		}
		
		
		if(n >= 5) {
			//找出每一組的中位數
			for(int i = 0; i < n/5 ; i++) {
				median[i] = findMedian(arr, l+i*5, l+i*5+4);
			}
			//不滿5個的那組
			if(n - n/5 * 5 != 0) {
				median[n/5] = findMedian(arr, n/5*5, n-1);
			}
		}
		//n不到5個時直接找出medianofmedian
		else {
			medianofmedian = findMedian(arr, 0, n%5-1);
			lessthanfive = 1;
		}
		
		if(lessthanfive != 1) {
			medianofmedian = Selectionsearch(median, 0, median.length-1, median.length/2+1);
		}
		
		//以medianofmedian為pivot做partition
		int q = Partition(arr, l, r, medianofmedian);
		int i = q-l+1;
		if(i == k) {
			return arr[q];
		}
		else if(i > k) {
			return Selectionsearch(arr, l, q-1, k);
		}
		else {
			return Selectionsearch(arr, q+1, r, k-i);
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		int k;
		String userinput;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- INPUT ----------\n");
		userinput = sc.nextLine();
		System.out.println("---------- k th smallest----------\n");
		k = sc.nextInt();
		sc.close();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] output = new int[Input.length];
		for(int i =0 ; i < output.length ; i++) {
			output[i] =  Integer.parseInt(Input[i]);
		}
		
		SelectionSearch b = new SelectionSearch();
		System.out.println( k + "th smallest number is : " + b.Selectionsearch(output, 0, output.length-1, k));
		
	}

}
