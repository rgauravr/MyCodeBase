import java.util.*;

class cell{

    int row;
    int col;
    public cell(int row, int col){
        this.row=row;
        this.col=col;
    }
}

class nodes{

    int x;
    int y;

    int currFlag;
    public nodes(int x , int y){
        this.x=x;
        this.y=y;
    }
}
class FreeTicket{

    List<cell> flag;
    int countOfFlag;
    char[][] game;
    int minCoin;

    public FreeTicket(int countOfFlag, List<cell> flag, char[][] game){

        this.countOfFlag=countOfFlag;
        this.flag=flag;
        this.game=game;
        minCoin= Integer.MAX_VALUE;
    }
    int[][] dir = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};

    public  boolean isValid(int row, int col, int x, int y){

        return (x>=0 && x<row && y>=0 && y<col && game[x][y]!='O');
    }

    public void mainFunc(){

        for(cell var: flag){
        dfs(countOfFlag,game,new nodes(var.row,var.col),new boolean[game.length][game[0].length],0,1);
        }
        int ans = minCoin==Integer.MAX_VALUE?-1:minCoin;
        System.out.println("Min val re is "+ans);
    }
    public void dfs(int countOfFlag, char[][] game, nodes node, boolean[][] vis,int dist, int currFlag){

        if(vis[node.x][node.y]==true)
            return;

        if(currFlag==countOfFlag){
            minCoin=Math.min(minCoin,dist);
            return;
        }

        vis[node.x][node.y]=true;
        System.out.println(node.x+ " "+node.y+  " "+dist+ " "+currFlag);

        for(int i=0;i<dir.length;i++){
            int newRow = node.x+dir[i][0];
            int newCol = node.y+dir[i][1];

            if(isValid(game.length,game[0].length,newRow,newCol) && vis[newRow][newCol]==false){
                if(game[newRow][newCol]=='B'){

                    dfs(countOfFlag,game,new nodes(newRow,newCol),vis,dist+1,currFlag);


                }else{

                    dfs(countOfFlag,game,new nodes(newRow,newCol),vis,dist,currFlag+1);
                }
            }

        }

        vis[node.x][node.y]=false;
    }

}

class BusinessNode{

    int cp;
    int sp;
    int nodeVal;
    public BusinessNode(int cp, int sp, int nodeVal){
        this.cp=cp;
        this.sp=sp;
        this.nodeVal=nodeVal;



    }
}
class MaximumSales{

int maxiMumSellingPrice;
int[] cp;
int[] sp;
int N;
List<BusinessNode>[] graph;
int A;

public MaximumSales(int[] cp, int[] sp, int N, int A , List<BusinessNode>[] graph){
    this.cp=cp;
    this.sp=sp;
    this.N=N;
    this.A=A;
    this.graph=graph;
    maxiMumSellingPrice=Integer.MIN_VALUE;
}

public void mainFunc(){

    for(int i=1;i<=N;i++){
        if(A>=cp[i]){
           dfs(A-cp[i],new BusinessNode(cp[i],sp[i],i),new boolean[N+1],sp[i]);
        }
    }
    System.out.println("Maximum selling price is "+ maxiMumSellingPrice);

}

public  void dfs(int rA, BusinessNode node,boolean[] vis, int maxSP){

    if(vis[node.nodeVal]==true)
        return ;



vis[node.nodeVal]=true;


    for(BusinessNode child: graph[node.nodeVal]){
        if(vis[child.nodeVal]==false && rA>=child.cp){
            dfs(rA-child.cp,child,vis,maxSP+child.sp);

        }
    }

    maxiMumSellingPrice=Math.max(maxiMumSellingPrice,maxSP);

}


}

class Bomb{

    int B;
    long S;
    int N;
    int[][] health;

    int maximumTankDestroyed;

    public Bomb(int B, long S, int N, int[][] health){
        this.B=B;
        this.S=S;
        this.N=N;
        this.health=health;
        maximumTankDestroyed=0;
    }

    public void cal(List<Integer> list){

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->a-b);

        for(int i=0;i<N;i++){
            if(list.contains(i)){
                //BH health
                pq.add(health[i][1]);
            }else{
                pq.add(health[i][0]);
            }
        }

    int total=0;
        int tank=0;
        while(total<=S && !pq.isEmpty()){
            total=total+pq.poll();

            if(total>S)
                break;

            tank++;
        }
    maximumTankDestroyed=Math.max(tank,maximumTankDestroyed);
    }

    public void mainFunc(){

        generateAllCombination(new ArrayList<>(),0);
        System.out.println("Maximum tanks destroyed is "+maximumTankDestroyed);
    }

    public void generateAllCombination(List<Integer> list, int index){

        if(list.size()==B){
            cal(list);
            return;
        }

        for(int i=index;i<N;i++){
            list.add(i);
            generateAllCombination(list,i+1);
            list.remove(list.size()-1);
        }
    }

}

public class All {

    public static void allComb(int[] arr, int index, List<Integer> list, int k){

        if(list.size()==k){
            System.out.println(list);
            return;
        }

        for(int i=index;i<arr.length;i++){

            list.add(arr[i]);
            allComb(arr,i+1,list,k);
            list.remove(list.size()-1);
        }


    }
    public static void main(String[] args) {



        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Enter the option ");
        int val = scanner1.nextInt();


                if(val==1){
                int row = scanner1.nextInt();
                int col = scanner1.nextInt();

                char[][] game = new char[row][col];
                List<cell> flag = new ArrayList<>();
                int countOfFlag = 0;

                for (int i = 0; i < row; i++) {
                    String s = scanner1.next();
                    //String s = sarr[i];
                    System.out.println(s);

                    for (int j = 0; j < col; j++) {
                        game[i][j] = s.charAt(j);
                        if (game[i][j] == 'F') {

                            countOfFlag++;
                            flag.add(new cell(i, j));
                        }

                    }
                }


                FreeTicket free = new FreeTicket(countOfFlag, flag, game);

                free.mainFunc();

            }else if(val ==2 ){



                     int A = scanner1.nextInt();
                     int N= scanner1.nextInt();
                     int[] cp = new int[N+1];
                     int[] sp = new int[N+1];
                    List<BusinessNode>[] graph = new ArrayList[N+1];

                     for(int i=0;i<=N;i++){
                         graph[i]= new ArrayList<>();
                     }

                     for(int i=1;i<=N;i++){
                         cp[i]=scanner1.nextInt();
                     }

                     for(int i=1;i<=N;i++)
                         sp[i]=scanner1.nextInt();

                     int temp=N-1;

                     while(temp>0){

                         int source = scanner1.nextInt();
                         int dest = scanner1.nextInt();

                         graph[source].add(new BusinessNode(cp[dest],sp[dest],dest));
                         graph[dest].add(new BusinessNode(cp[source],sp[source],source));
                         temp--;
                     }

                      for(int i=1;i<=N;i++){
                          System.out.println("for parent "+i+ " "+ " child is");
                          for(BusinessNode child: graph[i]){
                              System.out.println(child.cp+" "+child.sp+" "+child.nodeVal);
                          }
                      }


                  MaximumSales obj = new MaximumSales(cp,sp,N,A,graph);
                      obj.mainFunc();
                } else if (val==3) {

                   // int[] arr = new int[]{1,2,3,4,5,6};

                    //allComb(arr,0,new ArrayList<>(),4);

                    int B = scanner1.nextInt();
                    long S = scanner1.nextLong();
                    int N = scanner1.nextInt();
                    int[][] health = new int[N][2];

                    for(int i=0;i<N;i++){
                        for(int j=0;j<2;j++){
                            health[i][j]=scanner1.nextInt();

                        }
                    }

                for(int var[]: health){
                    System.out.println(var[0]+ " "+var[1]);
                }

                Bomb bomb = new Bomb(B,1l*S,N,health);
                bomb.mainFunc();
                }



    }





    }



