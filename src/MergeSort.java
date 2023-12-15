public class MergeSort {


    public void mergesort(int low, int high, int[] arr){

        if(low<high){
            int mid=(low+high)/2;
            mergesort(low,mid,arr);
            mergesort(mid+1,high,arr);
            merge(low,mid,high,arr);
        }
    }

    public void merge(int low, int mid, int high, int[]arr){

        int[] left = new int[mid-low+1];
        int[] right = new int[high-mid];

        int n=left.length;
        int m=right.length;

        for(int i=0;i<n;i++){
            left[i]=arr[low+i];
        }

        for(int i=0;i<m;i++){
            right[i]=arr[mid+1+i];
        }



        int i=0,j=0,k=low;

       while (i<n && j<m){

           if(left[i]<=right[j]){
               arr[k]=left[i];
               k++;
               i++;
           }else{
               arr[k]=right[j];
               j++;
               k++;
           }
       }

        if(i<n){
            while(i<n){

                arr[k++]=left[i++];
            }
        }

        if(j<m){
            while(j<m){

                arr[k++]=right[j++];
            }
        }
    }


    public static void main(String[] args){
        int[] arr =new int[]{5,2,1,5,2,16,63};
        for(int val: arr)
            System.out.println(val);
        new MergeSort().mergesort(0,arr.length-1,arr);

        for(int val: arr)
        System.out.println(val);
    }
}
