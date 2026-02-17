/*
bfs사용
bfs 범위 조건을 0이하면 다시 배열끝으로 보내는 식으로 조건문을 작성
bfs 사용 횟수만큼 카운트해서 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    q.add(new int[]{i,j});
                    count++;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = cur[0] + dx[k];
                            int x = cur[1] + dy[k];
                            if(y<0){
                                y = n-1;
                            }
                            if(y>=n){
                                y = 0;
                            }
                            if(x<0){
                                x = m-1;
                            }
                            if(x>=m){
                                x = 0;
                            }
                            if(arr[y][x] == 0){
                                q.add(new int[]{y,x});
                                arr[y][x] = 1;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}