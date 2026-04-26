import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int[] a = new int[26];
        for(int i=0; i<a.length; i++) {
        	a[i] = -1;
        }
        for(int i=0; i<s.length(); i++) {
        	if(a[s.charAt(i)-'a'] == -1) {
        		a[s.charAt(i)-'a'] = i;
        	}
        }
        for(int i : a) {
        	System.out.print(i+" ");
        }
        
    }
}