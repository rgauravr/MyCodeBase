import java.sql.SQLOutput;
import java.util.*;

/*
problem statement

// VOTERS

[{
 "name": "A",
 "gender":"m",
 "id":"aaa"
},
{
 "name": "B",
 "gender":"f",
 "id":"bbb"
},
{
 "name": "C",
 "gender":"f",
 "id":"ccc"
},
{
 "name": "D",
 "gender":"m",
 "id":"ddd"
},
{
 "name": "E",
 "gender":"f",
 "id":"eee"
},
{
 "name": "F",
 "gender":"m",
 "id":"fff"
},
{
 "name": "G",
 "gender":"m",
 "id":"ggg"
}]

// CANDIDATES

[{
 "name": "X",
 "gender":"m",
 "id":"xxx"
},
{
 "name": "Y",
 "gender":"f",
 "id":"yyy"
},
{
 "name": "Z",
 "gender":"m",
 "id":"zzz"
}
]

// VOTES

[{"voterId":"aaa", "candidateId":"xxx"},{"voterId":"bbb", "candidateId":"yyy"},{"voterId":"ccc", "candidateId":"yyy"},{"voterId":"ddd", "candidateId":"xxx"},{"voterId":"eee", "candidateId":"xxx"},{"voterId":"fff", "candidateId":"yyy"},{"voterId":"ggg", "candidateId":"xxx"}]
Taking the example of addition of FS

Find the Candidate who has got the maximum number of votes and print the name of the Candidate and Total Number of Votes Secured


ans : X(xxx) 4

here x is name of the candidate and xxx is its id and number of votes he got is 4

 */

class voters{

    private String name;
    private String gender;
    private String id;

    public voters(String name, String gender, String id){
        this.name=name;
        this.gender=gender;
        this.id=id;

    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class candidate{

    private String name;
    private String gender;
    private String id;

    public candidate(String name, String gender, String id){
        this.name=name;
        this.gender=gender;
        this.id=id;

    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class votes{

    private voters votersobj;
    private candidate candidateobj;

    public votes(voters votersobj,candidate  candidateobj){

        this.votersobj=votersobj;
        this.candidateobj=candidateobj;
    }

    public candidate getCandidateobj() {
        return candidateobj;
    }

    public voters getVotersobj() {
        return votersobj;
    }

    public void setCandidateobj(candidate candidateobj) {
        this.candidateobj = candidateobj;
    }

    public void setVotersobj(voters votersobj) {
        this.votersobj = votersobj;
    }
}

/*

for an input votes

[{"voterId":"aaa", "candidateId":"xxx"},{"voterId":"bbb", "candidateId":"yyy"},{"voterId":"ccc", "candidateId":"yyy"},
{"voterId":"ddd", "candidateId":"xxx"},{"voterId":"eee", "candidateId":"xxx"},
{"voterId":"fff", "candidateId":"yyy"},{"voterId":"ggg", "candidateId":"xxx"}]
 */
public class xactlyIntervierw {

    public static void main(String[] args){
        List<votes> voteslist = new ArrayList<>();
        voteslist.add(new votes(new voters("A","m","aaa"),new candidate("x","m","xxx")));
        voteslist.add(new votes(new voters("B","f","bbb"),new candidate("Y","f","yyy")));
        voteslist.add(new votes(new voters("C","f","ccc"),new candidate("Y","f","yyy")));
        voteslist.add(new votes(new voters("d","f","ddd"),new candidate("x","m","xxx")));
        voteslist.add(new votes(new voters("e","f","eee"),new candidate("x","m","xxx")));
        voteslist.add(new votes(new voters("f","f","fff"),new candidate("Y","f","yyy")));
        voteslist.add(new votes(new voters("g","f","ggg"),new candidate("x","f","xxx")));

        HashMap<String,Integer> mapCandidateToNumberOfVotes = new HashMap<>();

        int maximumvotes=0;
        String candidateName="";

        for(votes obj: voteslist){
            mapCandidateToNumberOfVotes.put(obj.getCandidateobj().getName(),mapCandidateToNumberOfVotes.getOrDefault(obj.getCandidateobj().getName(),0)+1);
        }

        for(String key: mapCandidateToNumberOfVotes.keySet()){
            if(maximumvotes<mapCandidateToNumberOfVotes.get(key)){
                maximumvotes=mapCandidateToNumberOfVotes.get(key);
                candidateName=key;
            }
        }

        
        System.out.println(" candidate who won the election is "+ candidateName+ " with number of votes "+maximumvotes);

       int a=8;
       int count =0;
       int sum=0;
       while(sum!=1){
           sum = (a>>count)&1;
           if(sum==1){
               //count++;
               break;
           }
           count++;
       }
     




        
    }

}
