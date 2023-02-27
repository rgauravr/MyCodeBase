import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  1->2->3->4
 *  2->5->6
 *  5->9->10
 *  4->7->8
 *  7>11->12
 */


public class BFS {
    int vertex;
    boolean visited[];
    ArrayList<Integer> adj[];
    Queue<Integer> queue;

    BFS(int V){
        vertex=V;
        visited= new boolean[V+1];
        adj = new ArrayList[V+1];
        for(int i=0;i<=vertex;i++){
            adj[i]= new ArrayList<Integer>();
        }
        queue = new LinkedList<>();
    }

    BFS addEdge(int u, int v){
        this.adj[u].add(v);
        return this;
    }

    public void  printGraph(){
        System.out.println("start printing graph");
        for(int i=1;i<=this.vertex;i++){
           // if(this.adj[i].size()>1)
            System.out.print(i);
            for(int j=0;j<this.adj[i].size();j++){
                System.out.print("->"+this.adj[i].get(j));
            }
            //if(this.adj[i].size()>1)
            System.out.println();
        }
        System.out.println("end of printing graph");
    }
    public void doBFS(int x){
        System.out.println("start bfs from "+x);
        queue.add(x);

        while (!queue.isEmpty()){
            int v=queue.poll();
           if(this.visited[v]==false)
            System.out.print(v+"->");

           this.visited[v]=true;

            for(int i=0;i<this.adj[v].size();i++){
                if(this.visited[this.adj[v].get(i)]==false)
                queue.add(this.adj[v].get(i));
            }
        }
        System.out.println();
        System.out.println("end of BFS");
        System.out.println("=============================================================================");
    }

    public static void main(String[] args){

        BFS bfs = new BFS(12);
        bfs.addEdge(1,2);
        bfs.addEdge(1,3);
        bfs.addEdge(1,4);
        bfs.addEdge(2,5);
        bfs.addEdge(2,6);
        bfs.addEdge(5,9);
        bfs.addEdge(5,10);
        bfs.addEdge(4,7);
        bfs.addEdge(4,8);
        bfs.addEdge(7,11);
        bfs.addEdge(7,12);
        bfs.printGraph();
        bfs.doBFS(1);

        BFS bfs1 = new BFS(4);
        bfs1.addEdge(1,2);
        bfs1.addEdge(1,3);
        bfs1.addEdge(2, 3);
        bfs1.addEdge(3, 1);
        bfs1.addEdge(3, 4);
        bfs1.addEdge(4, 4);
        bfs1.printGraph();
        bfs1.doBFS(2);
    }

}
