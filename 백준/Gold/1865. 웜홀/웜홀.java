import java.util.*;
import java.io.*;

public class Main {
	public static class Node {
		int E, T;
		public Node(int E, int T) {
			this.E = E;
			this.T = T;
		}
	}
	static int N, M, W, INF=1000000000;
	static List<Node>[] roads;
	static List<Node>[] wormholes;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			roads = new ArrayList[N+1];
			//도로초기화
			for(int i=1; i<=N; i++) roads[i] = new ArrayList<>();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				roads[S].add(new Node(E,T));
				roads[E].add(new Node(S,T));
			}
			
			 for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                roads[S].add(new Node(E, -T));
            } //end input
			
			boolean flag = false;
			for(int i=1; i<=N; i++) {
				if(bellmanFord(i)) {
					flag = true;
					break;
				}
			}
			if(flag)sb.append("YES\n");
			else sb.append("NO\n");
		}//end TC
		System.out.println(sb);
	}//end main
	
	public static boolean bellmanFord(int start) {
		int[] dis = new int[N+1];
		Arrays.fill(dis,INF);
		dis[start] = 0;
		boolean update = false;
		
		for(int i=1; i<N; i++) { //정점의 개수 -1번 동안 최단거리 초기화 작업을 반복
			update = false;
			
			for(int j=1; j<=N; j++ ) {
				for(Node node : roads[j]) {
					if(dis[j] != INF && dis[node.E]>dis[j]+node.T) {
						dis[node.E] = dis[j]+node.T;
						update = true;
					}
				}
			}
			//최단거리 갱신이 일어나지 않은 경우
			if(!update) break;
		}
		
		if(update) {
			for(int i=1; i<=N; i++) {
				for(Node node : roads[i]) {
					if(dis[i]!=INF && dis[node.E]>dis[i]+node.T) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
