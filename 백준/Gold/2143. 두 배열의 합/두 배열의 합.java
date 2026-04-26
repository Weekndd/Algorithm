import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> aSumList = new ArrayList<>();
        List<Integer> bSumList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<N; j++) {
                sum += arrA[j];
                aSumList.add(sum);
            }
        }
        for(int i=0; i<M; i++) {
            int sum = 0;
            for(int j=i; j<M; j++) {
                sum += arrB[j];
                bSumList.add(sum);
            }
        }
        Collections.sort(aSumList);
        Collections.sort(bSumList);

        int pointerA = 0;
        int pointerB = bSumList.size()-1;
        long cnt = 0;
        while(pointerA<aSumList.size() && pointerB>=0) {
            long sum = aSumList.get(pointerA) + bSumList.get(pointerB);
            if(sum == T) {
                int a = aSumList.get(pointerA);
                int b = bSumList.get(pointerB);
                long aCnt = 0;
                long bCnt = 0;
                while(pointerA<aSumList.size() && aSumList.get(pointerA) == a) {
                    aCnt++;
                    pointerA++;
                }
                while(pointerB>=0 && bSumList.get(pointerB) == b) {
                    bCnt++;
                    pointerB--;
                }
                cnt += aCnt * bCnt;
            }
            else if(sum > T) {
                pointerB--;
            }
            else if(sum < T) {
                pointerA++;
            }

        }//end while
        System.out.println(cnt);
    }//end main
}