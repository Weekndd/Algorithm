import java.io.*;
import java.util.*;
 
public class Main {    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int A = 0;
        int B = 0;
        int C = 0;
        boolean flag = false;
        while(T!=0) {
        	if(T>=300) {
            	T -= 300;
            	A++;
            }
            else if(T>=60) {
            	T -= 60;
            	B++;
            }
            else if(T>=10) {
            	T -= 10;
            	C++;
            }
            else if(T<10) {
            	flag = true;
            	break;
            }
        }//end while
        if(flag) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(A+" "+B+" "+C);
        }
    }//end main
}
