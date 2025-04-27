import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int time = 1;
    	while(true) {
    		String str = br.readLine();
    		if(str.contains("-")) break;
    		Stack<Character> stack = new Stack<>();
    		
    		int cnt = 0;
    		for(int i=0; i<str.length(); i++) {
    			char now = str.charAt(i);
    			if(now=='}') {
    				if(stack.isEmpty()) {
    					cnt++;
    					stack.add('{');
    				}
    				else {
    					stack.pop();	
    				}
    			}
    			else if(now=='{'){
    				stack.add('{');
    			}
    		}
    		sb.append(time+". "+((stack.size()/2)+cnt)+"\n");
    		time++;
    	}
    	System.out.println(sb);
    }
}