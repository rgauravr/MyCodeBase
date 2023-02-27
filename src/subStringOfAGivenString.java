

public class subStringOfAGivenString{
    public void subString(String str,int start,int end){
        if(start==str.length() && end == str.length())
            return;
        if(end==str.length()+1)
            subString(str,start+1,start+1);

        else{
            //  System.out.println(start + " "+ end );
            //if(end-start >=2)
            System.out.print(str.substring(start,end)+ " ");
            subString(str,start,end+1);
        }



    }
    public static void main(String []args) {
        String str="00110011";

        // str.substring()
        new subStringOfAGivenString().subString(str,0,1);
    }


}


