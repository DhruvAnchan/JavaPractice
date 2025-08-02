import java.util.HashMap;
public class test {
    public static void main(String[] args) {
        String[] str = {"Hello", "james", "jedi"};
        HashMap<Character,Integer> x = new HashMap<>(){{
            for(char word:str){
                put(word,1);
            }
        }};
        System.out.println(x);
        for(int i = 1; i<str.length; i++){
            for(int j = 0; j<str[i].length();j++){
                if(x.containsKey(str[i].charAt(j)))
                    ;
            }
        }

    }
}
