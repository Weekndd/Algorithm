import java.io.*;
import java.util.*;

public class Main {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		
		
		A = A.charAt(2)+""+A.charAt(1)+""+A.charAt(0);
		B = B.charAt(2)+""+B.charAt(1)+""+B.charAt(0);
		
		int numA = Integer.parseInt(A);
		int numB = Integer.parseInt(B);
		System.out.println(Math.max(numA, numB));
	}//end main
}