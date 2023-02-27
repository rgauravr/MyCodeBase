import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  1->2->3->4
 *  2->5->6
 *  5->9->10
 *  4->7->8
 *  7>11->12
 */


public class DFS {
    int vertex;
    boolean visited[];
    ArrayList<Integer> adj[];
    Stack<Integer> stack;

    DFS(int V){
        vertex=V;
        visited= new boolean[V+1];
        adj = new ArrayList[V+1];
        for(int i=0;i<=vertex;i++){
            adj[i]= new ArrayList<Integer>();
        }
        stack = new Stack<>();
    }

    DFS addEdge(int u, int v){
        this.adj[u].add(v);
        return this;
    }

    public void  printGraph(){
        System.out.println("start printing graph");
        for(int i=0;i<=this.vertex;i++){
            System.out.print(i);
            for(int j=0;j<this.adj[i].size();j++){
                System.out.print("->"+this.adj[i].get(j));
            }
            System.out.println();
        }
        System.out.println("end of printing graph");
    }
    public void doDFS(int x){
        System.out.println("start dfs from "+x);
        stack.add(x);

        while(!stack.isEmpty()){
            int v = stack.pop();
            if(this.visited[v]==false){
                System.out.print(v+"->");
                this.visited[v]=true;
            }
            for(int i=0;i<this.adj[v].size();i++){
                if(this.visited[this.adj[v].get(i)]==false)
                stack.add(this.adj[v].get(i));
            }

        }


        System.out.println();
        System.out.println("end of DFS");
        System.out.println("=============================================================================");
    }

    public static void main(String[] args){

        DFS dfs = new DFS(12);
        dfs.addEdge(1,2);
        dfs.addEdge(1,3);
        dfs.addEdge(1,4);
        dfs.addEdge(2,5);
        dfs.addEdge(2,6);
        dfs.addEdge(5,9);
        dfs.addEdge(5,10);
        dfs.addEdge(4,7);
        dfs.addEdge(4,8);
        dfs.addEdge(7,11);
        dfs.addEdge(7,12);
        dfs.printGraph();
        dfs.doDFS(1);

        DFS dfs1 = new DFS(4);
        dfs1.addEdge(1,2);
        dfs1.addEdge(1,3);
        dfs1.addEdge(2, 3);
        dfs1.addEdge(3, 1);
        dfs1.addEdge(3, 4);
        dfs1.addEdge(4, 4);
        dfs1.printGraph();
        dfs1.doDFS(2);

        DFS g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.printGraph();
        g.doDFS(2);
    }

}
