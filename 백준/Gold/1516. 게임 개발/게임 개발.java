import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] outdegree = new ArrayList[N+1];
		int[] indegree = new int[N+1];
		int[] time = new int[N+1];
		for(int i=0; i<=N; i++) outdegree[i] = new ArrayList<Integer>();
		for(int idx=1; idx<=N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[idx] = Integer.parseInt(st.nextToken());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) break;
				outdegree[num].add(idx);
				indegree[idx]++;
			}
		}
		//end input
		int[] ans = new int[N+1];
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0) {
				que.offer(i);
				ans[i] = time[i];
			}
		}
		while(!que.isEmpty()) {
			int ver = que.poll();
			for(int i=0; i<outdegree[ver].size(); i++) {
				int next = outdegree[ver].get(i);
				indegree[next]--;
				if(indegree[next]==0) {
					que.offer(next);
					indegree[next] = -1;
				}
				ans[next] = Math.max(ans[next], ans[ver]+time[next]);
			}
		}//end while
		for(int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
	}//end main
}
