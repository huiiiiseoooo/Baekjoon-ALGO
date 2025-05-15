import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            String item = sc.next();
            boolean s = false;
            for(String same : list){
                if(item.equals(same)){
                    s = true;
                }
            }
            if(s){
                continue;
            }
            boolean b = false; //불 변수 활용을 잘하자!!!!
            for(int j = 0; j < list.size(); j++){
                if(item.length()<list.get(j).length()){
                    list.add(j, item);
                    b = true;
                    break;
                }else if(item.length()==list.get(j).length()){
                    if(item.compareTo(list.get(j))<0){ //compareTo메소드 공부필요
                        list.add(j, item);
                        b = true;
                        break;
                    }
                }
            }
            if(!b){
                list.add(item);
            }
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}
//정렬을 뼈저리게 느낀 문제