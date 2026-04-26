import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for(int i=0; i<N; i++) {
				long num = Integer.parseInt(st.nextToken());
				pq.add(num);
			}
			long sum = 0;
			while(!pq.isEmpty()) {
				if(pq.size()==1) {
					break;
				}
				else {
					long a = pq.poll();
					long b = pq.poll();
					pq.offer(a+b);
					sum+=a+b;
				}
			}
			sb.append((sum)+"\n");
		}//end TestCase
		System.out.println(sb);
	}//end main
}
