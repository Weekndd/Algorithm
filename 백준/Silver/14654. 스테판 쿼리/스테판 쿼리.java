import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());

        int cntA = 0, cntB = 0, max = 0;
        for(int i=0; i<N; i++) {
            int numA = Integer.parseInt(stA.nextToken());
            int numB = Integer.parseInt(stB.nextToken());
            if(numA==numB) { //비길 경우
                if(cntA==0) { //새로 출전한 사람이 승리한다.
                    cntA++;
                    cntB=0;
                }
                else if(cntB==0){
                    cntB++;
                    cntA=0;
                }
            }
            else if(Math.abs(numA-numB)>1) { //2이상 차이나면 작은수가 이김
                if(numA<numB) {
                    cntA++;
                    cntB = 0;
                }
                else {
                    cntB++;
                    cntA = 0;
                }
            }
            else { //1차이나면 큰수가 이김
                if(numA<numB) {
                    cntB++;
                    cntA = 0;
                }
                else {
                    cntA++;
                    cntB = 0;
                }
            }
            max = max<Math.max(cntA, cntB)?Math.max(cntA, cntB):max;
        }
        System.out.println(max);
    }//end main
}