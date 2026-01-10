import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			list.add(str);
		}
		int count = 0;
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				String target = list.get(j);
				boolean flag = false;
				int start = 0;
				int end = str.length()-1;
				
				if(str.length()>target.length()) break;
				
				for(int k=0; k<str.length()/2; k++) {
					if(str.charAt(start)==target.charAt(start) 
							&& str.charAt(end) == target.charAt(end)) {
						start = start+1;
						end = end-1;
						continue;
					}
					else {
						flag = true;
						break;
					}
				}
				if(!flag) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}//end main
}
