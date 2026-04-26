import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		int sum = Integer.MAX_VALUE;
		
		while(st.hasMoreTokens()) {
			StringTokenizer additional = new StringTokenizer(st.nextToken(),"+");
			int temp = 0;
			
			while(additional.hasMoreTokens()) {
				int addNum = Integer.parseInt(additional.nextToken());
				temp += addNum; 
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = temp;
			}
			else {
				sum -=temp;
			}
		}
		
		System.out.println(sum);
		
		
		
		
	}//end main
}