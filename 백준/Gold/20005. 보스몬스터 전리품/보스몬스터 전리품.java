import java.util.*;
import java.io.*;

public class Main {
	static int R, C, P, monster[];
	static char arr[][];
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				char c = str.charAt(j);
				arr[i][j] = c;
				if(c == 'B') {
					monster = new int[] {i,j}; 
				}
			}
		}
		
		Map<Integer,Integer> playerDps = new HashMap<Integer,Integer>();
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			char name = st.nextToken().charAt(0);
			int dps = Integer.parseInt(st.nextToken());
			playerDps.put(name-97, dps);
		}
		int monsterHp = Integer.parseInt(br.readLine());
		//end input 
		
		int[] playerArrive = new int[26];
		Arrays.fill(playerArrive,-1);
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if('a'<=arr[i][j] && arr[i][j]<='z') {
					int time = findMonster(i,j);
					playerArrive[arr[i][j]-'a'] = time;
				}
			}
		}
		//먼저 도착한 순으로 보스 처치
		int playerCnt = 0;
		int dps = 0;
		while(true) {
			if(monsterHp < 0) break;
			for(int i=0; i<26; i++) {
				if(playerArrive[i]==0) {
					playerCnt++;
					dps += playerDps.get(i);
					playerArrive[i] = -1;
				}
				else if(playerArrive[i]>0) playerArrive[i]--;
			}
			monsterHp -= dps;
		}
		System.out.println(playerCnt);
	}//end main
	public static int findMonster(int r, int c) {
		boolean[][] check = new boolean[R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c,0});
		check[r][c] = true;
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if(now[0]==monster[0] && now[1]==monster[1]) {
				return now[2];
			}
			for(int d=0; d<4; d++) {
				int nr = now[0]+dirR[d];
				int nc = now[1]+dirC[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(arr[nr][nc]=='X') continue;
				if(check[nr][nc]) continue;
				check[nr][nc] = true;
				que.offer(new int[] {nr,nc,now[2]+1});
			}
		}
		return -1;
	}
}
