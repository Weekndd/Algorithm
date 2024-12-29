import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int S,E,COST;
		Node(int S, int E, int COST) {
			this.S = S;
			this.E = E;
			this.COST = COST;
		}
	}
	static int N, M, START, END, money[];
	static long dis[];
	static int INF = -1000000000;
	static ArrayList<Node>[] list;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N];
		for(int i=0; i<N; i++) list[i] = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Node(s,e,c));
		}
		st = new StringTokenizer(br.readLine());
		money = new int[N];
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}//end input
		
		if(!BFS(START, END)) { //START와 END가 연결되지 않으면 바로 GG
			System.out.println("gg");
		}
		else if(bellmanFord()) {
			System.out.println("Gee");
		}
		else {
			System.out.println(dis[END]);
		}
	}//end main
	public static boolean bellmanFord() {
		dis = new long[N];
		Arrays.fill(dis,INF);
		dis[START] = money[START];
		boolean update = false;
		for(int i=0; i<N; i++) {
			update =false;
			for(int j=0; j<N; j++) {
				for(Node next : list[j]) {
					if(dis[j]==INF || dis[next.E]>=dis[j]-next.COST+money[next.E]) continue;
					dis[next.E] = dis[j]-next.COST+money[next.E];
					update = true;
				}
			}
			if(!update) break;
		}
		List<Integer> cycleList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(Node next : list[i]) {
				if(dis[i]==INF || dis[next.E]>=dis[i]-next.COST+money[next.E]) continue;
				cycleList.add(i);
				cycleList.add(next.E);
			}
		}
		//사이클 리스트에 도착지점과 시작지점이 있는지 확인
		for(int start : cycleList) {
			if(BFS(start, END)) { //사이클에 포함되면 무한히 돈을 벌 수 있음
				return true;
			}
		}
		//사이클 리스트에 포함되지 않으면 사이클 노드들을 지우고 최단거리 구하기
		Arrays.fill(dis,INF);
		dis[START] = money[START];
		for(int i=0; i<N-1; i++) {
			update =false;
			for(int j=0; j<N; j++) {
				for(Node next : list[j]) {
					if(cycleList.contains(j) || dis[j]==INF) break;
					if(cycleList.contains(next.E) || dis[next.E]>=dis[j]-next.COST+money[next.E]) continue;
					dis[next.E] = dis[j]-next.COST+money[next.E];
					update = true;
				}
			}
			if(!update) break;
		}
		return false;
	}
	
	static boolean BFS(int start, int end) {
		if(start==end) return true;
		Queue<Integer> que = new LinkedList<>();
		boolean check[] = new boolean[N];
		que.offer(start);
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(Node next : list[now]) {
				if(check[next.E]) continue;
				if(next.E == end) return true;
				check[next.E] = true;
				que.offer(next.E);
			}
		}
		return false;
	}
}
