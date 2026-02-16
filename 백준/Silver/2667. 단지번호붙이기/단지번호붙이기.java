import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
배열 전체를 반복하며 1인 곳이 나오면 그곳을 기준으로 bfs를 실행한다.
bfs가 단위로 방문한곳 숫자를 배열에 저장한다.
이어서 반복문을 실행한다.
반복문 종료후 배열을 오름차순으로 종료하고 크기와 내용을 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] area = new int[n][n];
        String[] input;
        ArrayList list = new ArrayList();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(area[i][j] != 0) {
                    int count =1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    area[i][j] = 0;
                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int x = cur[0] + di[k];
                            int y = cur[1] + dj[k];
                            if(x>=0 && x<n && y>=0 && y<n && area[x][y] != 0) {
                                queue.add(new int[]{x, y});
                                area[x][y] = 0;
                                count++;
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(Object o : list) {
            System.out.println(o);
        }

    }
}