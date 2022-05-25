import java.util.*;
public class gridTravel {
    public static int gridt(int i, int j, HashMap<String, Integer> memo, int c){
        String key = String.valueOf(i)+','+String.valueOf(j);
        if(memo.containsKey(key)) return memo.get(key);
        if(i==1 && j==1) return 1;
        if(i==0 || j==0) return 0;

        memo.put(key,gridt(i-1,j,memo,c) + gridt(i,j-1,memo,c));
        return memo.get(key);

    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        HashMap<String, Integer> memo = new HashMap<>();
        int res = gridt(r,c,memo,c);
        System.out.println(res);
    }
}
