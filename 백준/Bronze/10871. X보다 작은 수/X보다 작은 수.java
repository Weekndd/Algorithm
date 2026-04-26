import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int num = scan.nextInt();
        
        for(int i=0; i<n; i++) {
        	int val = scan.nextInt();
        	if(num>val) {
        		System.out.print(val+" ");
        	}
        }
    }
}