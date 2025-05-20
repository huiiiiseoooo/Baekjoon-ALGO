import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int weight = sc.nextInt();
        char[][] list = new char[height][weight];
        int emptyw = 0, emptyh = 0;
        for(int i=0; i<height; i++){
            list[i] = sc.next().toCharArray();
        }

        for(int i=0; i<height; i++){
            boolean temp = false;
            for(char k:list[i]){
                if(k == 'X'){
                    temp = true;
                }
            }
            if(!temp){
                emptyw++;
            }
        }

        for(int i=0; i<weight; i++){
            boolean temp = false;
            for(int j=0; j<height; j++){
                if(list[j][i] == 'X'){
                    temp = true;
                }
            }
            if (!temp) {
                emptyh++;
            }
        }

        if(emptyh-emptyw>=0){
            System.out.println(emptyh);
        }else{
            System.out.println(emptyw);
        }

        sc.close();
    }
}