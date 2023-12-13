import java.util.*;

class Pair{

    int node;
    int dist;
    Pair(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}

public class testProgramm{

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here

        int[] par = new int[n+1];

        for(int i=0;i<=n;i++)
            par[i]=i;

        int[] dist = new int[n+1];

        for(int i=0;i<=n;i++)
            dist[i]=Integer.MAX_VALUE;

        dist[1]=0;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y)->x.dist-y.dist);


        pq.add(new Pair(1,0));
        //System.out.println("hhh "+pq.contains(new Pair(1,0)));


        while(!pq.isEmpty()){

            Pair temp = pq.poll();

              for(Pair p: adj.get(temp.node)){
                int node=p.node;
                int weight=p.dist;



                if(weight+temp.dist<dist[node]){
                    pq.add(new Pair(node,weight+temp.dist));
                    dist[node]=weight+ temp.dist;
                    par[node]=temp.node;
                    //System.out.println(pq.size());
                }

            }
        }

        List<Integer> list = new ArrayList<>();

        int newNode=n;
        while(dist[newNode]!=0){
            //System.out.println(newNode);
            list.add(newNode);
            newNode=par[newNode];
            //System.out.println(newNode);
        }
        list.add(newNode);
        Collections.reverse(list);
        return list;
    }
    public int matrixToLinearMapping(int i, int j, int rowLength){
        return rowLength*i+j;
    }
    public void maxCoin(int[][] grid){
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        int[] dist = new int[grid.length*grid[0].length];
        int rowLength=grid[0].length;
        int[] path = new int[grid.length*grid[0].length];
        for(int i=0;i<grid.length*grid[0].length;i++){
            dist[i]=Integer.MIN_VALUE;
            adj.add(new ArrayList<>());
            path[i]=i;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                    if(j+1<rowLength)
                        adj.get(matrixToLinearMapping(i,j,rowLength)).add(new Pair(matrixToLinearMapping(i,j+1,rowLength),grid[i][j+1]));

                    if(i+1<grid.length)
                        adj.get(matrixToLinearMapping(i,j,rowLength)).add(new Pair(matrixToLinearMapping(i+1,j,rowLength),grid[i+1][j]));

            }
        }

        dist[0]=grid[0][0];
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(0,grid[0][0]));

        while(!pq.isEmpty()){
            Pair temp = pq.poll();

            for(Pair val: adj.get(temp.node)){

                if(temp.dist+val.dist>dist[val.node]){
                    dist[val.node]=temp.dist+val.dist;
                    pq.add(new Pair(val.node,temp.dist+val.dist));
                    path[val.node]=temp.node;
                }
            }

        }
        int index=-1;
int res=Integer.MIN_VALUE;
        System.out.println();
        for(int i=0;i<dist.length;i++){
            //System.out.println(dist[i]);
        if(dist[i]!=Integer.MAX_VALUE && res<dist[i]) {
            res = Math.max(dist[i], res);
            index=i;
        }

        }
        // System.out.println("hii");
        //System.out.println(dist[rowLength*rowLength-1]);

        //if(dist[rowLength*rowLength-1]==Integer.MAX_VALUE)
            //return -1;
        System.out.println();
        System.out.println("maximum coin is "+res);
       // return dist[rowLength*rowLength-1]+1;

        ArrayList<Integer> list = new ArrayList<>();

        while(dist[index]!=grid[0][0]){
            list.add(index);
            index=path[index];
        }
        list.add(index);
        Collections.reverse(list);
        System.out.println(list);
    }
public  static void main(String[] args){

        int[][] edges = new int[][]{{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}};
        int[][]edges1 = new int[][]{{1,2,2},{2,3,4},{1,4,1},{4,3,3}};
    System.out.println(edges.length);
    shortestPath(5,6,edges).forEach(var-> System.out.print(var+" -> "));
    System.out.println();

    shortestPath(4,4,edges1).forEach(var-> System.out.print(var+ " -> "));

    int[][] grid = new int[][]{{8,2,9},{6,1,7}};
    new testProgramm().maxCoin(grid);

    System.out.println();

    int[][] grid1 = new int[][]{{4,2,1},{3,5,2},{3,2,4},{4,5,1}};
    new testProgramm().maxCoin(grid1);

    int length=10;






}
}