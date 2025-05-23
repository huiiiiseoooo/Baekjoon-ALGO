
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int left = 0, mid, right = arr.length - 1;


    }

    public static void merge(int[] arr, int left, int right){
        if(left<right){
            merge(arr, left, (left+right)/2);
            merge(arr, (left+right)/2+1, right);
            merge_sort(arr, left, right);
        }
    }

    public static void merge_sort(int[] arr, int left, int right){
        int i = left,mid = (left+right)/2, j = mid+1, k = left;
        int[] temp = new int[arr.length];
        while(i<left && j<right ){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++]
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        if(i>mid){
            for(int )
        }
    }
}