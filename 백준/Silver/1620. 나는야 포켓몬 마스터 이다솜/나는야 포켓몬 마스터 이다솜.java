import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			map.put(String.valueOf(i),name);
			map.put(name,String.valueOf(i));
		}
		//end input
		for(int i=0; i<T; i++) {
			String res = br.readLine();
			sb.append(map.get(res)+"\n");
		}//end Test
		System.out.println(sb);
	
	}//end main
}