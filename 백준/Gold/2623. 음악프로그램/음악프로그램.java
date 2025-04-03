import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        
        List<Integer>[] arr = new LinkedList[N+1];
        for(int i=0; i<=N; i++) arr[i] = new LinkedList<>();
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int pre = Integer.parseInt(st.nextToken());
        	for(int j=1; j<n; j++) {
        		int v = Integer.parseInt(st.nextToken());
        		arr[pre].add(v);
        		pre = v;
        		if(j>0) indegree[v]++;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        Queue<Integer> que = new LinkedList();
        for(int i=1; i<=N; i++) {
        	if(indegree[i]==0) {
        		que.offer(i);
        		cnt++;
        	}
        }
        
        while(!que.isEmpty()) {
        	int now = que.poll();
        	sb.append(now+"\n");
        	for(int i=0; i<arr[now].size(); i++) {
        		int next = arr[now].get(i);
        		if(--indegree[next]==0) {
        			que.offer(next);
        			cnt++;
        		}
        	}
        }
        System.out.println(cnt==N ? sb : 0);
    }//end
}