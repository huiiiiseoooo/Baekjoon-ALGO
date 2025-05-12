import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static class length{
        int x,y,z;
        public length(int x,int y,int z){
            this.x =x;
            this.y =y;
            this.z =z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Vector<length> v = new Vector<>();
         int x=1,y=1,z=1;
         while(true){
             String[] n = sc.nextLine().split(" ");
             x=Integer.parseInt(n[0]);
             y=Integer.parseInt(n[1]);
             z=Integer.parseInt(n[2]);
             if(x==0 && y==0 && z==0){
                 break;
             }
             v.add(new length(x,y,z));
         }

        for (length l : v) {
            int[] sides = {l.x, l.y, l.z};
            Arrays.sort(sides);

            if (sides[0]*sides[0] + sides[1]*sides[1] == sides[2]*sides[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

         sc.close();

    }
}
