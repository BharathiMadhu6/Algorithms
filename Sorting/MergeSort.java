package Sorting;

public class MergeSort {

    public void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        for(int i = 0; i < n1; ++i){
            temp1[i] = arr[l+i];
        }

        for(int j = 0; j < n2; ++j){
            temp2[j] = arr[m+1+j];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(temp1[i] <= temp2[j]){
                arr[k] = temp1[i];
                i++;
            }
            else {
                arr[k] = temp2[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            arr[k] = temp1[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l + r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr,mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void main(String[] args){
        MergeSort merge = new MergeSort();
        int[] arr = {14,7,3,161,3,22,1};
        merge.mergeSort(arr,0,arr.length-1);

        for(int k : arr){
            System.out.print(k+" ");
        }
    }
}
