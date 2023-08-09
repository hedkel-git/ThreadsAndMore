import java.util.concurrent.Semaphore;

public class Rooms {

    private final Semaphore sem;
    private final int rooms;

    public Rooms(int rooms){
        if(rooms < 0){
            throw new RuntimeException("Cannot contain negative amount of rooms");
        }
        else {
            this.rooms = rooms;
            sem = new Semaphore(rooms);
        }
    }

    public void enter(int id) throws InterruptedException {

        sem.acquire();

        System.out.println("Person: " + id + ", has entered a room.\n" +
                                "Rooms occupied: " + (rooms - sem.availablePermits()));
        Thread.sleep(1000);

        sem.release();

    }

}
