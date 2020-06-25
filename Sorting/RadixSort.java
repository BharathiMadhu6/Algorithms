package Sorting;

public class RadixSort {

    public int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public void countSort(int[] arr, int n, int exp){
        int[] output = new int[n];
        int[] countArr = new int[10];
        for(int i = 0; i < 10; i++){
            countArr[i] = 0;
        }

        for(int i = 0; i < n; i++){
            countArr[ (arr[i]/exp)%10 ]++;
        }

        for(int i = 1; i < 10; i++){
            countArr[i] += countArr[i-1];
        }

        for(int i = n-1; i >= 0; i--){
            int count = countArr[ (arr[i]/exp)%10 ];
            output[count - 1] = arr[i];
            countArr[ (arr[i]/exp)%10 ]--;
        }

        for(int i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }

    public void radixSort(int[] arr){
        int max = findMax(arr);
        int n = arr.length;
        for(int exp = 1; (max/exp) > 0; exp *= 10){
            countSort(arr,n,exp);
        }
    }

    public static void main(String[] args){
        RadixSort radix = new RadixSort();
        int[] arr = {70,45,75,90,80,24,2,66};
        radix.radixSort(arr);
        for(int k : arr){
            System.out.print(k+" ");
        }
    }
}
