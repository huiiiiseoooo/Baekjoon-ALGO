import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int num;
        vector[] vectors;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        vectors = new vector[num];
        String[] temp;
        for (int i = 0; i < num; i++) {
            temp = br.readLine().split(" ");
            vectors[i] = new vector(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        Arrays.sort(vectors);
        for (int i = 0; i < num; i++) {
            System.out.println(vectors[i].x+" "+vectors[i].y);
        }



    }

    public static class vector implements Comparable<vector> {
        int x,y;
        public vector(int x,int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(vector o) {
            if(x == o.x){
                return y - o.y;
            }

            return x - o.x;
        }
    }
}
