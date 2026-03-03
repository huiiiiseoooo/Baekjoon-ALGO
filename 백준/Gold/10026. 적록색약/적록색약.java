import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
bfs문제
적록색약이 아닌 사람은 색깔을 만나면 바로 bfs를 실행
방문한 배열을 기억하는 다른 배열에 방문표기
방문한 배열을 돌아가면서 방문하지 않은 지역을 만나면 색깔확인 후 bfs
색약인 사람은 R과 G를 조건문으로 같이 처리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] rgb = new String[n][n];
        boolean[][] visited = new boolean[n][n];
        boolean[][] visited2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            rgb[i] = br.readLine().split("");
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int normalcount =0;
        int sickcount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    Queue<Integer[]> q = new LinkedList<>();
                    q.add(new Integer[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Integer[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            if(nx>=0 && ny>=0 && nx<n && ny<n &&rgb[nx][ny].equals(rgb[i][j]) && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.add(new Integer[]{nx, ny});
                            }
                        }
                    }
                    normalcount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited2[i][j]) {
                    Queue<Integer[]> q = new LinkedList<>();

                    q.add(new Integer[]{i, j});
                    visited2[i][j] = true;

                    if(rgb[i][j].equals("B")){
                        while (!q.isEmpty()) {
                            Integer[] cur = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx>=0 && ny>=0 && nx<n && ny<n &&rgb[nx][ny].equals(rgb[i][j]) && !visited2[nx][ny]) {
                                    visited2[nx][ny] = true;
                                    q.add(new Integer[]{nx, ny});
                                }
                            }
                        }
                    }else{
                        while (!q.isEmpty()) {
                            Integer[] cur = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx>=0 && ny>=0 && nx<n && ny<n && (rgb[nx][ny].equals("R") || rgb[nx][ny].equals("G")) && !visited2[nx][ny]) {
                                    visited2[nx][ny] = true;
                                    q.add(new Integer[]{nx, ny});
                                }
                            }
                        }
                    }
                    sickcount++;
                }
            }
        }

        System.out.println(normalcount+" "+sickcount);

    }
}