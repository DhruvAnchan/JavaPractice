public class FirstOccurance {
    public static void main(String[] args) {
        String string = "saabutnotsad";
        String target = "sad";
        int x = FirstOccur(string,target);
        System.out.println(x);
    }
    static int FirstOccur(String s, String tar){
        if(tar.length()==0 || tar == null)
            return 0;
        int slen = s.length(),tarlen = tar.length();
        if(slen<tarlen)
            return -1;
        for(int i = 0; i<=slen-tarlen; i++){
            if(s.substring(i,i+tarlen).equals(tar))
                return i;
        }
        return -1;
    }
}
