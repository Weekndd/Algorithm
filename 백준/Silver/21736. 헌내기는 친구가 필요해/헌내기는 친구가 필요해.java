import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				if(str.charAt(j)=='I') {
					que.offer(new int[] {i,j});
					visited[i][j] = true;
				} else {
					map[i][j] = str.charAt(j);
				}
			}
		}
		int[] dirR = new int[] {0,0,1,-1};
		int[] dirC = new int[] {1,-1,0,0};
		
		int res = 0;
		while(!que.isEmpty()) {
			int[] now = que.poll();
			for(int d=0; d<4; d++) {
				int nextR = now[0]+dirR[d];
				int nextC = now[1]+dirC[d];
				if(nextR<0 || nextR>=N || nextC<0 || nextC>=M) continue; //경계
				if(map[nextR][nextC]=='X') continue; //벽
				if(visited[nextR][nextC]) continue; //기방문
				if(map[nextR][nextC]=='P') res++; //사람
				visited[nextR][nextC] = true;//방문체크
				que.offer(new int[] {nextR, nextC});
			}
		}
		System.out.println(res==0 ? "TT" : res);
	} //end main
}
