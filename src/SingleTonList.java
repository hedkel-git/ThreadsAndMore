import java.util.ArrayList;
import java.util.List;

public class SingleTonList {
    private final List<Integer> list = new ArrayList<>();

    private static final SingleTonList stl = new SingleTonList();


    /*
    If this class is meant to be a singleton, then its default
    constructor must be private. This will make it impossible for
    more than one object of this class to exist.
     */
    public SingleTonList(){}


    public static SingleTonList getInstance(){
        return stl;
    }

    public synchronized void add(Integer i){
        list.add(i);
        System.out.println("List size is now: " + list.size());
    }

    @Override
    public String toString(){
        return list.toString();
    }

}