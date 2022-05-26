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
