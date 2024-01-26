public class PrintOneTwoThreeUsingThreads extends Thread{

    int var;
    int N;

    public PrintOneTwoThreeUsingThreads(int N){

        this.N=N;
        var=1;
    }



    public void printOne (){

        synchronized (this) {

            for (int i=1;i<=N;i++){
            while (var != 1) {

                try {
                    wait();
                } catch (Exception exception) {

                }
            }


                System.out.println(Thread.currentThread().getName()+" "+1);
                var=2;
                notifyAll();
            }

        }


    }

    public void printTwo (){

        synchronized (this) {
            for (int i=1;i<=N;i++){
            while (var != 2) {

                try {
                    wait();
                } catch (Exception exception) {

                }
            }


                System.out.println(Thread.currentThread().getName()+" " +2);
                var=3;
                notifyAll();
            }

        }


    }

    public void printThree (){

        synchronized (this) {
            for (int i=1;i<=N;i++){
            while (var != 3) {

                try {
                    wait();
                } catch (InterruptedException exception) {

                }
            }


                System.out.println(Thread.currentThread().getName()+ " " +3);
                var=1;
                notifyAll();
            }

        }


    }


   public static void main(String[] args){

       PrintOneTwoThreeUsingThreads myCustomSet = new PrintOneTwoThreeUsingThreads(2);

        Thread thread1 = new Thread(()->{
           // System.out.println(Thread.currentThread().getName());
            myCustomSet.printOne();

        });

       Thread thread2 = new Thread(()->{
           //System.out.println(Thread.currentThread().getName());
           myCustomSet.printTwo();

       });

       Thread thread3 = new Thread(()->{
           //System.out.println(Thread.currentThread().getName());
           myCustomSet.printThree();

       });



       thread3.start();
       thread2.start();
       thread1.start();












    }
}