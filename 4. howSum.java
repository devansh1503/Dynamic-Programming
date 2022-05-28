Brute Force:-
import java.util.*;
public class howSum {
    public static void howsum(int s, int[]arr,List<Integer>res, List<List<Integer>> results){
        if(s==0){
            results.add(new LinkedList<>(res));
        };
        for(int i=0; i<arr.length; i++){
            if(arr[i]>s) continue;
            res.add(arr[i]);
            howsum(s-arr[i],arr,res,results);
            res.remove(res.size()-1);
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[]arr = {5,3,4,7};
        List<List<Integer>> results = new LinkedList<>();
        howsum(7,arr,new LinkedList<>(),results);
        System.out.println(results);
    }
}

Memoized:-
import java.util.*;
public class howSum_optimized {
    static HashMap<Integer, List<Integer>> memo = new HashMap<>();
    public static List<Integer> howSum(int s, int[]arr){
        if(memo.containsKey(s)) return memo.get(s);
        if(s==0) return new LinkedList<>();
        if(s<0) return null;
        for(int n : arr){
            memo.putIfAbsent(s,new LinkedList<>());
            memo.put(s,howSum(s-n,arr));
            if(memo.get(s)!=null){
                memo.get(s).add(n);
                return memo.get(s);
            }
        }
        return null;
    }
    public static void main(String[]args){
        int[]arr = {5,3,4,2,5,8};
        System.out.println(howSum(7,arr));
    }
}
