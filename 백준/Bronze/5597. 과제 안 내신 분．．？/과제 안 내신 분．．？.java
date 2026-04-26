import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[31];
		
		
		
		for(int i=1; i<=28; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] == false) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	}
}