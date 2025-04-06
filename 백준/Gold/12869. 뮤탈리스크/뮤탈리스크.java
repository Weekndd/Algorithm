import java.util.*;
import java.io.*;

public class Main {
	public static class Group implements Comparable<Group>{
		int A,B,C,total,cnt;
		Group(int A, int B, int C, int total, int cnt) {
			this.A = A;
			this.B = B;
			this.C = C;
			this.total = total;
			this.cnt = cnt;
		}
		public int compareTo(Group o1) {
			if(this.cnt==o1.cnt) {
				return this.total - o1.total;
			}
			else {
				return this.cnt - o1.cnt;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
		int C = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;
		int[][][] dp = new int[A+1][B+1][C+1];
		dp[A][B][C] = 1;
		PriorityQueue<Group> pq = new PriorityQueue<>();
		pq.offer(new Group(A,B,C,A+B+C,0));
		int[][] attacks = {
				{9,3,1},{9,1,3},
				{3,9,1},{3,1,9},
				{1,3,9},{1,9,3}
		};
		
		int ans = 0;
		while(!pq.isEmpty()) {
			Group now = pq.poll();
			if(now.total<=0) {
				System.out.println(now.cnt);
				break;
			}
			int min = Integer.MAX_VALUE;
			for(int i=0; i<6; i++) {
				int a = now.A-attacks[i][0] <= 0 ? 0 : now.A-attacks[i][0];
				int b = now.B-attacks[i][1] <= 0 ? 0 : now.B-attacks[i][1];
				int c = now.C-attacks[i][2] <= 0 ? 0 : now.C-attacks[i][2];
				if(dp[a][b][c]==0 && min>=a+b+c) {
					min = a+b+c;
					pq.offer(new Group(a,b,c,(a+b+c),now.cnt+1));
					dp[a][b][c] = 1;
				}
			}
		}//end while
	}//end main
}
