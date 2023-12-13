public class PrintEvenOddThread {
    int counter =1;
    int N;

    public void printOdd(){

        synchronized (this){

            while(counter<N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException io) {
                        System.out.println(io);
                    }
                }

                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    public void printEven(){

        synchronized (this){

            while(counter<N){
                while(counter%2==1){

                    try {
                        wait();
                    }catch (InterruptedException io){
                        System.out.println(io);
                    }
                }
                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args){

        PrintEvenOddThread d = new PrintEvenOddThread();
    d.N=10;

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            d.printOdd();
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            d.printEven();
        }
    });

    t1.start();
    t2.start();



    }
}
