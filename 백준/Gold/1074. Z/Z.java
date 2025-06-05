import java.io.*;
import java.util.*;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		Z(size, row, col);
		System.out.println(count);
	}
	
	
	private static void Z(int size, int r, int c ) {
		if(size == 1) {
			return;
		}
		
		if(r<size/2 && c<size/2) {
			Z(size/2, r, c);
		}
		else if(r<size/2 && c>=size/2) {
			count = count + size * size/4;
			Z(size/2, r, c-size/2);
		}
		else if(r>=size/2 && c<size/2) {
			count = count + (size*size/4) * 2;
			Z(size/2, r-size/2, c);
		}else {
			count = count + (size*size/4) * 3;
			Z(size/2, r-size/2, c-size/2);
		}
	}
}