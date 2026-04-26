import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[1001];
		arr[1] = 1;
		arr[2] = 3;
		for(int i=3; i<=1000; i++) {
			arr[i] = (arr[i-1] + (arr[i-2]*2))%10007;
		}
		System.out.println(arr[N]);
	}//end main
}