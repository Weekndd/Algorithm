import java.io.*;
import java.util.*;

public class Main {
	static class Test {
		int dDay;
		int score;
		public Test(int dDay, int score) {
			super();
			this.dDay = dDay;
			this.score = score;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		PriorityQueue<Test> tests = new PriorityQueue<>((o1,o2) -> o2.dDay-o1.dDay);
		int day = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int dDay = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			day = Math.max(dDay, day);
			tests.add(new Test(dDay,score));
		}
		
		PriorityQueue<Test> pq = new PriorityQueue<>((o1,o2)-> o2.score-o1.score);
		int max = 0;
		for(int i=day; i>0; i--) {
			while(!tests.isEmpty() && tests.peek().dDay==i) {
				pq.offer(tests.poll());
			}
			if(!pq.isEmpty()) {
				max += pq.poll().score;
			}
		}
		System.out.println(max);
	}//end main
}
