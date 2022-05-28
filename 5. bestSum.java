Brute Force Approach:-
import java.util.*;
public class bestSum {
    static int min = Integer.MAX_VALUE;
    static List<Integer> fin;
    static HashMap<Integer, List<Integer>> memo = new HashMap<>();
    public static void bestSum(int s, int[]arr, List<Integer> res){
        if(s == 0){
            if(res.size()<min){
                fin = new LinkedList<>(res);
                min = res.size();
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]>s) continue;
            res.add(arr[i]);
            bestSum(s-arr[i], arr, res);
            res.remove(res.size()-1);
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[]arr = {2,5,1,1,5,3,3,1};
        bestSum(7,arr, new LinkedList<>());
        System.out.println(fin);
    }
}

Memoization:-
import java.util.*;
public class bestSum_optimized {
    static HashMap<Integer, List<Integer>> memo = new HashMap<>();
    public static List<Integer> bestSum(int s, int[]arr){
        if(memo.containsKey(s)) return memo.get(s);
        if(s==0) return new LinkedList<>();
        if(s<0) return null;
        List<Integer> shortestsum = null;
        for(int n: arr){
            List<Integer> sum = bestSum(s-n, arr);
            if(sum!=null){
                sum.add(n);
                if(shortestsum==null || sum.size()<shortestsum.size()){
                    shortestsum = new LinkedList<>(sum);
                }
            }
        }
        memo.putIfAbsent(s,new LinkedList<>());
        memo.put(s,shortestsum);
        return shortestsum;
    }
    public static void main(String[]args){
        int[]arr = {5,3,4,7};
        System.out.println(bestSum(7,arr));
    }
}
