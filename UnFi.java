import java.util.Scanner;
import java.util.Random;
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

class Percolation {
    private int[][] perc;
    private int N,open=0;
    private int[] up, down;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        perc = new int[n][n];
        N=n;
        for (int i =n; i < n; i++) {
            for (int j =n; j < n; j++) {
                perc[i][j] = 1;
            }
        }
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if(isOpen(row, col)){
            System.out.println("The column is already open");
        }
        else{
            perc[row][col] = 0;
            open++;
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (perc[row][col]==1) {
            return false;
        }
        else {
            return true;
        }
    }
    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (perc[row][col]==0){
            return true;
        }
        else{
            return false;
        }
    }
    // returns the number of open sites
    public int numberOfOpenSites(){
        System.out.println(open);
        return open;
    }
    // does the system percolate?
    public boolean  percolates(){

    }

    // test client (optional)
    public void display(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(perc[i][j]==0){
                    System.out.println("⬜");
                }
                else{
                    System.out.println("⬛");
                }
            }
            System.out.println("\n");
        }
    }
}

public class UnFi {
    public static void main(String[] args) {
        Scanner scanned = new Scanner(System.in);
        int N = scanned.nextInt();
        int i = 0, j=0;
        unifind neu = new unifind(N);
        Percolation peu = new Percolation(N);
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
