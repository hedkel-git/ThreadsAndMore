import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.TimeUnit.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        order1();
    }

    public static void order1() throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        //SingleTonList list = SingleTonList.getInstance();
        //SingleTonList list2 = new SingleTonList();

        Thread x = new Thread(new Runnable() {
            @Override
            public void run() {
                oneToFive(list);
            }
        }); //x.start() -> use oneToFive-method below
        Thread y = new Thread(x);

        x.start();
        y.start();

        x.join();
        y.join();

        System.out.println(list);
    }

    public static void oneToFive(List<Integer> list){
        for (int i = 1; i <= 5; i++) {
            synchronized (list){
                list.add(i);
            }
            System.out.println(i);
            try    {MILLISECONDS.sleep(500);}
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /*
    adding elements to a list/array needs to 'tracked',
    check if add method is synchronised...
     */
    public static void oneToFive(SingleTonList list){
        for (int i = 1; i <= 5; i++) {
            list.add(i);
            System.out.println(i);
            try    {MILLISECONDS.sleep(500);}
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void testing(){

        for (int i = 1; i <= 2; i++) {
            new Thread(new FirstThread(i)).start();
        }

        System.out.println("hello");


        /*
        Threads run independently of each other
        */


    }

    public static void testing1() throws InterruptedException {
        Semaphore sem = new Semaphore(2);


        for (int i = 0; i < 5; i++){

            int ii = i;
            Thread th = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("I am thread: " + ii);
                    try {
                        sem.acquire();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            th.start();

        }


    }
    public static void testing2(){
        Rooms rooms = new Rooms(3);

        for (int i = 1; i <= 10; i++) {


            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        rooms.enter(finalI);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        }

    }


    /*
    Many threads are trying to access a room, but only one should
    be allowed at a time.

    Use mutex/semaphores.
     */
    public static void bathroom(){

    }

    /*
    10 threads are trying to access a server, but only 4 of them can have
    access at a time, make sure the threads join in the correct order.
     */
    public static void fakeServer() {

    }
}


