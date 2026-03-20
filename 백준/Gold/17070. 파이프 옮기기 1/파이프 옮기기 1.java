/*
dfs를 사용해서 푸는 문제로 예상
머리기준으로 오른쪽 아래 비어있으면 대각이동가능

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result =0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0 , 1,1});
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            if(pop[0] == n-1 && pop[1] == n-1){
                result++;
                continue;
            }
            if(pop[2] == 1) {
                if(pop[1]+1 < n && map[pop[0]][pop[1]+1] == 0) {
                    stack.push(new int[]{pop[0],pop[1]+1,1});

                }
                if(pop[0]+1 < n && pop[1]+1 < n && map[pop[0]+1][pop[1]+1] == 0 && map[pop[0]][pop[1]+1] == 0 && map[pop[0]+1][pop[1]] == 0) {
                    stack.push(new int[]{pop[0]+1,pop[1]+1,3});

                }
            }
            if(pop[2] == 2) {
                if( pop[0]+1 < n && map[pop[0]+1][pop[1]] == 0) {
                    stack.push(new int[]{pop[0]+1, pop[1], 2});
                }
                if(pop[0]+1 < n && pop[1]+1 < n && map[pop[0]+1][pop[1]+1] == 0 && map[pop[0]][pop[1]+1] == 0 && map[pop[0]+1][pop[1]] == 0) {
                    stack.push(new int[]{pop[0]+1,pop[1]+1,3});

                }
            }
            if(pop[2] == 3) {
                if(pop[1]+1 < n && map[pop[0]][pop[1]+1] == 0) {
                    stack.push(new int[]{pop[0],pop[1]+1,1});

                }
                if(pop[0]+1 < n && map[pop[0]+1][pop[1]] == 0) {
                    stack.push(new int[]{pop[0]+1, pop[1], 2});

                }
                if(pop[0]+1 < n && pop[1]+1 < n && map[pop[0]+1][pop[1]+1] == 0 && map[pop[0]][pop[1]+1] == 0 && map[pop[0]+1][pop[1]] == 0) {
                    stack.push(new int[]{pop[0]+1,pop[1]+1,3});

                }
            }
        }

        System.out.println(result);
    }
}