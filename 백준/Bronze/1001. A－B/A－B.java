import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
        if(a<0){
            a = input.nextInt();
        }
        int b = input.nextInt();
        if(b>10){
            b = input.nextInt();
        }
        
        System.out.println(a-b);

	}

}