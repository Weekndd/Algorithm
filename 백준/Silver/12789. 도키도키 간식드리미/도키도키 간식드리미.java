import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int idx = 1; // 다음으로 나와야 하는 순서 번호
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == idx) {
                idx++; // 바로 순서에 맞으면 통과
            } else {
                stack.push(num); // 스택에 넣기
            }

            // 스택 확인 및 순서대로 번호 빼기
            while (!stack.isEmpty() && stack.peek() == idx) {
                stack.pop(); // 순서에 맞는 번호 제거
                idx++;       // 다음 번호로 진행
            }
        }

        // 스택이 비어 있으면 성공, 아니면 실패
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}