import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int[] arr = new int[26];
        String str = scan.next();
        
        for(int i=0; i<str.length(); i++) {
        	if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
        		arr[str.charAt(i)-'A']++;
        	} else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
        		arr[str.charAt(i)-'a']++;
        	}
        }
        int max = 0;
        char maxChar='A';
        for(int i=0; i<arr.length; i++) {
        	if(max < arr[i]) {
        		max = arr[i];
        		maxChar = (char)(i+65);
        	} else if (max == arr[i]) {
        		maxChar='?';
        	}
        }
        System.out.println(maxChar);
        
    }
}