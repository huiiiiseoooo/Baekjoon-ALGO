/*
dp 유형의 문제로 예상하고 접근
매 칸마다 이동 표를 만들어서 가장작은수랑 큰수 선택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        String[] line;
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
            arr[i][2] = Integer.parseInt(line[2]);
        }

        int[] max = new int[3];
        int[] min = new int[3];

        max[0] = arr[0][0];
        max[1] = arr[0][1];
        max[2] = arr[0][2];

        min[0] = arr[0][0];
        min[1] = arr[0][1];
        min[2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            int a = max[0];
            int b = max[1];
            int c = max[2];
            int d = min[0];
            int e = min[1];
            int f = min[2];

            max[0] = arr[i][0] + Math.max(a,b);
            max[1] = arr[i][1] + Math.max(Math.max(a,b), c);
            max[2] = arr[i][2] + Math.max(b,c);

            min[0] = arr[i][0] + Math.min(d,e);
            min[1] = arr[i][1] + Math.min(Math.min(d,e), f);
            min[2] = arr[i][2] + Math.min(e,f);
        }
        System.out.println(Math.max(Math.max(max[0], max[1]), max[2]));
        System.out.println(Math.min(Math.min(min[0], min[1]), min[2]));

    }
}