import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        
        for(int i=0; i<T; i++) {
            String S = scan.nextLine();
            String P = "";
            
            StringTokenizer stk = new StringTokenizer(S, " ");
            int R = Integer.parseInt(stk.nextToken());
        
        	String s1 = stk.nextToken();
        	for(int j=0; j<s1.length(); j++) {
        		for(int k=0; k<R; k++) {
        			P = P.concat(String.valueOf(s1.charAt(j)));
        		}
        	}
            System.out.println(P);
        }

    }
}