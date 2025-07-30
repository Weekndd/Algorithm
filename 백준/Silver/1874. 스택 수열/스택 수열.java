import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count  = 1;
		Stack<Integer> stack = new Stack<>();
		
		int i = 0;
		while(i<=N) {
			if(count>=arr.length) {
				break;
			}
			if(stack.isEmpty() || arr[count] != stack.peek()) {
				i++;
				stack.push(i);
				sb.append("+\n");
			}
			
			else {
				count++;
				stack.pop();
				sb.append("-\n");
			}
			
		}//end while
		
		if(!stack.isEmpty()) {
			System.out.println("NO");
		}
		else {
			System.out.println(sb);
		}
	}
}