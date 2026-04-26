import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        int[] res = new int [10];
        for(int i=0; i<10; i++) {
        	arr[i] = scan.nextInt();
        }
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = arr[i] % 42;
        }
        for(int i=0; i<arr.length; i++) {
        	int count = 0;
        	for(int j=i; j<arr.length; j++ ) {
        		if(arr[i] == arr[j]) {
        			++count;
        			res[i] = count;
        		}
        	}
        }
        
        int count1 = 0;
        for(int i: res) {
        	if(i==1) {
        		count1++;
        	}
        }
        System.out.println(count1);

        
    }
}