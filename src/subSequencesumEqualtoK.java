import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class subSequencesumEqualtoK {

    public static void main(String[] args){
        int[] arr = {10,1,2,7,6,1,5};
        int[] arr1={2,5,2,1,2};
        int k=5;
        Stack<Integer> stk = new Stack<>();
       //1st way
        //new subSequencesumEqualtoK().printAllSubseqequaltok(arr, arr.length, k, 0, stk);

        //2nd way
        new subSequencesumEqualtoK().printAllsubseqeqltoK(0,0,arr1,k,stk);
    }

   public void checkSumEqualtoK(Stack<Integer> stk , int k){
       int sum=0;
       for(int i=0;i<stk.stream().toList().size();i++){
           sum = stk.stream().toList().get(i)+sum;
           if(stk.stream().toList().size()-1 == i && sum == k)
           {
               System.out.println("list 1st way of implementation" + stk.stream().toList());
               return;
           }
       }
   return;
   }

    public void printAllSubseqequaltok(int [] arr,int n, int k,int i,Stack<Integer> stk){
        if(i == arr.length)
        {
            checkSumEqualtoK(stk,k);

         return;
        }
        stk.add(arr[i]);
        printAllSubseqequaltok(arr,n,k,i+1,stk);
        stk.pop();
        printAllSubseqequaltok(arr,n,k,i+1,stk);


    }
    //2way of implementation
    public void printAllsubseqeqltoK(int sum,int index,int[]arr,int k,Stack<Integer> stk){
        if(index == arr.length)
        {
            if(sum==k)
                System.out.println("list 2nd way of implementation"+ stk);
            return;
        }
        sum=sum+arr[index];
        stk.add(arr[index]);
        printAllsubseqeqltoK(sum,index+1,arr,k,stk);
        sum = sum-stk.peek();
        stk.pop();
        printAllsubseqeqltoK(sum,index+1,arr,k,stk);
    }

}
