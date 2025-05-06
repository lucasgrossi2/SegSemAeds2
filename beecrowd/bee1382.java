import java.util.*;

public class bee1382{

    public static void insertionSort(int[] arr){
        int trocas = 0;
        int len = arr.length;
        for(int i = 1; i < len; i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
                trocas++;
            }
            arr[j+1] = key;
            
        }
        System.out.println(trocas);
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int instancias = sc.nextInt();
        for(int i = 0; i < instancias; i++){
            int num = sc.nextInt();
            int[] arr = new int[num];
            for(int j = 0; j < num; j++){
                arr[j] = sc.nextInt();
            }
            insertionSort(arr);
        }
        sc.close();
    }
}


