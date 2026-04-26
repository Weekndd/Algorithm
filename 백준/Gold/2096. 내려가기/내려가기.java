import java.util.*;
import java.io.*;

public class Main {
	static int N,target,gap;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] maxDp = new int[3];
		int[] minDp = new int[3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x0 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			if(i==0) {
				maxDp[0] = minDp[0] = x0;
				maxDp[1] = minDp[1] = x1;
				maxDp[2] = minDp[2] = x2;
			}
			else {
				int beforeMaxDp_0 = maxDp[0];
				int beforeMaxDp_2 = maxDp[2]; 
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + x0; 
				maxDp[2] = Math.max(maxDp[1], maxDp[2]) + x2; 
				maxDp[1] = Math.max(Math.max(beforeMaxDp_0, beforeMaxDp_2), maxDp[1]) + x1;
				
				int beforeMinDp_0 = minDp[0];
				int beforeMinDp_2 = minDp[2]; 
				minDp[0] = Math.min(minDp[0], minDp[1]) + x0; 
				minDp[2] = Math.min(minDp[1], minDp[2]) + x2; 
				minDp[1] = Math.min(Math.min(beforeMinDp_0, beforeMinDp_2), minDp[1]) + x1;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.max(Math.max(maxDp[0], maxDp[1]),maxDp[2])).append(" ");
		sb.append(Math.min(Math.min(minDp[0], minDp[1]),minDp[2]));
		System.out.println(sb);
		
		//end input
		
	}//end main
}
