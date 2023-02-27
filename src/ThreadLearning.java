


class synchronisedDemo {
    private int count=0;

    public void setCount(){
       count++;
       System.out.println("Current Thread id is "+Thread.currentThread().getId()+"  and name is "+ Thread.currentThread().getName());
   }
    public void getCount() {
       System.out.println("Current Thread id is " + Thread.currentThread().getId() + "  and name is " + Thread.currentThread().getName() + " and current count is " + count);
   }

   }


//Demo for creating thread using extend
class test1 extends  Thread{
    public void run(){
        for (int i=0;i<2;i++){
            System.out.println("test1");
            try{Thread.sleep(10);}
            catch (Exception io){}
        }
    }
}

class test2 extends  Thread{
    public void run(){
        for (int i=0;i<2;i++){
            System.out.println("test2");
            try{Thread.sleep(10);}
            catch (Exception io){}
        }
    }
}

//Demo for creating thread using implement


class test3 implements Runnable{
    public void run(){
        for (int i=0;i<2;i++){
            System.out.println("test3");
            try{Thread.sleep(10);}
            catch (Exception io){}
        }
    }
}

class test4 implements Runnable{
    public void run(){
        for (int i=0;i<2;i++){
            System.out.println("test4");
            try{Thread.sleep(10);}
            catch (Exception io){}
        }
    }
}
public class ThreadLearning {

    public static void main(String[] args) throws Exception{

        //using extend
        test2 obj2=new test2();
        test1 obj1=new test1();
        obj1.start();
        obj2.start();
        obj1.join();
        obj2.join();

        //using implement Runnable
        test3 obj3=new test3();
        test4 obj4 = new test4();
        Thread t1=new Thread(obj3);
        Thread t2=new Thread(obj4);
        t1.start();
        t2.start();


        //Using lambda

        Thread t3=new Thread(()->{
        for (int i=0;i<2;i++){
            System.out.println("test5 "+Thread.currentThread().getPriority());

            try{Thread.sleep(10);}
            catch (Exception io){}
        }
        });

        Thread t4 = new Thread(()->{
            for (int i=0;i<2;i++){
                System.out.println("test6");
                try{Thread.sleep(10);}
                catch (Exception io){}
            }
        });

        t3.setPriority(10);
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Bye");

        //Demo of syncronized keyword

        synchronisedDemo obj = new synchronisedDemo();

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    obj.setCount();
                    obj.getCount();
                }
            }
        });



        Thread t6 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    obj.setCount();
                    obj.getCount();
                }
            }
        });

        t5.start();
        t6.start();

       t5.join();
       t6.join();


    }
}
