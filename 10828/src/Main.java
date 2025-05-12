import java.util.Scanner;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> stack = new Vector<Integer>();
        int n = sc.nextInt();
        String[] s;
        for (int i = 0; i < n+1; i++) {
            s = sc.nextLine().split(" ");
            switch (s[0]){
                case "push":
                    stack.add(Integer.parseInt(s[1]));
                    break;

                case "pop":
                    if(stack.size()==0){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(stack.remove(stack.size()-1));
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.size()==0){
                        System.out.println("1");
                    }
                    else{
                        System.out.println("0");
                    }
                    break;

                case "top":
                    if(stack.size()==0){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(stack.get(stack.size()-1));
                    break;
            }

        }

    }
}
