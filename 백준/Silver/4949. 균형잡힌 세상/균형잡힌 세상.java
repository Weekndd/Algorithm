import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals(".")) {
				break;
			}
			char[] arr = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(char c: arr) {
				if(c=='(' || c=='[') {
					stack.push(c);
				}
				else if(c==')') {
					if(!stack.empty() && stack.peek()=='(') {
						stack.pop();
					} 
					else {
						stack.push(c);
					}
				}
				else if(c==']') {
					if(!stack.empty() && stack.peek()=='[') {
						stack.pop();
					} 
					else {
						stack.push(c);
					}
				}
			}
			if(!stack.empty()) {
				sb.append("no\n");
			}
			else {
				sb.append("yes\n");
			}
			
		}//end while
		System.out.println(sb);
		
		
		
	}
}