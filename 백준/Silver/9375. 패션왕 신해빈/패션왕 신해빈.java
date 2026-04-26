import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	HashMap<String, Integer> map = new HashMap<>();
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		st.nextToken();
        		String category = st.nextToken();
        		if(map.containsKey(category)) {
        			map.put(category, map.get(category)+1);
        		}
        		else {
        			map.put(category, 1);
        		}
        	}
        	int ans = 1;
        	for(int i : map.values()) {
        		ans *= (i+1);
        	}
        	sb.append(ans-1+"\n");
        }//end T
        System.out.println(sb);
    }//end main
}