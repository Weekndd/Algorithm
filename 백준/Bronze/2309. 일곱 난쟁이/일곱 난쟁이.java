import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];
		int A = 0;
		int B = 0;
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		loop:
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i==j) {
					continue;
				}
				A = arr[i];
				B = arr[j];
				if(sum-A-B == 100) {
					A=i;
					B=j;
					break loop;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i == A || i== B) {
				continue;
			}
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
		
	}//end main
}