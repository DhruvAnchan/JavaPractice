public class reverse {
    public static void main(String[] args) {
        String str = "Race.     justin";
        String[] rev = reverser(str);
        System.out.println(rev);
    }
    static String[] reverser(String s){
        return s.split(" +");
    }
}
