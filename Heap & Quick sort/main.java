import java.util.*;


public class main {
	public static void main(String[]args) {
		String userinput;
		Scanner sc = new Scanner(System.in);
		System.out.println("---------- INPUT ----------\n");
		userinput = sc.nextLine();
		//將input存進String陣列
		String[] Input = userinput.split(" ");
		//String陣列中每一元素存入int陣列
		int[] sort = new int[Input.length];
		for(int i =0 ; i < sort.length ; i++) {
			sort[i] =  Integer.parseInt(Input[i]);
		}
		//HeapSort
		Heap practice1 = new Heap();
		practice1.Heap_Sort(sort);
		practice1.Print(sort);
		
		//Quicksort
		Quicksort practice2 = new Quicksort();
		practice2.Quick_Sort(sort, 0, sort.length - 1);
		practice2.Print(sort);
	}
	
}
