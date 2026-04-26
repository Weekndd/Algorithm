import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        String s = scan.nextLine();
        for(int i=0; i<n; i++) {
        	sum = sum + (s.charAt(i) - 48);
        }
        System.out.println(sum);
        
    }
}