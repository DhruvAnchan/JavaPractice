import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class unifind{
    private int[] id;
    private int[] sz;
    private int N;
    public unifind(int n){
        N=n;
        int N2 = N*N;
        id = new int[N2];
        sz = new int[N2];
        for(int i=0; i<N2; i++){
            if(i<N){
                id[i]=0;
            }
            else if(i>=N2-N-1){
                id[i]=N2-1;
            }
            else{
                id[i] = i;
            }
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
    public void disp(){

        for (int i = 0; i < N*N; i++) {
            System.out.print(id[i] + "\t");
            if ((i + 1) % N == 0) System.out.println();

        }
    }
} 

class Percolator extends unifind {
    private int[][] perc;
    private int[][] id;
    private int N,N2,open=0;
    // creates n-by-n grid, with all sites initially blocked
    public Percolator(int n){
        super(n);
        perc = new int[n][n];
        id = new int[n][n];
        int k;
        
        N=n;
        N2 = n*n;
        for (int i =0; i < n; i++) {
            for (int j =0; j < n; j++) {
                k=n*i;
                perc[i][j] = 1;
                if(i==0){
                    id[i][j] = 0;
                }
                else if(i==n-1){
                    id[i][j] = N2-1;
                }
                else{
                    id[i][j] = j+k;
                }
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
            if(row>0){
                if(perc[row-1][col]==0 && (id[row-1][col]==0 || id[row-1][col]==N2-1)){
                    super.union(id[row-1][col], id[row][col]);
                }
            }        
            if(col>0){
                if(perc[row][col-1]==0 && (id[row][col-1]==0 || id[row][col-1]==N2-1)){
                    super.union(id[row][col-1],id[row][col]);
                }
            }  
            if(row<N-1){
                if(perc[row+1][col]==0 && (id[row+1][col]==0 || id[row+1][col]==N2-1)){
                    super.union(id[row+1][col],id[row][col]);
                }
            }
            if(col<N-1){
               if(perc[row][col+1]==0 && (id[row][col+1]==0 || id[row][col+1]==N2-1)){
                    super.union(id[row][col+1],id[row][col]);
                    
                } 
            }
            open++;
        }
    }
    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if(perc[row][col]==1) {
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
    public boolean percolates(){
        
        for (int i = 0; i < N; i++) {
            if(id[0][i]==N2-1 || id[N-1][i] == 0){
                return true;
            }   
        }
        return false;
    }

    //visual display
    public void display(){
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(perc[i][j]==0){
                    System.out.print("O\t");
                }
                else{
                    System.out.print("X\t");
                }
            }
            System.out.println("\n");
        }
        System.out.println("The union matrix is: ");
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(id[i][j]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("The internal matrix is: ");
        super.disp();
        System.out.println("Display operation ended");
    }
}

public class Percolation {
    public static void main(String[] args) {
        Scanner scanned = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Enter size of square");
        int N = scanned.nextInt();
        scanned.close();
        int N2 = N*N;
        int i,j,k=0,count=0,randno,randnum;
        Percolator peu = new Percolator(N);
        ArrayList<Integer> num = new ArrayList<>();
        for (i = 0; i < N2; i++) {
            num.add(i);
        }
        for(i = 0; i<N2-2; i++){
            randno = rand.nextInt(num.size());
            randnum = num.get(randno);
            System.out.println("Random num"+randnum);
            num.remove(randno);
            int row = randnum/N;
            int col = randnum%N;
            peu.open(row,col);
        }
        peu.display();
        float open = peu.numberOfOpenSites();
        float NN = N2; 
        float perco = (open/NN)*100;
        boolean truth = peu.percolates();

        System.out.println("Does the system Percolate at "+perco+"%: "+truth);
        
    }
}