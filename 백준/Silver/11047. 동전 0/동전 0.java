import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[Integer.parseInt(st.nextToken())];
		int money = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		while(money!=0) {
			for(int i=arr.length-1; i>=0; i--) {
				if(money >= arr[i]) {
					money -= arr[i];
					count++;
					break;
				}
			}
			
		}
		System.out.println(count);
		
		
	
	}//end main
}