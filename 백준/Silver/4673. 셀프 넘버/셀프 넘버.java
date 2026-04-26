import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] arr = new boolean[10001];
		
		
		for(int i=1; i<arr.length; i++) {
			String str = String.valueOf(i);
			
			int res = Integer.parseInt(str);
			for(int j=0; j<str.length(); j++) {
				int num = Integer.parseInt(String.valueOf(str.charAt(j)));
				res += num;
			}
			if(res>10000) {
				continue;
			}
			arr[res] = true;
		}
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == false) {
				sb.append(i+"\n");
			}
		}
		System.out.println(sb);
	}//end main
}