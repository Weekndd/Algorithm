import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int temp = A;
		int multiplication = A*B;
		
		A = Math.max(A, B);
		B = Math.min(temp, B);
		
		while(B!=0) {
			temp = A % B;
			A = B;
			B = temp;
		}
		System.out.println(A);
		System.out.println(multiplication/A);
		
		
	}
}