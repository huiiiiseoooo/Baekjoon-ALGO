import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
7576번 토마토 문제를 삼차원 배열로 똑같은 풀이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[1]), m = Integer.parseInt(input[0]), k = Integer.parseInt(input[2]);
        int[][][] arr = new int[n][m][k];
        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i<k; i++){
            for(int j =0; j<n; j++){
                input = br.readLine().split(" ");
                for(int l =0; l<m; l++){
                    arr[j][l][i] = Integer.parseInt(input[l]);
                    if(arr[j][l][i] == 1){
                        q.add(new int[]{j,l,i});
                    }
                }
            }
        }
        int[] dx = {0,-1,0,1, 0, 0};
        int[] dy = {1,0,-1,0, 0, 0};
        int[] dz = {0,0,0,0,-1, 1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i =0; i<6; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                int z = cur[2] + dz[i];
                if(x>=0 && x<n && y>=0 && y<m && z>=0 && z<k && arr[x][y][z] == 0){
                    q.add(new int[]{x,y,z});
                    arr[x][y][z] = arr[cur[0]][cur[1]][cur[2]]+1;

                }
            }
        }

        int max = 1;
        for(int i =0; i<k; i++){
            for(int j =0; j<n; j++){
                for(int l =0; l<m; l++){
                    if(arr[j][l][i] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if(arr[j][l][i] > max){
                        max = arr[j][l][i];
                    }
                }
            }
        }

        System.out.println(max-1);
        
    }
}