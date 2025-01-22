import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //도시 수
		int M = Integer.parseInt(st.nextToken()); //여행일수
		int[] destination = new int[M];
		
		int[][] cost = new int[N+1][3];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			destination[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=2; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[] route = new int[N+1];
		int start = destination[0];
		for(int i=1; i<M; i++) {
			int des = destination[i];
			if(start<des) {
				for(int j=start; j<des; j++) {
					route[j+1]++;
				}
			}
			else {
				for(int j=start; j>des; j--) {
					route[j]++;
				}	
			}
			start = des;
		}
		long sum = 0;
		for(int i=1; i<=N; i++) {
			int A = route[i] * cost[i][0];
			int B = route[i] * cost[i][1] + cost[i][2];
			sum += Math.min(A,B);
		}
		System.out.println(sum);
	}//end main
}
