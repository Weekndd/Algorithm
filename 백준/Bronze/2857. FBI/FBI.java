import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<5; i++) {
            String str = br.readLine();
            if(str.contains("FBI")) sb.append(i+1+" ");
        }
        System.out.println(sb.length()==0? "HE GOT AWAY!":sb);
    }//end main
}