import java.util.*;
public class canSum {
    public static boolean cansum(int s, int[]arr,boolean[]memo){
        if(memo[s]!=false) return memo[s];
        if(s==0) return true;
        boolean res = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>s) continue;
            memo[s] = cansum(s-arr[i], arr,memo);
            if(memo[s]) return true;
        }
        return memo[s];
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[]arr = {5,3,4,7};
        boolean[]memo = new boolean[8];
        System.out.println(cansum(7, arr,memo));
    }
}

Tabulation:
import java.util.*;
public class canSum_tab {
    public static boolean canSum(int s, int[]arr){
        boolean[]tab = new boolean[s+1];
        Arrays.fill(tab,false);
        tab[0] = true;
        for(int i=0; i<=s; i++){
            if(tab[i] == false) continue;
            for(int n : arr){
                if(i+n<=s){
                    tab[i+n] = true;
                }
            }
        }
        return tab[s];
    }
    public static void main(String[]args){
        int[]arr = {5,3,4};
        System.out.println(canSum(7,arr));
    }
}
