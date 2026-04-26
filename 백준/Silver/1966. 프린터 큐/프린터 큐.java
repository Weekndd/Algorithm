import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int length = Integer.parseInt(st.nextToken());
			int findNum = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine()," ");
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int j=0; j<length; j++) {
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			int count = 0;
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean isMax = true;
				
				for(int j=0; j<q.size(); j++) {
					
					if(front[1] < q.get(j)[1]) {
						q.offer(front);
						
						for(int k=0; k<j; k++) {
							q.offer(q.poll());
						}
						isMax = false;
						break;
					}
				}
				if(isMax == false) {
					continue;
				}
				
				count++;
				if(front[0] == findNum) {
					break;
				}
			}
			System.out.println(count);
		}//end count
		
	}
}