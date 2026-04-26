import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int CUT = (int)Math.round(N*0.15);
		
		int AVG = 0;
		for(int i=CUT; i<N-CUT; i++) {
			AVG += arr[i];
		}
		
		AVG = (int)Math.round((double)AVG/(N-CUT*2));
		System.out.println(AVG);
		
		
	}
}