import java.util.*;
import java.io.*;

public class Main {
	static int R, C, arr[][], roomCnt, maxWidth, maxWidthByBreak;
	static int[] dirR = new int[] {0,-1,0,1};
	static int[] dirC = new int[] {-1,0,1,0};
	static int sr, sc;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//end input
		
		boolean[][] check = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(check[i][j]) continue;
				sr = i;
				sc = j;
				roomCnt++;
				check[i][j] = true;
				int res = findSpace(i,j,0,check);				
				maxWidthByBreak = Math.max(maxWidthByBreak, res);
			}
		}
		System.out.println(roomCnt);
		System.out.println(maxWidth);
		System.out.println(maxWidthByBreak);
		
	}//end main
	
	public static int findSpace(int r, int c, int isBreak, boolean[][] check) {
		int max = 0;
		int res = 1;
		
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {r,c}); //R,C,벽뿌횟수
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			if(isBreak==1 && now[0]==sr && now[1]==sc) return 0;
			int num = arr[now[0]][now[1]];
			//사방확인
			for(int d=0; d<4; d++) {
				int nr = now[0]+dirR[d];
				int nc = now[1]+dirC[d];
				if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
				if(check[nr][nc]) continue;
				if((num & (1<<d))!=0) {//벽인 경우
					if(isBreak==1) continue; //이미 벽을 부셨으면 패스
					//기존 배열 복사
					boolean[][] newCheck = new boolean[R][C];
					newCheck[nr][nc] = true;
					max = Math.max(max,findSpace(nr,nc,1,newCheck));
				}
				else { //벽이 아니면
					check[nr][nc] = true;
					res++;
					que.offer(new int[] {nr, nc});
				}
			}
		}//end while
		maxWidth = Math.max(maxWidth,res);
		res += max;
		return res;
	}
}