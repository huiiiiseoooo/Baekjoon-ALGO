import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String item = sc.next();
            if(list.isEmpty()){
                list.add(item);
            }
            else{
                for(int j = 0; j < list.size(); j++){
                    if(item.length() > list.get(j).length()){
                        continue;
                    }
                    else if(item.length() < list.get(j).length()){
                        list.add(j, item);
                        break;
                    }
                }
            }

        }
        System.out.println(list);

    }
    public static String compare(List<String>)
}