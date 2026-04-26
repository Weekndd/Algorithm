import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String msg = "ascending";
        int[] arr = new int[8];
        for(int i=0; i<arr.length; i++) {
        	arr[i] = scan.nextInt();
        }
        for(int i=0; i<arr.length-1; i++) {
        	if(arr[i]+1 == arr[i+1]) {
        		msg = "ascending";
        	} 
        	else if(arr[i]-1 == arr[i+1]) {
        		msg = "descending";
        	} 
        	else {
        		msg = "mixed";
        		break;
        	}
        }
        System.out.println(msg);
    }
}