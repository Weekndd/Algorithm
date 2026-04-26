
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<7; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num%2 == 1) {
				sum+= num;
				if(num < min) min = num;
			}
		}
		if(sum == 0) System.out.println(-1);
		else{
			System.out.println(sum);
			System.out.println(min);
		}
	}//end main
}
