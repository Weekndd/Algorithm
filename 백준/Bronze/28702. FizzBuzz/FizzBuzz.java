import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int num = 0;
        for(int i=1; i<=3; i++) {
            String str = br.readLine();
            if(str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz")) {
                continue;
            }
            idx = i;
            num = Integer.parseInt(str);
        }
        if(idx == 3) {
            num+=1;
            if(num%3==0 && num%5==0) System.out.println("FizzBuzz");
            else if(num%3==0) System.out.println("Fizz");
            else if(num%5==0) System.out.println("Buzz");
            else System.out.println(num);
        }
        if(idx == 2) {
            num+=2;
            if(num%3==0 && num%5==0) System.out.println("FizzBuzz");
            else if(num%3==0) System.out.println("Fizz");
            else if(num%5==0) System.out.println("Buzz");
            else System.out.println(num);
        }
        if(idx == 1) {
            num+=3;
            if(num%3==0 && num%5==0) System.out.println("FizzBuzz");
            else if(num%3==0) System.out.println("Fizz");
            else if(num%5==0) System.out.println("Buzz");
            else System.out.println(num);
        }
    }//end main
}