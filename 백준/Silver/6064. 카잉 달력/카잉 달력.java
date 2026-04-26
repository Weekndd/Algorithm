import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	boolean flag = false;
        	int maxA = Integer.parseInt(st.nextToken());
        	int maxB = Integer.parseInt(st.nextToken());
        	int A = Integer.parseInt(st.nextToken())-1;
        	int B = Integer.parseInt(st.nextToken())-1;
        
        	for(int j=A; j<maxA*maxB; j+=maxA) {
        		if(j%maxB == B) {
        			sb.append((j+1)+"\n");
        			flag = true;
        			break;
        		}
        	}
        	if(!flag) {
        		sb.append(-1+"\n");
        	}
        }
        System.out.println(sb);
    }//end main
}