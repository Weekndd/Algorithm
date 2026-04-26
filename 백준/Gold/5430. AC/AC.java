import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
        	char[] command = br.readLine().toCharArray();
        	int N = Integer.parseInt(br.readLine());
        	Deque<Integer> dq = new LinkedList<>();
        	String nums = br.readLine();
        	nums = nums.replace("[", "");
        	nums = nums.replace("]", "");
        	StringTokenizer st = new StringTokenizer(nums,",");
        	while(st.hasMoreTokens()) {
        		dq.add(Integer.parseInt(st.nextToken()));
        	}//end input
        	
        	int size = 0;
        	boolean flag = false;
        	int start = 1;
        	for(int j=0; j<command.length; j++) {
        		if(command[j]=='R') {
        			start++;
        		}
        		else {
        			if(dq.isEmpty()) {
        				sb.append("error");
        				flag = true;
        				break;
        			}
        			if(start%2 == 0) {
        				dq.pollLast();
        			}
        			else {
        				dq.poll();
        			}
        		}
        	}//end for
        	if(!flag) {
        		sb.append("[");
        		
            	while(!dq.isEmpty()) {
            		if(start%2 == 0) {
            			sb.append(dq.pollLast()+",");
            			size++;
            		}
            		else {
            			sb.append(dq.poll()+",");
            			size++;
            		}
            	}//end while
            	if(size!=0) {
            		sb.deleteCharAt(sb.length()-1);
            	}
            	sb.append("]");
        	}//end if
        	
        	sb.append("\n");
        }//end i for
        
        System.out.println(sb);
    }//end main
}