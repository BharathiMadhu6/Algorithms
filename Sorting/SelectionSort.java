package Sorting;

public class SelectionSort {
    public void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr = {64,0,1,6,0};
        SelectionSort sort = new SelectionSort();
        sort.selectionSort(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
