import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
 
public class Main {

	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//산술평균
		long AVG = 0;
		for(int i=0; i<N; i++) {
			AVG += arr[i];
		}
		AVG = Math.round((double)AVG/arr.length);
		
		//중앙값
		long MID = 0;
		Arrays.sort(arr);
		MID = (long)arr[(N-1)/2];
		
		//최빈값
		long FRE = (long)arr[0];
		int count = 0;
		int max = -1;
		boolean check = false;
		for(int i=0; i<N-1; i++) {
			if(arr[i]==arr[i+1]) {
				count++;
			}
			else {
				count = 0;
			}
			
			if(max<count) {
				max = count;
				check = true;
				FRE = (long)arr[i];
				
			}
			else if(max==count && check == true) {
				FRE = (long)arr[i];
				check = false;
			}
			
		}
		
		
		//범위
		long RANGE = (long)(arr[arr.length-1] - arr[0]);
		
		sb.append(AVG+"\n");
		sb.append(MID+"\n");
		sb.append(FRE+"\n");
		sb.append(RANGE);
		System.out.println(sb);
	}
}