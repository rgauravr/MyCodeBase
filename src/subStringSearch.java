/*


class subStringSearch {

   */
/* static int exactMatch(String text, String pat, int text_index, int pat_index) {
        if (text_index == text.length() && pat_index != pat.length())
            return 0;

        // Else If last character of pattern reaches
        if (pat_index == pat.length())
            return 1;

        if (text.charAt(text_index) == pat.charAt(pat_index))
            return exactMatch(text, pat, text_index + 1, pat_index + 1);

        return 0;
    }

    // This function returns true if 'text' contain 'pat'
    static int contains(String text, String pat, int text_index, int pat_index) {
        // If last character of text reaches
        if (text_index == text.length())
            return 0;

        // If current characters of pat and text match
        if (text.charAt(text_index) == pat.charAt(pat_index)) {
            if (exactMatch(text, pat, text_index, pat_index) == 1)
                return 1;
            else
                return contains(text, pat, text_index + 1, pat_index);
        }

        // If current characters of pat and tex don't match
        return contains(text, pat, text_index + 1, pat_index);
    }

    // Driver program to test the above function
    public static void main(String args[]) {
        System.out.println(contains("geeksforgeeks", "geekss", 0, 0));
        System.out.println(contains("geeksforgeeks", "geeksquiz", 0, 0));
        System.out.println(contains("geeksquizgeeks", "quiz", 0, 0));

    }*//*


 public boolean search(String str1,String str2,int n,int m){
     boolean res=false;
     int j=0,i=0;
     for(i=0;i<n;i++){
         if(j==m)
         {
             res=true;
             break;
         }
         if(str1.charAt(i)==str2.charAt(j)){
             for(int )
         }
     }
     if(i==n && j==m)
         res=true;
     else if(i==n && j!=m)
         res=false;
 }
public static void main(String []args){
    String str1= "geetsforgeeks";
    String str2= "geeks";
    System.out.println(new subStringSearch().search(str1,str2,str1.length(),str2.length()));
}
}














*/
