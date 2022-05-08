
public class Heap {
	public Heap() {}
	private int heap_size;
	//找父節點位置
	private int Parent(int i) {
		i = ((i+1) / 2) -1;
		return i;
	}
	//找左邊子節點
	private int Left(int i) {
		i = (2 * (i + 1)) - 1;
		return i;
	}
	//找右邊子節點
	private int Right(int i) {
		i = 2 * (i + 1);
		return i;
	}
	
	private void exchange(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	private void Max_Heapify(int[] A, int i){
		int l = Left(i);
		int r = Right(i);
		//存放父、子節點中最大的節點位置
		int largest;
		if(heap_size == 0) {
			heap_size = A.length;
		}
		//左子節點存在且比父節點大
		if(l <= heap_size - 1 && A[l] > A[i]) {
			largest = l; 
		}
		//左子節點不存在或是比父節點小
		else{
			largest = i;
		}
		
		if(r <= heap_size - 1 && A[r] > A[largest]) {
			largest = r; 
		}
		//父節點比子節點小，交換位置
		if(largest != i) {
			exchange(A, i, largest);
			//再接著跟原本子節點的子節點比較
			Max_Heapify(A, largest);
		}
	}
	
	private void Build_Max_Heap(int[] A) {
		if(heap_size == 0) {
			heap_size = A.length;
		}
		//從最後一個父節點的位置開始往上做Max_Heapify
		for(int i = (heap_size / 2 - 1); i >= 0 ; i--) {
			Max_Heapify(A, i);
		}
	}
	
	public void Heap_Sort(int[] A) {
		Build_Max_Heap(A);
		//每次迴圈都把Heap中最大的提出
		for(int i = heap_size - 1; i >= 1; i-- ) {
			exchange(A, 0, i);
			heap_size -= 1;
			Max_Heapify(A, 0);
		}
	}
	
	
	public void Print(int[] A) {
		System.out.println("\n---------- OUTPUT ----------\n");
		System.out.print("[");
		for(int i =0 ; i < A.length - 1 ; i++) {
			System.out.print(A[i] + ", ");
		}
		System.out.print(A[A.length -1 ] + "]");
	}
	
	
}
