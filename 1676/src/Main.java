import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size=0;
        for(int i=1; i<n+1; i++){
            if( i%125==0){
                size+=3;
            }
            else if(i%25==0){
                size+=2;
            }
            else if(i%5==0){
                size+=1;
            }
        }

        System.out.println(size);



    }
}
