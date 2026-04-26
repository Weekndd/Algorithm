import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		double[] arr = new double[n];
		double max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = (double)Integer.parseInt(st.nextToken());
			if(max<arr[i]) {
				max = arr[i];
			}
		}
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += (arr[i]/max)*100;
		}
		System.out.println(sum/n);
	}
}