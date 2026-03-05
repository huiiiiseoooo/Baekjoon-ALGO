import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        while (true) {
               s=br.readLine().split(" ");
               if(s[0].equals("0") && s[1].equals("0")) {
                   break;
               }

               if(Integer.parseInt(s[0])<= Integer.parseInt(s[1])){
                   System.out.println("No");
               }else{
                   System.out.println("Yes");
               }

        }
    }
}