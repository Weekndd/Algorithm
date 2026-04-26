import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Set<String> set = new HashSet<>();
        for(int i=0; i<chars.length; i++) {
            String str = "";
            for(int j=i; j<chars.length; j++) {
                str += chars[j];
                set.add(str);
            }
        }
        System.out.println(set.size());
    }//end main
}