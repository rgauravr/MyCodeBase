import java.lang.*;
import java.util.*;
//https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms
class Interval {
    private int startTime;
    private int endtime;

    Interval(int start, int end){
        this.endtime=end;
        this.startTime=start;
    }
    public int getStartTime(){
       return this.startTime;
    }
    public int getEndtime(){
        return this.endtime;
    }
    public  String toSTring(){
        return "start time "+ String.valueOf(this.startTime) + " "+ "end time "+String.valueOf(this.endtime);
    }

}

class sortBystartTime implements Comparator<Interval> {

    public int compare(Interval a, Interval b){
        return a.getStartTime()-b.getStartTime();

    }
}

class personWillAttendAllMeeting{
    public boolean isPersonAbleToAttendAllMeeting(List<Interval> list){
        boolean res=true;

        for(int i=1;i<list.size();i++){
            if(list.get(i).getStartTime()<list.get(i-1).getEndtime()) {
                res = false;
                break;
            }
            }

        return res;
    }
}
public class meetingrooms {
    public static void main(String [] args) {
        Interval[] intervals={new Interval(0,30),new Interval(5,10),new Interval(15,20)};
        List<Interval> lst = new ArrayList<>(Arrays.asList(intervals));
        Interval[] intervals1={new Interval(7,10),new Interval(2,4)};
        List<Interval> lst2 =  new ArrayList<>(Arrays.asList(intervals1));
        Collections.sort(lst,new sortBystartTime());
        Collections.sort(lst2,new sortBystartTime());
        //System.out.println(lst);
         for(Interval i : lst)
             System.out.println(i.toSTring());

         for (Interval i : lst2)
             System.out.println(i.toSTring());


         //person not able to attend all the meeting use case [[0,30],[5,10],[15,20]]
        System.out.println(new personWillAttendAllMeeting().isPersonAbleToAttendAllMeeting(lst));

        //person able to attend all the meeting use case: [[7,10],[2,4]]
        System.out.println(new personWillAttendAllMeeting().isPersonAbleToAttendAllMeeting(lst2));

        Integer[] score ={10,3,8,9,4};


        Arrays.sort(score,Collections.reverseOrder());


}

    }


