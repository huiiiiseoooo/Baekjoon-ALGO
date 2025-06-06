import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Main {
    public static class node{
        int vertex1;
        int vertex2;
        long weight;
        public node(int vertex1, int vertex2, int weight){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }
    static int nodenum;
    static int edgenum;
    static int sum=0;
    static int[] union;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        nodenum = Integer.parseInt(temp[0]);
        edgenum = Integer.parseInt(temp[1]);
        Vector<node> vector = new Vector<>();
        for(int i=0; i<edgenum; i++){
            temp = br.readLine().split(" ");
            vector.add(new node(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2])));
        }
        Collections.sort(vector,new weightCompare());

        kruskal(vector);
        String s = String.valueOf(sum);
        bw.write(s);
        bw.flush();
        bw.close();

    }

    public static void kruskal(Vector<node> vecter){
        union = new int[nodenum];
        for(int i=0; i<nodenum; i++){
            union[i] = i;
        }
        node temp;
        for(int i=0; i<edgenum; i++){
            temp = vecter.get(i);
            int u = unionFind(temp.vertex1-1);
            int v = unionFind(temp.vertex2-1);
            if(u!=v){
                union[u]=v;
                sum+=temp.weight;
            }
        }
    }

    public static int unionFind(int i){
            if(union[i] == i){return i;}
            return union[i]=unionFind(union[i]);

    }

    static class weightCompare implements Comparator<node>{
        @Override
        public int compare(node o1, node o2) {
            if(o1.weight>o2.weight){return 1;}
            if(o1.weight<o2.weight){return -1;}
            return 0;
        }
    }
}