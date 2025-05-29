import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Num{
        int x,y;
        int count;
        Num(int x, int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        int[][] arr = new int[x][y];
        int[] goal = new int[2];
        StringTokenizer st;

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    goal[0]= i;
                    goal[1] = j;
                }
            }
        }

        bfs(arr, goal[0], goal[1]);

        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                bw.write(result[i][j] + " ");
                bw.flush();
            }
            bw.write("\n");
        }

    }
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};

    static void bfs(int[][] arr, int goalx, int goaly){
        Queue<Num> q = new LinkedList<>();
        int nx ,ny;
        visited = new boolean[x][y];
        result = new int[x][y];
        visited[goalx][goaly] = true;
        q.add(new Num(goalx, goaly, 0));
        while(!q.isEmpty()){
            Num n = q.poll();
            for(int i = 0; i < 4; i++) {
                nx = n.x + dx[i];
                ny = n.y + dy[i];

                if(nx>=0&&ny>=0&& nx< arr.length && ny< arr[0].length){
                    if(arr[nx][ny] == 0){
                        result[nx][ny] = 0;
                    }

                    if( !visited[nx][ny] && arr[nx][ny]!=0){
                        visited[nx][ny] = true;
                        result[nx][ny] = n.count+1;
                        q.add(new Num(nx, ny, n.count+1));
                    }
                }
            }
        }
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(!visited[i][j] && arr[i][j] != 0){
                    result[i][j] = -1;
                }
            }
        }

    }
}