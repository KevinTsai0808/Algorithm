
import java.util.Collections;
import java.util.ArrayList;

public class ActivitySelectionProblem {
	private int s[];
	private int f[];
	private ArrayList<Activity> input = new ArrayList<Activity>();
	
	public class Activity implements Comparable<Activity>{
		int start;
		int finish;
		public Activity(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		
		@Override
		public int compareTo(Activity a) {
			return this.finish - a.finish;
		}
	}
	
	public void addActivity(int start, int finish) {
		input.add(new Activity(start, finish));
	}
	
	
	public void ASP() {
		System.out.println("Following activities are selected");
		Collections.sort(input);
		this.f = new int[input.size()];
		this.s = new int[input.size()];
		for(int i = 0; i < input.size(); i++) {
			f[i] = input.get(i).finish;
			s[i] = input.get(i).start;
		}
		int k = 0;
		int length = 1;
		System.out.println("Activity " + 1 + " : start at time " + s[0] + ", finish at time " + f[0]);
		for(int m = 1; m < input.size(); m++) {
			if(s[m] >= f[k]) {
				k = m;
				length++;
				System.out.println("Activity " + (k+1) + " : start at time " + s[m] + ", finish at time " + f[m]);
			}	
		}
		System.out.print("Numbers of Activities : "+ length);
	}
	

	public static void main(String[] args) {
		ActivitySelectionProblem asp = new ActivitySelectionProblem();
		asp.addActivity(3, 5);
		asp.addActivity(0, 6);
		asp.addActivity(3, 8);
		asp.addActivity(5, 9);
		asp.addActivity(12, 14);
		asp.addActivity(2, 13);
		asp.addActivity(8, 12);
		asp.addActivity(6, 10);
		asp.addActivity(8, 11);
		asp.addActivity(5, 7);
		asp.addActivity(1, 4);
		asp.ASP();
	}
	

}
