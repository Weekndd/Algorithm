import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[15][15];
		for(int i=0; i<15; i++) {
			arr[i][1] = 1;
			arr[0][i] = i;
		}
		for(int i=1; i<15; i++) {
			for(int j=2; j<15; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
				
			}
		}
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int K = Integer.parseInt(br.readLine());
			
			sb.append(arr[N][K]+"\n");
		}
		System.out.println(sb);
		
	}
}