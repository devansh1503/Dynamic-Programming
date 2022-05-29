import java.util.*;
public class canConst {
    static HashMap<String, Boolean> memo = new HashMap<>();
    public static boolean canconst(String s, String[]arr){
        if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()) return true;
        for(String a : arr){
            int n = a.length();
            if(s.length()<n) continue;
            if(s.substring(0,n).equals(a)){
                memo.putIfAbsent(s,false);
                memo.put(s,canconst(s.substring(n,s.length()), arr));
                if(memo.get(s)) return memo.get(s);
            }
        }
        return false;
    }
    public static void main(String[]args){
        String[]arr = {"ab","abc","cd","def","abcd"};
        System.out.println(canconst("abcdef",arr));
    }
}
