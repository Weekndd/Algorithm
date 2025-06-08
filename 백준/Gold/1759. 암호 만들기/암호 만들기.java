import java.io.*;
import java.util.*;

import javax.xml.stream.events.Characters;

public class Main {
	private static int N;
	private static int M;
	private static String[] arr;
	private static String[] depthArr;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new String[N];
		depthArr = new String[M];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = st.nextToken();
		}
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb);
	}//end main
	
	private static void dfs(int depth, int at) {
		if(depth == M) {
			int vowelCount = 0;
			int consCount = 0;
			for(String i : depthArr) {
				if(i.equals("a") || i.equals("e") || i.equals("i") || i.equals("o") || i.equals("u")) {
					vowelCount++;
				}
				else {
					consCount++;
				}
			}
			if(!(vowelCount>0 && consCount>1)) {
				return;
			}
			for(String i : depthArr) {
				sb.append(i);
			}
			sb.append("\n");
			return;
		}
		for(int i=at; i<N; i++) {
			depthArr[depth] = arr[i];
			dfs(depth+1,i+1);
		}
		
	}//end dfs
}