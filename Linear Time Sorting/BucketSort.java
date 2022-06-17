import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;


public class BucketSort {
	private double [] A;
	public BucketSort(double[]arr) {
		this.A = arr;
	}
	
	private void InsertionSort(Double[] arr) {
		for(int j = 1; j < arr.length; j++) {
			double key = arr[j];
			int a = j - 1;
			while(a >= 0 && key < arr[a]) {
				arr[a + 1] = arr[a];
				a -- ;
			}
			arr[a + 1] = key;
		}
	}
	
	public double[] Sort() {
		@SuppressWarnings("unchecked")
		List<Double>[] bucket = new List[A.length];
		for(int i = 0; i < A.length; i++) {
			bucket[i] = new LinkedList<>();
		}
		for (int i = 0; i < A.length; i++){ 
		    int index = (int)(A[i] * A.length);
		    bucket[index].add(0, A[i]);
		}
		
		//對每一個LinkedList做insertion sort
		for(int i = 0; i < bucket.length; i++){ 
			
			Double[] copy = new Double[bucket[i].size()];
			bucket[i].toArray(copy);
			InsertionSort(copy);
			bucket[i] = Arrays.asList(copy);	
		}
		
		
		//串接每一個LinkedList
		int index = 0;
		for(int i = 0; i < bucket.length; i++){ 
			for(int j = 0; j < bucket[i].size(); j++) {
				A[index] = bucket[i].get(j);
				index++ ;
			}
		}
		
		return A;
	}
	
	public void Print(double[] arr) {
		System.out.println("\n---------- OUTPUT ----------\n");
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		String userinput;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("---------- INPUT ----------\n");
		userinput = keyboard.nextLine();
		keyboard.close();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入double陣列
		double[] output = new double[Input.length];
		for(int i =0 ; i < output.length ; i++) {
			output[i] =  Double.parseDouble(Input[i]);
		}
		BucketSort BS = new BucketSort(output);
		BS.Sort();
		BS.Print(output);
	}
}
