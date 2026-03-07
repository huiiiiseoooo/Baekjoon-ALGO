import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {

            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            s = s.substring(1, s.length()-1);

            int[] arr;
            if(n == 0){
                arr = new int[0];
            }else{
                String[] tokens = s.split(",");
                arr = new int[n];
                for(int i = 0; i < n; i++){
                    arr[i] = Integer.parseInt(tokens[i]);
                }
            }

            int left = 0;
            int right = n - 1;
            boolean reversed = false;
            boolean error = false;

            for(int i = 0; i < commands.length(); i++) {

                char cmd = commands.charAt(i);

                if(cmd == 'R'){
                    reversed = !reversed;
                }
                else if(cmd == 'D'){

                    if(left > right){
                        sb.append("error\n");
                        error = true;
                        break;
                    }

                    if(!reversed){
                        left++;
                    }else{
                        right--;
                    }
                }
            }

            if(error) continue;

            sb.append("[");

            if(!reversed){
                for(int i = left; i <= right; i++){
                    sb.append(arr[i]);
                    if(i != right) sb.append(",");
                }
            }else{
                for(int i = right; i >= left; i--){
                    sb.append(arr[i]);
                    if(i != left) sb.append(",");
                }
            }

            sb.append("]\n");
        }

        System.out.print(sb);
    }
}