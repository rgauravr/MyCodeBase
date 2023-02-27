class shortestDistanceBtwnWords{
    public int shortest(String[] str,String w1,String w2){

        int minPos=Integer.MAX_VALUE;
        if(w1.equals(w2))
        {
            minPos=0;
            return minPos;
        }
        int pos=-1;
        for(int i=0;i<str.length;i++){
            if(str[i].equals(w1) || str[i].equals(w2)){
                if(pos ==-1){
                    pos=i;
                }
                else if(str[pos].equals(str[i])){
                    pos=i;
                }
                else{
                    minPos=Math.min(minPos,i-pos);
                    pos=i;
                }
            }


        }


        return minPos;
    }
}

public class MinimumDistanceBetweenWordsofaString {
//https://www.geeksforgeeks.org/minimum-distance-between-words-of-a-string/
//https://tenderleo.gitbooks.io/leetcode-solutions-/content/GoogleMedium/244.html

    public static void main(String[] args){
        String[] arr={"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(new shortestDistanceBtwnWords().shortest(arr,"practice","coding"));
        System.out.println(new shortestDistanceBtwnWords().shortest(arr,"makes","coding"));
    }

}
