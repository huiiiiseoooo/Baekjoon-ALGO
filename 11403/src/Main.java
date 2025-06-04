import java.io.*;
import java.util.Stack;

public class Main {
    static int nodenum;
    static boolean[][] edge;
    static boolean[][] result;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        nodenum = Integer.parseInt(br.readLine());
        edge = new boolean[nodenum][nodenum];
        result = new boolean[nodenum][nodenum];
        String[] temp;

        for(int i = 0; i < nodenum; i++) {
            temp = br.readLine().split(" ");
            for(int j = 0; j < nodenum; j++) {
                if(temp[j].equals("1")) {
                    edge[i][j] = true;
                }
            }
        }

        for(int i = 0; i < nodenum; i++) {
            dfs(i);
        }

        bw.flush();
        bw.close();
    }
    static boolean[] visited;
    public static void dfs(int start) throws IOException{
        visited = new boolean[nodenum];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        int temp;

        while(!stack.isEmpty()){
            temp = stack.pop();
            for(int i=0; i<nodenum; i++){
                if(edge[temp][i]&&visited[i]==false){
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        for(boolean i: visited){
            if(i){
                bw.write("1 ");
            }else{
                bw.write("0 ");
            }
        }
        bw.write("\n");
    }
}