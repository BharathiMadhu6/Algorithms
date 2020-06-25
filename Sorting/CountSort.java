package Sorting;

public class CountSort {

    public int[] countSort(int[] arr){
        int n = arr.length;
        int[] output = new int[n];
        int max = arr[0];
        for(int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] countArr = new int[max+1];

        for(int k = 0; k < max; k++){
            countArr[k] = 0;
        }

        for(int k = 0; k < n; k++){
            countArr[arr[k]]++;
        }

        for(int j = 1; j <= max; j++){
            countArr[j] += countArr[j-1];
        }

        for(int j = n-1; j >= 0; j--) {
            int count = countArr[arr[j]];
            output[count-1] = arr[j];
            countArr[arr[j]]--;
        }
        return output;
    }

    public static void main(String[] args){
        CountSort count = new CountSort();
        int[] arr = {1,4,1,2,7,9,2,1};
        int[] out = count.countSort(arr);
        for(int k : out){
            System.out.print(k+" ");
        }
    }
}
