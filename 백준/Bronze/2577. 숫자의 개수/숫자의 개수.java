import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] arr = new int[10];
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        
        
        String num = String.valueOf(a*b*c);
        
        for(int i=0; i<num.length(); i++) {
        	arr[num.charAt(i)-'0'] += 1;
        }
        for(int i : arr) {
        	System.out.println(i);
        }
    }
}