import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			int count = 0;
			boolean flag = true;
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == '(') {
					count++;
				} 
				else if(arr[j] == ')'){
					count--;
					if(count==-1) {
						sb.append("NO"+"\n");
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				if(count==0) {
					sb.append("YES"+"\n");
				} else {
					sb.append("NO"+"\n");
				}
			}
		}
		System.out.println(sb);
		
	}
}