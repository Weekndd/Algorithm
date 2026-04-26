import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for(int i=4; i<=100; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		for(int i=0; i<T; i++) {
			sb.append(arr[Integer.parseInt(br.readLine())]+"\n");
		}
		System.out.println(sb);
	}//end main
}