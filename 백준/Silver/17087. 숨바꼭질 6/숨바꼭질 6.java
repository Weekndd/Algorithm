import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] dList = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			dList[i] = Math.abs(s - Integer.parseInt(st.nextToken()));
		}
		
		int result = dList[0];
		for(int i=1;i<n;i++) {
			result = gcd(result, dList[i]);
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}

}