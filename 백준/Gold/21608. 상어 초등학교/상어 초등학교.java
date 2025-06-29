import java.util.*;
import java.io.*;

public class Main {
	static Set[] set;
	static int N;
	static int[][] map;
	static int[] dirR = new int[] {0,0,-1,1};
	static int[] dirC = new int[] {-1,1,0,0};
	static class Seat {
		int bestFriend, empty, r, c;
		Seat(int bestFriend, int empty, int r, int c) {
			this.bestFriend = bestFriend;
			this.empty = empty;
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		set = new HashSet[N*N+1];
		for(int i=1; i<=N*N; i++) set[i] = new HashSet<>();
		int[] seq = new int[N*N+1]; //학생 순서
		for(int i=1; i<=N*N; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			int stu = Integer.parseInt(st.nextToken());
			seq[i] = stu;
			for(int j=0; j<4; j++) {
				set[stu].add(Integer.parseInt(st.nextToken()));
			}
		}
		map = new int[N+1][N+1];
		for(int i=1; i<=N*N; i++) {
			int student = seq[i];
			Seat seat = findSeat(student);
			map[seat.r][seat.c] = student;
		}
		
		int total = calculate();
		System.out.println(total);
	}//end main
	static public int calculate() {
		
		int total = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				int stu = map[i][j];
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int nr = i+dirR[d];
					int nc = j+dirC[d];
					if(nr>N || nr<=0 || nc>N || nc<=0) continue;
					int friend = map[nr][nc];
					if(set[stu].contains(friend)) cnt++;
				}
				if(cnt==1) total += 1;
				else if(cnt==2) total += 10;
				else if(cnt==3) total += 100;
				else if(cnt==4) total += 1000;
			}
		}
		return total;
	}
	static public Seat findSeat(int student) {
		Seat seat = new Seat(-1,-1,N,N);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				//이미 선점 당했으면 패스
				if(map[i][j]!=0) continue;
				int nowR = i;
				int nowC = j;
				int empty = 0;
				int bestFriend = 0;
				for(int d=0; d<4; d++) {
					int nr = nowR+dirR[d];
					int nc = nowC+dirC[d];
					if(nr>N || nr<=0 || nc>N || nc<=0) continue;
					int friend = map[nr][nc];
					if(friend==0) empty++;
					else if(set[student].contains(friend)) bestFriend++;
				}
				if(seat.bestFriend<bestFriend) {
					seat = new Seat(bestFriend, empty, i, j);
				}
				else if(seat.bestFriend==bestFriend) {
					if(seat.empty<empty) {
						seat = new Seat(bestFriend, empty, i, j);
					}
					else if(seat.empty==empty) {
						
					}
				}
			}
		}
		return seat;
	}
}
