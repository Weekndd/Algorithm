import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int som = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
		for(int i=2; i<=N; i++) {
			int n =Integer.parseInt(br.readLine());
			pq.offer(n);
		}
		
		int ans = 0;
		if(N==1) {
			System.out.println(0);
			return;
		}
		while(true) {
			int num = pq.poll();
			if(som>num) break;
			ans++;
			num--;
			som++;
			pq.offer(num);
		}
		System.out.println(ans);
	}//end main
}
