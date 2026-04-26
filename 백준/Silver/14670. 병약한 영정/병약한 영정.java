import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N개의 아이템과 그에 대한 무기 번호 저장
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map.put(key, value);
		}

		// 정답 저장용
		StringBuilder ans = new StringBuilder();
		
		// M개의 공격 시도
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			boolean died = false;
			StringBuilder temp = new StringBuilder();
			
			for (int k = 0; k < K; k++) {
				int key = Integer.parseInt(st.nextToken());
				if (!map.containsKey(key)) {
					died = true;
				}
				if (!died) {
					temp.append(map.get(key)).append(" ");
				}
			}

			if (died) {
				ans.append("YOU DIED\n");
			} else {
				ans.append(temp.toString().trim()).append("\n");
			}
		}
		
		System.out.print(ans);
	}
}