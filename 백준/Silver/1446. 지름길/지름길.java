import java.util.*;
import java.io.*;

public class Main {
	public static class Road implements Comparable<Road>{
		int a, b, d;
		Road(int a, int b, int d) {
			this.a = a;
			this.b = b;
			this.d = d;
		}
		public int compareTo(Road o1) {
			if(this.a == o1.a) {
				return this.b - o1.b;
			}
			else return this.a - o1.a;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Road[] roads = new Road[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			roads[i] = new Road(a,b,d);
		}
		
		int[] dp = new int[10000];
		for(int i=0; i<10000; i++) {
			dp[i] = i;
		}
		Arrays.sort(roads);
		dp[0] = 0;
		for(Road road : roads) {
			int a = road.a;
			int b = road.b;
			int d = road.d;
			
			if(dp[b] > dp[a]+d) {
				dp[b] = dp[a]+d;
				int cnt = 1;
				for(int j=b+1; j<=D; j++) {
					dp[j] =  Math.min(dp[j], dp[b]+cnt);
					cnt++;
				}
			}
		}
		System.out.println(dp[D]);
	}//end main
}
