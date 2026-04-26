import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int r = 0;
		int l = 0;
		
		int pre = 0;
		for(int i=0; i<N; i++) {
			if(pre<arr[i]) {
				pre = arr[i];
				r++;
			}
		}
		pre = 0;
		for(int i=N-1; i>=0; i--) {
			if(pre<arr[i]) {
				pre = arr[i];
				l++;
			}
		}
		System.out.println(r+"\n"+l);
	}//end main
}
