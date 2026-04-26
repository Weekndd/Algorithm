import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		String[][] arr = new String[T][2];
		
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		Arrays.sort(arr, (e1,e2) -> {
			return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
		});
		
		for(String s[] : arr) {
			sb.append(s[0]+" "+s[1]+"\n");
		}
		System.out.println(sb);
	}
}