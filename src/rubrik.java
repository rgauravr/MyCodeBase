/*
Your given 2D array which contains coins. You can move either move towards right or down from any position.

Find the maximum number of coins you can get, starting from position 0,0 .



Input constraints :

1<=row<=2000

1<=column<=2000

1<=number_of_coins_at_any_index<=1000



Output: Return integer



Note: You can not move diagonally.



Example 1

Input:

8	2	9
6	1	7


Output : 26

From this path you can fetch maximum  coins i.e From (0,0) you move to right and from (0,1) again you move right(0,2) and from (0,2) move down(1,2).

8+2+9+7=26



Example 2:

1	4	2	3
7	8	2	9
1	5	7	5


Output: 33

Path Traversed is as follows:

From (0,0) ->(1,0) -> (1,1) ->(2,1)->(2,2) ->(2,3)

1+7+8+5+7+5=33
 */

import java.util.ArrayList;
import java.util.HashMap;

@FunctionalInterface
interface mySum{

    public int sum(int a, int b);

}

class demos{

     public static void main(String[] args){
        mySum obj = (a,b)->{
            return a+b;
        };
         System.out.println(obj.sum(1,2));
         System.out.println((1|1)|(1));


     }
}
public class rubrik {

    public  static void main(String[] args){
        int[][] coins = new int[][]{{1,4,2,3},{7,8,2,9},{1,5,7,5}};

        //find maximum coin to collect

        //using dp

        int[][] dp = new int[coins.length][coins[0].length];

        int row =coins.length;
        int col=coins[0].length;
        dp[0][0]=coins[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(i>0 && j>0){

                    //It means we have 2 options either coming from above or coming from left
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+coins[i][j];
                }else if(i>0){
                    //Here j=0, It means we have only one option that is coming from above
                    dp[i][j]=dp[i-1][j]+coins[i][j];
                }else if(j>0){
                    //here i==0 it means coming from left

                    dp[i][j]=dp[i][j-1]+coins[i][j];
                }

            }

        }
        System.out.println(dp[row-1][col-1]);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(1,1);
        System.out.println(hmap);
        if(hmap.containsKey(1))
            hmap.remove(1);

        System.out.println(hmap);
        ArrayList<Integer> res = new ArrayList<>();
        
    }
}
