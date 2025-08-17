public class Main{
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.show();
        int x = queue.dequeue();
        System.out.println(x);
        x = queue.dequeue();
        System.out.println(x);        
        queue.show();
        queue.peek();
    }
}
