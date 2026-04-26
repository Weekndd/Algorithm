import java.util.*;
import java.io.*;
class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            sb = new StringBuilder();
            recursion(0, (int)Math.pow(3,N),false);
            System.out.println(sb);
        }
    }//end main

    static public void recursion(int start, int size, boolean blank) {
        if(blank) {
            for(int i=0; i<size; i++) {
                sb.append(" ");
            }
            return;
        }
        if(size == 1) {
            sb.append("-");
            return;
        }

        int newSize = size/3;
        int count = 0;
        for(int i=start; i<start+size; i+=newSize) {
            count++;
            if(count == 2) {
                recursion(i,newSize,true);
            }
            else {
                recursion(i,newSize,false);
            }
        }
    }//end recursion
}