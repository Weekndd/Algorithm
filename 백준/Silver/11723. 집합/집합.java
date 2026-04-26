import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		Set<Integer> set = new HashSet<>();
		Integer[] arr = new Integer[20];
		for(int i=0;i<arr.length;i++) arr[i] = i+1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			
			if(command.equals("all")) {
				Collections.addAll(set, arr);
			}
			else if(command.equals("empty")){
				set.clear();
			}
			
			else {
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("add")) {
					set.add(num);
				}
				else if(command.equals("remove")) {
					set.remove(num);
				}
				else if(command.equals("check")) {
					if(set.contains(num)) {
						sb.append(1+"\n");
					}
					else {
						sb.append(0+"\n");
					}
				}
				else if(command.equals("toggle")) {
					if(set.contains(num)) {
						set.remove(num);
					}
					else {
						set.add(num);
					}
				}
				
			}
		}
		System.out.println(sb);
		
		
		
	}//end main
}