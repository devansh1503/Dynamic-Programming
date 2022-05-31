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

Tabulation:
import java.util.*;
public class grid_tab {
    public static int grid(int i, int j){
        int[][]arr = new int[i+1][j+1];
        for(int[]ar : arr){
            Arrays.fill(ar,0);
        }
        arr[1][1] = 1;
        for(int x=0; x<=i; x++){
            for(int y=0; y<=j; y++){
                if(x+1<=i){
                    arr[x+1][y] += arr[x][y];
                }
                if(y+1<=j){
                    arr[x][y+1] += arr[x][y];
                }
            }
        }

        return arr[i][j];
    }
    public static void main(String[]args){
        System.out.println(grid(3,3));
    }
}
