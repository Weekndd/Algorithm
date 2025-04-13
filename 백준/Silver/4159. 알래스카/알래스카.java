import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int N = Integer.parseInt(br.readLine());
        	if(N==0) break;
        	int[] arr = new int[N];
        	for(int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(br.readLine());
        	}
        	Arrays.sort(arr);
        	int pre = 0;
        	boolean flag = false;
        	for(int i=1; i<N; i++) {
        		int now = arr[i];
        		if(now-pre>200) {
        			sb.append("IMPOSSIBLE\n");
        			flag = true;
        			break;
        		}
        		if(i==N-1) {
        			if(1422-now>200) {
        				sb.append("IMPOSSIBLE\n");
        				flag = true;
        				break;
        			}
        			else {
        				int left = 200-(1422-now);
        				if(1422-now>left) {
        					sb.append("IMPOSSIBLE\n");
        					flag = true;
        					break;
        				}
        			}
        		}
        		pre = now;
        	}
        	sb.append(flag?"":"POSSIBLE\n");
        }//end while
        System.out.println(sb);
    }//end
}