public class merger {
    public static void main(String[] args) {
        int[] arr = {4,11,5,6,2,4};
        for(int n:arr){
            System.out.print(n+" ");
        }
        System.out.println("\nAfter sort:\n");
        int low = 0, high = arr.length-1;
        mergesort(arr,low,high);
        for(int n:arr){
            System.out.print(n+" ");
        }
    }

    private static void mergesort(int[] arr, int l, int r) {
        if(l<r){
            int mid = (l+r)/2;
            mergesort(arr,l,mid);
            mergesort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;

        int[] larr = new int[n1];
        int[] rarr = new int[n2];
        for(int x=0;x<n1;x++){
            larr[x] = arr[l+x];
        }
        for(int x=0;x<n2;x++){
            rarr[x] = arr[mid+x+1];
        }
        int i = 0,j = 0,k=l;
        while(i<n1 && j<n2){
            if(larr[i]<rarr[j]){
                arr[k] = larr[i];
                i++;
            }
            else{
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = larr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }
}
