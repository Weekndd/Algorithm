import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		if(a % 3 == 0) {
			System.out.println("S");
		}else if(a % 3 == 1) {
			System.out.println("U");
		}else if(a % 3 == 2) {
			System.out.println("O");
		}
	}
}