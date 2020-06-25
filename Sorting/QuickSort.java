package Sorting;

public class QuickSort {

    public int partition(int[] arr, int low, int high){
        int i = -1;
        int pivot = arr[high];
        for(int j = 0; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp2 = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp2;

        return i+1;
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr,low,high);

            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args){
        int[] arr = {10,80,30,90,40,50,70};
        QuickSort quick = new QuickSort();
        quick.quickSort(arr,0,arr.length-1);
        for(int k : arr){
            System.out.print(k+" ");
        }
    }
}
