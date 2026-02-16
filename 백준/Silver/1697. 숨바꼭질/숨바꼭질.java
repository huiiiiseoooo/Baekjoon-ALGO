import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
다이나믹 프로그래밍으로 예상하고 접근
시작지점부터 도착지점까지 도달 횟수 표 생성
예상이 완전히 틀려버림
bfs로 시작지점부터 -1 +1 *2를 노드로 생각하고 탐색하면 된다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        boolean[] arr = new boolean[100001];
        int[] res = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if(cur == end) {
                break;
            }
            int[] x = {cur-1,cur+1,cur*2};
            for (int i = 0; i < x.length; i++) {
                if(x[i]>=0 && x[i]<arr.length && arr[x[i]]==false) {
                    q.add(x[i]);
                    arr[x[i]] = true;
                    res[x[i]] = res[cur]+1;
                }
            }
        }
        System.out.println(res[end]);
    }
}