import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(que.isEmpty()) {
					sb.append(0+"\n");
				}
				else {
					sb.append(que.poll()+"\n");
				}
			}
			else {
				que.offer(num);
			}
		}
		System.out.println(sb);
	}//end main
}