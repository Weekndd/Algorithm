import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map = new int[101];
		int[] res = new int[101];
		boolean[] visited = new boolean[101];
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		//end input 
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			if(now == 100) {
				System.out.println(res[now]);
				break;
			}
			for(int i=1; i<=6; i++) {
				int next = now+i;
				if(next > 100) continue;
				if(visited[next]) continue;
				
				visited[next] = true;
				if(map[next] != 0) {
					if(!visited[map[next]]) {
						que.offer(map[next]);
						visited[map[next]] = true;
						res[map[next]] = res[now] + 1;
					}
				}
				else {
					que.offer(next);
					res[next] = res[now] + 1;
				}
			}
		}
	}//end main
}