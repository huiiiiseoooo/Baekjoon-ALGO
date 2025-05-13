import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int h,w,n, floar, num;
            h = sc.nextInt(); w = sc.nextInt(); n = sc.nextInt();
            if(n%h == 0){
                floar = h;
                num = n/h;
            }else{
                floar = n%h;
                num = n/h+1;
            }


            System.out.println(floar*100+ num);
        }
        sc.close();
    }
}