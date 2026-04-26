import java.io.*;
import java.util.*;

public class Main {
	static int N,M,cnt;
	static int[] dirR = new int[]{-1,0,1};
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		//end input
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			if(findWay(i,0,0)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static public boolean findWay(int nowR, int nowC, int depth) {
		if(depth == M-1) {
			return true;
		}
		for(int i=0; i<3; i++) {
			int nextR = nowR + dirR[i];
			int nextC = nowC + 1;
			if(nextR<0 || nextR>=N || nextC<0 || nextC>=M) continue;
			if(map[nextR][nextC]!='x' && !visited[nextR][nextC]) {
				map[nextR][nextC] = 'o';
				visited[nextR][nextC] = true;
				if(findWay(nextR,nextC,depth+1)) {
					return true;
				}
			}
		}
		return false;
	}
}