import java.math.BigInteger;
import java.util.*;

public class MinCostClimibingTree {
//10,15,20
    int min= Integer.MAX_VALUE;
    public void mincost(int[] arr,int index,int cost){
        if(index==arr.length || index>arr.length){
            if(min>cost){
                min=cost;
            }
        return;
        }
        if(index+1<arr.length) {
            cost=arr[index+1]+cost;
        }
        mincost(arr, index + 1, cost);
        if(index+1<arr.length){
            cost=cost-arr[index+1];
        }
        if(index+2<arr.length){
            cost=cost+arr[index+2];
        }
        mincost(arr, index + 2,  cost);
        }


    public static void main(String[] args){
        int[] cost1 ={10,15,20};
        MinCostClimibingTree obj= new MinCostClimibingTree();
        obj.mincost(cost1,-1,0);
        System.out.println(obj.min);
        int[] cost2={1,100,1,1,1,100,1,1,100,1};
        obj.mincost(cost2,-1,0);
        System.out.println(obj.min);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.keySet();

    Integer val=1;
    if(val == 1){
        System.out.println("inside if");
    }


    }

}
