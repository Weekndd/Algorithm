import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		int last = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			String method = st.nextToken();
			if(method.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
				last = num;
			} 
			
			else if(method.equals("pop")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.poll());
				}
			} 
			
			else if(method.equals("size")) {
				System.out.println(q.size());
			} 
			
			else if(method.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} 
			
			else if(method.equals("front")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(q.peek());
				}
			}
			
			else if(method.equals("back")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(last);
				}
			}
		}
	}
}