import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String person = st.nextToken();
        	String command = st.nextToken();
        	
        	if(command.equals("enter")) set.add(person);
        	else set.remove(person);
        }
        
        ArrayList<String> arr = new ArrayList<>(set);
        Collections.sort(arr,Collections.reverseOrder());
        arr.forEach(s -> sb.append(s+"\n"));
        System.out.println(sb);
    }//end main
}