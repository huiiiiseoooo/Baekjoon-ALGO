import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
map을 사용해서 풀기

Character.isDigit()  char형 문자하나가 숫자인지 문자인지 구분 숫자이면 true 그외 false
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int quiz = Integer.parseInt(input[1]);
        HashMap<String, Integer> map = new HashMap<>();
        String[] names = new String[num];

        for(int i=0; i<num; i++) {
            String s = br.readLine();
            map.put(s, i);
            names[i] = s;
        }

        for(int i=0; i<quiz; i++) {
            String s = br.readLine();
            if(Character.isDigit(s.charAt(0))){
                System.out.println(names[Integer.parseInt(s) - 1]);
            }else{
                System.out.println(map.get(s)+1);
            }
        }
    }
}