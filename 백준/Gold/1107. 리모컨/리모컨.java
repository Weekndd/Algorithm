import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<Integer>();
        if(M>0) {
        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        	for(int i=0; i<M; i++) {
        		set.add(Integer.parseInt(st.nextToken()));
        	}
        }
        //end input
        int ans = Math.abs(100-N);
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=999999; i++) {
        	String str = String.valueOf(i);
        	boolean isBreak = false;
        	for(int j=0; j<str.length(); j++) {
        		if(set.contains(str.charAt(j)-'0')) {
        			isBreak = true;
        			break;
        		}
        	}
        	if(isBreak) continue;
        	cnt = str.length() + Math.abs(i-N);
        	if(cnt<min) min = cnt;
        }
        if(min < ans) ans = min;
        System.out.println(ans);
    }//end main
}