import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            if(i<N/2) listA.add(Integer.parseInt(st.nextToken()));
            else listB.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> subsetA = new ArrayList<>();
        List<Integer> subsetB = new ArrayList<>();

        recur(0, 0, subsetA, listA);
        recur(0, 0, subsetB, listB);
        Collections.sort(subsetB);

        int ans = 0;
        for(int i=0; i<subsetA.size(); i++) {
            int target = subsetA.get(i);
            ans += binarySearch(C-target, subsetB)+1;
        }
        System.out.println(ans);
    }//end main

    public static void recur(int idx, int sum, List<Integer> subset, List<Integer> list) {
        if(sum>C) return;
        if(idx==list.size()) {
            subset.add(sum);
            return;
        }
        recur(idx+1, sum+list.get(idx), subset, list);
        recur(idx+1, sum, subset, list);
    } //end recur;

    public static int binarySearch(int target, List<Integer> subset) {
        int left=0 , right=subset.size()-1, mid, res = 0;
        while(left<=right) {
            mid = left+(right-left)/2;
            if(subset.get(mid)<=target) {
                left = mid+1;
                res = mid;
            }
            else {
                right = mid-1;
            }
        }
        return res;
    }//end binary search
}