package Sorting;

public class HeapSort {

    public void heapSort(int[] arr){
        int n = arr.length;

        for(int i = (n/2) - 1; i >= 0; i--){
            heapify(arr, n, i);
        }

        for(int i = n-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args){
        HeapSort hs = new HeapSort();
        int[] arr = { 12, 4, 11, 5, 6, 13};
        hs.heapSort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
