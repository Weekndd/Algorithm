import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	static int R=12,C=6;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int res = 0;
		while(true) {
			if(!boom()) break;
			collapsed();
			res++;
		}
		System.out.println(res);
	} //end main
	
	//연쇄작용
	public static boolean boom() {
		boolean flag = false;
		boolean[][] visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='.' || visited[i][j]) continue;
				visited[i][j] = true;
				ArrayList<int[]> sameColors = check(i,j,visited);
				if(sameColors.size()>=4) {
					flag = true;
					for(int k=0; k<sameColors.size(); k++) {
						int[] chain = sameColors.get(k);
						map[chain[0]][chain[1]] = '.';
					}
				}
			}
		}
		return flag;
	}
	//4개이상 붙어있는지 확인
	public static ArrayList<int[]> check(int r, int c, boolean[][] visited) {
		LinkedList<int[]> que = new LinkedList<>();
		ArrayList<int[]> sameColors = new ArrayList<>();
		sameColors.add(new int[] {r,c});
		char color = map[r][c];
		que.offer(new int[] {r,c});
		while(!que.isEmpty()) {
//			System.out.println("dd");
			int[] now = que.poll();
			for(int d=0; d<4; d++) {
				int nextR = now[0] + dirR[d];
				int nextC = now[1] + dirC[d];
				if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) continue;
				if(visited[nextR][nextC]) continue;
				if(map[nextR][nextC] == color) {
					que.offer(new int[] {nextR, nextC});
					sameColors.add(new int[] {nextR, nextC});
					visited[nextR][nextC] = true;
				}
			}
		}
		return sameColors;
	}
	//빈공간 채워줌
	public static void collapsed() {
		for(int i=R-2; i>=0; i--) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='.') continue;
				char color = map[i][j];
				Queue<int[]> que = new LinkedList<>();
				que.offer(new int[] {i,j});
				boolean flag = false;
				while(!que.isEmpty()) {
					int[] now = que.poll();
					int nextR = now[0]+1;
					int nextC = now[1];
					if(nextR>=R || map[nextR][nextC]!='.') {
						if(!flag) continue;
						map[now[0]][now[1]] = color;
						map[i][j] = '.';
					} else {
						flag = true;
						que.offer(new int[] {nextR, nextC});
					}
				}
			}
		}
	}
}
