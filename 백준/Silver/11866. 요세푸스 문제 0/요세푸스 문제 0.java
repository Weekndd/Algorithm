import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		
		for(int i=0; i<N; i++) {
			q.offer(i+1);
		}
		
		List<Integer> list = new ArrayList<>();
		int count = 1;
		
		while(!q.isEmpty()) {
			
			if(count==K) {
				list.add(q.poll());
				count = 1;
			} else {
				q.offer(q.poll());
				count++;
			}
		}
		sb.append("<");
		for(int i=0; i<list.size(); i++) {
			if(i==list.size()-1) {
				sb.append(list.get(i)+">");
			} 
			else {
				sb.append(list.get(i)+", ");
			}
		}
		
		System.out.println(sb);
	}
}