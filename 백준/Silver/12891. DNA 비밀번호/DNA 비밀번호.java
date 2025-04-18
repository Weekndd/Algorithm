import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int s = 0;
        int e = M-1;
        
		int a, c, g, t, cnt;
		a = c = g = t = cnt = 0;
		
        for(int i=s; i<=e; i++) {
			if(arr[i]=='A') a++;
			else if(arr[i]=='C') c++;
			else if(arr[i]=='G') g++;
			else if(arr[i]=='T') t++;
    	}
        
        while(true) {
        	if(A<=a && C<=c && G<=g && T<=t) cnt++;
        	
        	e++;
        	if(e>=N) break;
			if(arr[s]=='A') a--;
			else if(arr[s]=='C') c--;
			else if(arr[s]=='G') g--;
			else if(arr[s]=='T') t--;
			s++;
			if(arr[e]=='A') a++;
			else if(arr[e]=='C') c++;
			else if(arr[e]=='G') g++;
			else if(arr[e]=='T') t++;
        }
        System.out.println(cnt);
	}//end main
}
