import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        String str ="";
        for(int i=0; i<arr.length; i++) {
            if(i!=0 && i%10==0) {
                sb.append(str+"\n");
                str="";
            }
            str+=arr[i];
        }
        sb.append(str+"\n");
        System.out.println(sb);
    }//end main
}