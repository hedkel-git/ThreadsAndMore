public class Main {
    public static void main(String[] args) {
        testing();

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

    public static void testing1(){

    }
    public static void testing2(){

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


