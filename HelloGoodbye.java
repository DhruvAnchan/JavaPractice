import java.util.Scanner;

class HelloGoodbye {
    public static void main(String[] args){
        System.out.print("Enter your name: ");
        Scanner scanned = new Scanner(System.in);
        String inp = scanned.nextLine();
        System.out.print("\nGood morning ");
        System.out.println(inp);
        scanned.close();
    }
}
