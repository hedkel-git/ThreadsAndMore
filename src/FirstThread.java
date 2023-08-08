public class FirstThread implements Runnable{

    private final int date;
    public FirstThread(int date){
        this.date = date;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " from thread: " + date);


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
