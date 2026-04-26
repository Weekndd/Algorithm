import java.util.*;
import java.io.*;

public class Main {
	static int min = Integer.MAX_VALUE, youmi[], people[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		String M = st.nextToken();
		System.out.println(N.equals(M)?1:0);
	}//end main
}
