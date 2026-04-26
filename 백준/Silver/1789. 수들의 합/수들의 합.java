import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long count = 0;
		long sum = 0;
		while(sum<N) {
			count++;
			sum += count;
		}
		if(sum == N) {
			System.out.println(count);
		}
		else {
			System.out.println(count-1);
		}
	}//end main
}