import java.io.*;
import java.util.*;

public class Main {
	static int R, C, N;
	static int[] dirR = new int[] {0,0,1,-1};
	static int[] dirC = new int[] {1,-1,0,0};
	static class Boom {
		int r,c,sec;
		Boom(int sec, int r, int c) {
			this.sec = sec;
			this.r =r;
			this.c=c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Boom[][] map = new Boom[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				if(str.charAt(j)=='O') map[i][j] = new Boom(0,i,j); //0
			}
		}
		nextSec(map); // 1
		for(int time=1; time<N; time++) {
			if(time%2==1) {
				setUp(map);
				nextSec(map); // 2
			} else if(time%2==0) {
				explosion(map); 
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				Boom boom = map[i][j];
				if(boom==null) System.out.print(".");
				else System.out.print("O");
			}
			System.out.println();
		}
	} //end main
	
	public static void nextSec(Boom[][] map) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				Boom boom = map[i][j];
				if(boom!=null) boom.sec++;
			}
		}
	}
	public static void explosion(Boom[][] map) {
		ArrayList<Boom> boomList = new ArrayList<>();
		//터질 폭탄 찾기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				Boom boom = map[i][j];
				if(boom!=null && boom.sec==2)boomList.add(boom);
			}
		}
		// 폭탄들 터짐
		for(int i=0; i<boomList.size(); i++) {
			Boom boom = boomList.get(i);
			map[boom.r][boom.c] = null;
			for(int d=0; d<4; d++) {
				int nextR = dirR[d] + boom.r;
				int nextC = dirC[d] + boom.c;
				if(nextR<0 || nextR>=R || nextC<0 || nextC>=C) continue;
				map[nextR][nextC] = null;
			}
		}
	}
	
	public static void setUp(Boom[][] map) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==null) map[i][j] = new Boom(0,i,j);
			}
		}
	}
	
}
