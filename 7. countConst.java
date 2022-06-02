import java.util.*;
public class countConst {
    static HashMap<String, Integer> memo = new HashMap<>();
    public static int countconst(String s, String[]arr){
        if(memo.containsKey(s)) return memo.get(s);
        if(s.isEmpty()) return 1;
        int res = 0;
        for(String a : arr){
            int n = a.length();
            if(s.length()<n) continue;
            if(s.substring(0,n).equals(a)){
                //memo.putIfAbsent(s,0);
                res = res + countconst(s.substring(n,s.length()), arr);
                //if(memo.get(s)) return memo.get(s);
            }
        }
        memo.putIfAbsent(s,0);
        memo.put(s,res);
        return res;
    }
    public static void main(String[]args){
        String[]arr = {"ab","abc","cd","def","abcd","ef"};
        System.out.println(countconst("abcdef",arr));
    }
}

Tabulation:-

import java.util.*;
public class countConst_tab {
    public static int canConst(String s, String[] arr) {
        int[] tab = new int[s.length() + 1];
        Arrays.fill(tab,0);
        tab[0] = 1;
        int res = 0;
        for (int i = 0; i < tab.length; i++) {
                for (String a : arr) {
                    int n = a.length();
                    if(i+n>s.length()) continue;
                    if (s.substring(i, i + n).equals(a)) {
                        tab[i + n] += tab[i];
                    }
                }

        }
        return tab[s.length()];
    }
    public static void main(String[]args){
        String[]arr = {"ab","abc","cd","def","abcd","ef"};
        System.out.println(canConst("abcdef",arr));
    }
}
