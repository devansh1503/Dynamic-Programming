import java.util.*;
public class fib_mem {
    public static int fib(int n, int[]memo){
        if(n<=2) return 1;
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = fib(n-1, memo)+fib(n-2,memo);
        return memo[n];
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]memo = new int[1000];
        Arrays.fill(memo,0);
        System.out.println(fib(n,memo));
    }
}

Tabulation:
import java.util.*;
public class fib_tab {
    public static int fib(int n){
        int[]arr = new int[n+1];
        Arrays.fill(arr,0);
        arr[1] = 1;
        for(int i=0; i<=n; i++){
            if(i+1<=n){
                arr[i+1] += arr[i];
            }
            if(i+2<=n){
                arr[i+2] += arr[i];
            }
        }
        return arr[n];
    }
    public static void main(String[]args){
        System.out.println(fib(6));
    }
}
