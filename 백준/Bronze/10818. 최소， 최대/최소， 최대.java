import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
        	arr[i] = scan.nextInt();
        }
        
        int max =  -1000001;
        int min =  1000001;
        
        for(int i=0; i<arr.length; i++) {
        	if(arr[i]> max) {
        		max = arr[i];
        	}
        	if(arr[i] < min) {
        		min = arr[i];
        	}
        }
        System.out.print(min+ " " + max);
        
    }
}