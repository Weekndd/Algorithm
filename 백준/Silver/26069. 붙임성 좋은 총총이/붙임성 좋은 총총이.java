import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        Set<String> set = new HashSet<>();
        int cnt = 0;
        boolean flag = false;
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	String A = st.nextToken();
        	String B = st.nextToken();
        	
        	if(A.equals("ChongChong") || B.equals("ChongChong")) {
        		set.add("ChongChong");
        		flag = true;
        	}
        	if(flag) {
        		if(set.contains(A) || set.contains(B)) {
        			set.add(A);
        			set.add(B);
        		}
        	}
        }
        System.out.println(set.size());
    }//end main
}