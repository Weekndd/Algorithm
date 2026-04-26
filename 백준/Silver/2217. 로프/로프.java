import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[K];
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int max = 0;
		for(int i=0; i<K; i++) {
			if(arr[i]*(arr.length-i)>max) {
				max = arr[i]*(arr.length-i);
			}
		}
		System.out.println(max);
		
	}//end main
}