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

class percolation{
    public void perc(){
        
    }
}

public class UnFi {
    public static void main(String[] args) {
        Scanner scanned = new Scanner(System.in);
        int N = scanned.nextInt();
        int i = 0, j=0;
        unifind neu = new unifind(N);
        while(scanned.hasNext()){
            i = scanned.nextInt();
            j = scanned.nextInt();
            neu.union(i, j);
        }
        j = 1;
        for(i = 0;i<N;i++){
            if(neu.find(j, i)){
                System.out.print(j);
                System.out.print(" is connected to ");
                System.out.print(i);
                System.out.print("\n");
            }
        }
    }
}
