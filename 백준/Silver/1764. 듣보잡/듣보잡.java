import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<>();
		ArrayList<String> res = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		int count = 0;
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(set.contains(name)){
				res.add(name);
				count++;
			}
		}
		//정렬 및 출력
		Collections.sort(res);
		for(String s : res) {
			sb.append(s+"\n");
		}
		System.out.println(count+"\n"+sb);
		
	}//end main
}