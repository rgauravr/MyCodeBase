import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

public class MyQueue {


    int size;
    int f;
    int r;
    int[] arr;
    public MyQueue(int size){
        this.size=size;
        f=-1;
        r=-1;
        arr = new int[3];
    }

    public void enqueue(int var){
        if((r+1)%size == f){
            System.out.println("full");
        return;
        }

        if(f==-1)
            f=0;

        r=(r+1)%size;
        arr[r]=var;
        System.out.println("enquued is "+ arr[r]);

    }

    public void  dequeue(){
        if(f==-1 && r==-1){
            System.out.println("queue is empty");
           return;
        }

        if(f==r){
            System.out.println("dequeue is "+arr[f]);
            f=-1;
            r=-1;
            return;
        }
        System.out.println("dequeue is "+arr[f]);
        f=(f+1)%size;
    }
    public void display(){

        if(r == -1 && f ==-1)
        {
            System.out.println("Queue is empty nothing to display");
            return;
        }

        int temp = f;

        while(true){

            if(temp==r){
                System.out.println(arr[temp]);
                break;
            }
            System.out.println(arr[temp]);
            temp=(temp+1)%size;

        }
    }
    public static void main(String[] args){

MyQueue obj = new MyQueue(3);
obj.enqueue(1);
obj.enqueue(2);
obj.enqueue(3);
obj.enqueue(4);
obj.display();
obj.dequeue();
        obj.display();
obj.enqueue(4);
obj.display();
        obj.dequeue();
        obj.dequeue();

        obj.display();
        obj.dequeue();
        obj.display();

    }
}
