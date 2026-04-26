import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        if(a.charAt(0)=='S'){
            bw.write("HIGHSCHOOL");
        }
        else if(a.charAt(0)=='C'){
            bw.write("MASTER");
        }
        else if(a.charAt(0)=='2'){
            bw.write("0611");
        }
        else if(a.charAt(0)=='A'){
            bw.write("CONTEST");
        }
        bw.flush();
    }
}