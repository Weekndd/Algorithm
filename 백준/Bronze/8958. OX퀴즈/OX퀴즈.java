import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num =Integer.parseInt(scan.nextLine());
        int[] arr = new int[num];
        
        for(int i=0; i<num; i++) {
        	boolean check = false;
        	String S = scan.nextLine();
        	int count = 0;
        	int sum= 0;
        	
        	for(int j=0; j<S.length(); j++) {
        		if(S.charAt(j) == 'O') {
        			if(check == true) {
        				count = count+1;
        			} else { 
        				count ++;
        			}
        			check = true;
        		}
        		else {
        			check = false;
        			count = 0;
        		}
        		sum += count;
        	}
        	System.out.println(sum);
        }
        
    }
}