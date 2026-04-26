import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String method = st.nextToken();
			if(method.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
				
			} 
			else if(method.equals("pop")) {
				if(stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
			}
			else if(method.equals("size")) {
				System.out.println(stack.size());
			}
			else if(method.equals("empty")) {
				if(stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
			else if(method.equals("top")) {
				if(stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
			}
			
		}//end for
		
	}
}