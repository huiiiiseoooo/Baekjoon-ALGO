import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
dfs를 사용해서 그래프 탐색 시작점으로 돌아오면 순회가 있는것

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {

            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k];
            String[] chars = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(chars[j]);
            }

            boolean[] visited = new boolean[k];
            for (int j = 0; j < k; j++) {

                int temp = j;
                if(!visited[j]) {
                    while (!visited[temp]) {
                        visited[temp] = true;
                        temp = arr[temp]-1;
                    }
                    counts[i]++;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(counts[i] + " ");
        }
        
    }
}