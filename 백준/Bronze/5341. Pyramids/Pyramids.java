import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int N = Integer.parseInt(br.readLine());
        	if(N==0) break;
        	int sum = 0;
        	for(int i=N; i>=0; i--) {
        		sum += i;
        	}
        	sb.append(sum+"\n");
        }
        System.out.println(sb);
    }//end main
}