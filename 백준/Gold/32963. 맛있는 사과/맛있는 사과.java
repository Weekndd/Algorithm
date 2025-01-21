import java.util.*;
import java.io.*;

public class Main {
	static class Apple implements Comparable<Apple>{
		int T, S;
		Apple(int T, int S) {
			this.T = T;
			this.S = S;
		}
		public int compareTo(Apple a1) {
			if(a1.T==this.T) {
				return a1.S-this.S;
			}
			return a1.T-this.T;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Apple[] arr = new Apple[N];
        
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int j=0; j<N; j++) {
    		int t = Integer.parseInt(st.nextToken());
    		int s = Integer.parseInt(st2.nextToken());
    		arr[j] = new Apple(t,s);
    	}//end input
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
        	int standard = Integer.parseInt(br.readLine());
        	int cnt = 0;
        	int maxSize = 0;
        	for(int j=0; j<N; j++) {
            	if(arr[j].T>=standard) {
            		if(arr[j].S > maxSize) {
            			maxSize = arr[j].S;
            			cnt = 1;
            		}
            		else if(arr[j].S==maxSize){
            			cnt++;
            		}
            	}
            	else {
            		break;
            	}
        	}
        	sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }//end main
}