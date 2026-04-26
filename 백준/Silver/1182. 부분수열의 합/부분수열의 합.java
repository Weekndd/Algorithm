import java.io.*;
import java.util.*;

import javax.xml.stream.events.Characters;

public class Main {
	private static int N;
	private static int S;
	private static int count = 0;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//end input
		dfs(0,0);
		if(S == 0) System.out.println(count-1);
		else System.out.println(count);
	}//end main
	
	private static void dfs(int depth, int sum) {
		if(depth == N) {
			if(sum == S) {
				count++;
			}
			return;
		}
		dfs(depth+1, sum + arr[depth]);
		dfs(depth+1, sum);
	}//end dfs
}