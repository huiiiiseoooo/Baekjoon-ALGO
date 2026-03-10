import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
최소 비용을 구하는거라
다익스트라 알고리즘 사용
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        int[][] edges = new int[bus][3];
        LinkedList<int[]>[] list = new LinkedList[city+1];
        String[] line;

        for(int i = 1; i <= city; i++){
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < bus; i++) {
            line = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(line[0]);
            edges[i][1] = Integer.parseInt(line[1]);
            edges[i][2] = Integer.parseInt(line[2]);

            list[edges[i][0]].add(new int[]{edges[i][1], edges[i][2]});
        }

        line = br.readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int end = Integer.parseInt(line[1]);

        int[] dtable = new int[city+1];
        Arrays.fill(dtable, Integer.MAX_VALUE);


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dtable[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];

            if(curCost > dtable[curNode]) continue;

            for(int[] next : list[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];

                if(dtable[curNode] + nextCost < dtable[nextNode]){
                    dtable[nextNode] = dtable[curNode] + nextCost;
                    pq.add(new int[]{nextNode, dtable[nextNode]});
                }
            }
        }
        System.out.println(dtable[end]);
        
    }
}