import java.util.Random;
import java.util.Scanner;

class RandomWord{
    public static void main(String[] args) {
        Random rand = new Random();
        int count=0;
        String output = null;
        System.out.println("Enter your string");
        try (Scanner scanned = new Scanner(System.in)) {
            while (scanned.hasNext()) {
                String word = scanned.next();
                count++;
                if(rand.nextInt(count)==0){
                    output = word;
                }
            }
            System.out.println(output);
            System.out.println("count = ");
            System.out.println(count);
        }
        catch(Exception e){
            System.err.println(".()");
        }
    }
}