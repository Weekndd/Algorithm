import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String spl = br.readLine();
        int A = str.length();
        str = str.replace(spl, "");
        System.out.println((A-str.length()) / spl.length());
    }//end main
}