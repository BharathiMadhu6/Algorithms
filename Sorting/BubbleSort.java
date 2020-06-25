package Sorting;

public class BubbleSort {

    public void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j <= n-2; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {5,1,4,99,0};
        BubbleSort bub = new BubbleSort();
        bub.bubbleSort(arr);
        for(int k : arr){
            System.out.print(k+" ");
        }
    }
}
