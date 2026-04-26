import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//bfs
		boolean[] visited = new boolean[100001];
		Queue<Integer> que = new LinkedList<>();
		que.offer(N);
		visited[N] = true;
		int[] arr = new int[100001];
		arr[N] = 0;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			if(num == K) {
				break;
			}
			
			if(num-1>=0 && visited[num-1] != true) {
				arr[num-1] = arr[num]+1;
				que.offer(num-1);
				visited[num-1] =true;
			}
			if(num+1<arr.length && visited[num+1]!=true) {
				arr[num+1] = arr[num]+1;
				que.offer(num+1);
				visited[num+1] = true;
			}
			if(num*2<arr.length && visited[num*2]!=true) {
				arr[num*2] = arr[num]+1;
				que.offer(num*2);
				visited[num*2] = true;
			}

		}
		System.out.println(arr[K]);
		
	}//end Main	
}