import javax.management.RuntimeErrorException;

public class Queue {
    private int front=0;
    private int rear=-1;
    private int size=0;
    private int[] arr;
    private int sizestop;
    public Queue(int size){
        this.arr = new int[size];
        this.sizestop = size;
    }
    
    public void enqueue(int data){
        if(isFull())
            throw new RuntimeException("Queue is full");
        rear++;
        arr[rear]=data;
        size++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new RuntimeException("Queue is empty");
        front++;
        size--;
        return arr[front-1];
    }

    public int peek(){
        return arr[front];
    }

    public boolean isFull(){
        if(size == sizestop)
            return true;
        else
            return false;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

    public void show(){
        for(int i=front;i<front+size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
