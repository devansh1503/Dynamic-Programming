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
