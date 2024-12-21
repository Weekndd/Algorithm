import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static boolean[][] fireCheck, check;
	static List<int[]> fireList = new ArrayList<>();
	static int R, C;
	static int[] jihoon = new int[2];
	static int[] dirR = new int[] {0,0,-1,1}, dirC = new int[] {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[R][C];
		fireCheck = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				if(c=='J') {
					jihoon[0] = i;
					jihoon[1] = j;
				}
				else if(c=='F') fireList.add(new int[] {i,j});
				map[i][j] = c;
			}
		}//end input
		int time = move();
		System.out.println(time==0?"IMPOSSIBLE":time);
	}//end main
	
	public static int move() {

		Queue<int[]> que = new LinkedList<>();
		int time = -1;
		que.offer(new int[] {jihoon[0], jihoon[1], 0});
		
		check[jihoon[0]][jihoon[1]] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if(time!=now[2]) {
				spreadFire();
				time++;
			}
			
			for(int d=0; d<4; d++) {
				int nr = now[0]+dirR[d];
				int nc = now[1]+dirC[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) return now[2]+1;
				if(check[nr][nc]) continue; //이미 방문했던 곳이면 패스
				if(map[nr][nc]=='F' || map[nr][nc]=='#') continue; //불 이거나 벽이면 패스
				check[nr][nc] = true;
				que.offer(new int[] {nr,nc,now[2]+1});
				map[nr][nc] = 'J';
			}
		}
		return 0;
	}
	public static void spreadFire() {
		List<int[]> nextFire = new ArrayList<>();
		for(int[] fire : fireList) {
			for(int d=0; d<4; d++) {
				int nr = fire[0]+dirR[d];
				int nc = fire[1]+dirC[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(map[nr][nc]=='#') continue;
				if(fireCheck[nr][nc]) continue;
				fireCheck[nr][nc] = true;
				nextFire.add(new int[] {nr,nc});
			}
		}
		for(int[] fire: nextFire) {
			map[fire[0]][fire[1]] = 'F';
		}
		fireList = nextFire;
	}//end spreadFire
}
