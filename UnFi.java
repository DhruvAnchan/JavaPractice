import java.util.Random;
import java.util.Scanner;

class unifind{
    private int[] id;
    private int[] sz;
    public unifind(int N){
        id = new int[N];
        sz = new int[N];
        for(int i=0; i<N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int root(int k){
        while (k != id[k]){
            id[k] = id[id[k]];
            k=id[k];
        }   
        return k;
    }
    public void union(int i, int j){
        i = root(i);
        j = root(j);
        if(sz[i]<sz[j]){id[i] = j;sz[j] += sz[i];}
        else{id[j] = i;sz[i] += sz[j];}
    }   
    public boolean find(int p, int q){
        return (root(p) == root(q));
    }
} 

public class UnFi {
    public static void main(String[] args) {
        Scanner scanned = new Scanner(System.in);
        Random rand = new Random();
        int N = scanned.nextInt();
        int i,j=0,k=0,m=0;
        int[] loop = new int[N];
        unifind neu = new unifind(N);
        for (i = 0; j < N; j++) {
            loop[i]=i;
        }
        System.out.println("How many changes do you want to make: ");
        int num = scanned.nextInt();
        for(k=0;k<num;k++){
            i = scanned.nextInt();
            j = scanned.nextInt();
            neu.union(i, j);
        }
        System.out.println("Which values do you wanna check");
        while(scanned.hasNext()){
            i=scanned.nextInt();
            j=scanned.nextInt();
            if(neu.find(i, j)){
                System.out.println(i+" is connected to "+j);
            }
            else{
                System.out.println(i+" is not connected to "+j);
            }
            System.out.println("Which values do you wanna check");
        }
    }
}
