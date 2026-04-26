import java.io.*;
import java.util.*;

import javax.xml.stream.events.Characters;

public class Main {
	private static int N;
	private static String[] arr;
	private static String[] depthArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			arr = new String[N];
			depthArr = new String[6];
			for(int i=0; i<N; i++) {
				arr[i] = st.nextToken();
			}
			//end input
			dfs(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}//end main
	
	private static void dfs(int depth, int at) {
		if(depth == 6) {
			for(String i : depthArr) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<N; i++) {
			depthArr[depth] = arr[i];
			dfs(depth+1, i+1);
		}
	}//end dfs
}