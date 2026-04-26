import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		int num = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String method = st.nextToken();
			if(method.equals("push_back")) {
				num = Integer.parseInt(st.nextToken());
				d.offerLast(num);
			}
			else if(method.equals("push_front")) {
				num = Integer.parseInt(st.nextToken());
				d.offerFirst(num);
			}
			else if(method.equals("pop_front")) {
				if(d.isEmpty()) {
					System.out.println(-1);
				} 
				else {
					System.out.println(d.pollFirst());
				}
			}
			else if(method.equals("pop_back")) {
				if(d.isEmpty()) {
					System.out.println(-1);
				} 
				else {
					System.out.println(d.pollLast());
				}
			}
			else if(method.equals("size")) {
				System.out.println(d.size());
			}
			else if(method.equals("empty")) {
				if(d.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			else if(method.equals("front")) {
				if(d.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(d.peekFirst());
				}
			}
			else if(method.equals("back")) {
				if(d.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(d.peekLast());
				}
			}
		}
	
	}
}