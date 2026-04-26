import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int MAX = 0;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int num1 = arr[i];
			
			for(int j=i+1; j<N; j++) {
				int num2 = arr[j];
				if((num1+num2)>M) {
					continue;
				}
					
				for(int k=j+1; k<N; k++) {
					int num3 = arr[k];
					if((num1+num2+num3)>M) {
						continue;
					}
					
					if((num1+num2+num3)>MAX) {
						MAX = num1+num2+num3;
					}
				}
				
			}//end num2
			
		}//end num1
		System.out.println(MAX);
	}
}