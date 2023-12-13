import java.util.ArrayList;
import java.util.List;

public class powerset {

    public void powerSet(String str, int index, String subchar){
        if(index == str.length()) {
            System.out.print(subchar + " ");

            return;
        }

        powerSet(str,index+1,subchar+str.charAt(index));

        powerSet(str,index+1,subchar);

    }


    public static void main(String []args){
        String str = "321";

        new powerset().powerSet(str,0,"");
    }
}










//abd


//bcd
//abcd