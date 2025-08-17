public class Main{
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();
        nums.add(2);
        nums.add(3);
        nums.printValues();
        nums.insert(5);
        nums.printValues();
        nums.delete(3);
        nums.printValues();
    }
}
