import java.util.*;
public class allConst {
    static HashMap<String, Integer> memo = new HashMap<>();
    static List<List<String>> res = new LinkedList<>();
    static List<String>comb = new LinkedList<>();
    public static void allconst(String s, String[]arr){
        //if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()) res.add(new LinkedList<>(comb));
        for(String a : arr){
            int n = a.length();
            if(s.length()<n) continue;
            if(s.substring(0,n).equals(a)){
                //memo.putIfAbsent(s,0);
                comb.add(a);
                allconst(s.substring(n,s.length()), arr);
                comb.remove(a);
                //if(memo.get(s)) return memo.get(s);
            }
        }
        //memo.putIfAbsent(s,0);
        //memo.put(s,res);
    }
    public static void main(String[]args){
        String[]arr = {"ab","abc","cd","def","abcd","ef"};
        allconst("abcdef",arr);
        System.out.println(res);

    }
}
