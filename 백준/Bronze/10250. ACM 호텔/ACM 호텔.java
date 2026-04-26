import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        
        for(int c=0; c<count; c++) {
            int h = scan.nextInt();
            int w = scan.nextInt();
            int n = scan.nextInt();
        	
            if(n%h==0) {
            	System.out.println(String.valueOf(h)+String.format("%02d",(n/h)));	
            } else{
            	System.out.println(String.valueOf(n%h)+String.format("%02d",(n/h)+1));
            
            }
        }
    }
}