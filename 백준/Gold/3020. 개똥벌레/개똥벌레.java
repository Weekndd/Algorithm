import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());        
        int[] arr = new int[H+2];
        for(int i=1; i<=N; i++) {
        	int num = Integer.parseInt(br.readLine());
        	if(i%2==0) {
        		arr[H+1]--;
        		arr[H-num+1]++;
        	}
        	else {
        		arr[1]++;
        		arr[num+1]--;
        	}
        }
        //end input
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i=1; i<=H; i++) {
        	arr[i] = arr[i-1]+arr[i];
        	if(arr[i]<min) {
        		min = arr[i];
        		cnt = 1;
        	}
        	else if(arr[i]==min) cnt++;
        }
        System.out.println(min+" "+cnt);
    }//end main
}