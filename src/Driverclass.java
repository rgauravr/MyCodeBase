import java.util.*;

/*
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
{
    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
       // int t= in.nextInt();
       // while(t-->0){

            int n = in.nextInt();
            int [] arr= new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = in.nextInt();
            }


            System.out.println(arr.length);

            System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
       // }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    int count =0;
    public boolean equalNumZeroAndOne(int arr[],int start,int end){
        boolean res=false;
        int zero=0,one=0;
        if(end >=arr.length || start >= arr.length )
            return false;
        for(int i= start; i<=end ; i++ )
        {
            if(arr[i]==0)zero++;
            else
                one++;
        }
        if(one==zero)
            res=true;

        return res;
    }

    public int allPossibleSubString(int []arr,int n, int start,int end){


 if(start==n && end==n)
            return count;

        if(end == n){
            return allPossibleSubString(arr,n,start+1,start+1);
        }
        else {
            if((end-start)%2!=0 && equalNumZeroAndOne(arr,start,end))
                count++;
            return allPossibleSubString(arr,n,start,end+1);

        }

       for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j=j+2){
                if((j-i)%2!=0 && equalNumZeroAndOne(arr,i,j))
                    count++;

            }
        }

        return count;
    }
}


*/
/*
public class Driverclass{

    public Set<List<Integer>> printSumOfSDubset(int[] arr, List<Integer> list, int sum, int index, Set<List<Integer>> st){
        if(index==arr.length){
            st.add(new ArrayList<>(list));
            //System.out.println("list "+ list);
        //   System.out.println(st);
            return st;
        }
        list.add(arr[index]);
        sum=sum+arr[index];
        printSumOfSDubset(arr,list,sum,index+1,st);
        sum = sum - arr[index];
        list.remove(list.size()-1);
        printSumOfSDubset(arr,list,sum,index+1,st);
  return st;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        int[] arr={1,2,1,1};
        System.out.println(new Driverclass().printSumOfSDubset(arr,new ArrayList<Integer>(),0,0,new HashSet<List<Integer>>()));
    }
}*/

class TwoSum {
    HashMap<Integer, Integer> hmap;

    public TwoSum() {
        hmap = new HashMap<>();
    }

    public void add(int val) {
        if (hmap.get(val) == null) {
            hmap.put(val,1);

        } else
            hmap.put(val, hmap.get(val) + 1);
    }

    public boolean find(int val) {
        boolean res = false;
        int target=0;
        for(int ele: hmap.keySet()) {
            if (ele >= val)
                target = ele - val;
            else
                target =val-ele;

            if(hmap.get(target)!=null && hmap.get(target)>=1){
                res=true;
                return res;
            }

        }
        return res;
    }
}


public class Driverclass {

    public static void main(String[] args) {
   TwoSum to = new TwoSum();
   to.add(1);
   to.add(3);
   to.add(5);
        System.out.println(to.find(4));
        System.out.println(to.find(7));


    }

}