import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	if(i%2==1) sb.append(" ");
        	for(int j=0; j<N; j++) {
        		sb.append("* ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }//end main
}