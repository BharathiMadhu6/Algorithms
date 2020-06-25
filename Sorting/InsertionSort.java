package Sorting;

public class InsertionSort {

    public void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args){
        InsertionSort insert = new InsertionSort();
        int[] arr = {4,3,2,10,12,1,5,6};
        insert.insertionSort(arr);
        for(int k : arr){
            System.out.print(k+" ");
        }


    }
}
