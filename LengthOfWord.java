public class LengthOfWord {
    public static void main(String[] args) {
        String s = "Hello my name is Dhruv";
        System.out.println(WordLengthLast(s)); 
    }
    static int WordLengthLast(String s){
        int count = 0;
        String str = s.trim();
        for(int i = str.length()-1; i>=0 ;i--){
            if(str.charAt(i) != ' ')
                count += 1;
            else
                break;
        }

        return count;
    }
}