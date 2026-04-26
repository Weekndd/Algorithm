import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] road = new long[N-1];
		long[] city = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			road[i] = Long.parseLong(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			city[i] = Long.parseLong(st.nextToken());
		}
		//end input
		
		long total_cost = city[0]*road[0];
		long min = city[0];
		for(int i=1; i<road.length; i++) {
			
			if(city[i]<min) {
				min = city[i];
			}
			total_cost += min * road[i];
		}
		System.out.println(total_cost);
		
	}//end main
}