import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int s = Integer.parseInt(st.nextToken());
    	int e = Integer.parseInt(st.nextToken());
    	
    	List<Integer>[] list = new ArrayList[N+1];
    	for(int i=0; i<=N; i++) {
    		list[i] = new ArrayList<>();
    	}
    	int M = Integer.parseInt(br.readLine());
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		list[a].add(b);
    		list[b].add(a);
    	}
    	
    	boolean[] check = new boolean[N+1];
    	Queue<int[]> que = new LinkedList<>();
    	que.offer(new int[] {s,0});
    	check[s] = true;
    	int ans = -1;
    	while(!que.isEmpty()) {
    		int[] now = que.poll();
    		if(now[0]==e) {
    			ans = now[1];
    			break;
    		}
    		for(int i=0; i<list[now[0]].size(); i++) {
    			int next = list[now[0]].get(i);
    			if(check[next]) continue;
    			check[next] = true;
    			que.offer(new int[] {next, now[1]+1});
    		}
    	}
    	System.out.println(ans);
    }//end main
}