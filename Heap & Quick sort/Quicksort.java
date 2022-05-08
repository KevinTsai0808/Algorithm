import java.util.Random;

public class Quicksort {
	public Quicksort() {}
	
	private void exchange(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	private int Partition(int[] A, int p, int r) {
		/* 隨機取pivot
		Random rand = new Random();
		int random = rand.nextInt(r + 1 - p) + p;
		exchange(A, random, r);
		System.out.print(random);*/
		int pivot = A[r];
		int i = p - 1;
		for(int j = p; j <= r - 1; j++) {
			if(A[j] <= pivot) {
				i += 1;
				exchange(A, j, i);
			}
		}
		exchange(A, i + 1, r);
		return i + 1;
	}
	
	public void Quick_Sort(int[] A,int p, int r) {
		if(p < r) {
			int q = Partition(A, p, r);
			Quick_Sort(A, p, q - 1);
			Quick_Sort(A, q + 1, r);
		}
	}
	
	public void Print(int[] A) {
		System.out.println("\n---------- OUTPUT ----------\n");
		System.out.print("[");
		for(int i = 0 ; i < A.length - 1 ; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.print(A[A.length -1 ] + "]");
	}
	
}
