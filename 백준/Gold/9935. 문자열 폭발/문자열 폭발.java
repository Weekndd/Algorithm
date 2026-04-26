import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            stack.push(str.charAt(i));
            if(stack.size()>=boom.length()) {
                boolean isSame = true;
                for(int j=0; j<boom.length(); j++) {
                    //폭발 문자랑 다르다면
                    if(stack.get(stack.size()-boom.length()+j) != boom.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }//end for

                //폭발 문자랑 똑같다면
                if(isSame) {
                    for(int k=0; k<boom.length(); k++) stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) sb.append(c);
        System.out.println(sb.length()==0 ? "FRULA" : sb);
    }//end main
}