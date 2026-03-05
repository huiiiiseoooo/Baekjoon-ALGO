import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/*
dfs활용
링크드 리스트 배열을 만들어서 각각 노드를 저장
리스트 배열 0인덱스에 있는 리스트 들을 각각 배열 인덱스로 둬서 숫자를 카운트하고 visit 배열을 만들어서 방문표시
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[computerNum+1];
        LinkedList<Integer>[] list = new LinkedList[computerNum+1];

        for (int i = 1; i <= computerNum; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < edgeNum; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            list[a].add(b);
            list[b].add(a);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            for(int next: list[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }

        int count = 0;

        for(int i = 0; i <= computerNum; i++) {
            if(visited[i]){
               count++;
            }
        }

        System.out.println(count-1);
    }

}