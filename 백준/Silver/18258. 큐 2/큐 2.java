import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				dq.add(num);
			}
			else if(command.equals("pop")) {
				if(dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.pollFirst()+"\n");
			}
			else if(command.equals("size")) sb.append(dq.size()+"\n");
			else if(command.equals("empty")) {
				if(dq.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else if(command.equals("front")) {
				if(dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.peekFirst()+"\n");
			}
			else if(command.equals("back")) {
				if(dq.isEmpty()) sb.append(-1+"\n");
				else sb.append(dq.peekLast()+"\n");
			}
		}
		System.out.println(sb);
		
	}//end main
}
