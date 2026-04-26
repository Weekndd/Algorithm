import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			if(a % 2 == 0) {
				a = a / 2 ^ 6;
			}else {
				a = (2 * a) ^ 6;
			}
		}
		System.out.println(a);
		sc.close();
	}
}