import java.util.ArrayList;
import java.util.List;

/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified, 
its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.
*/

public class ObserverPatternDemo{
    public static void main(String[] args) {
        System.out.println("Observer pattern demonstration");

        Subject subjectObject = new Subject();
        Observer obs1 = new OctalObserver();
        Observer obs2 = new BinaryObserver();
        Observer obs3 = new HexaObserver();

        subjectObject.attachObserver(obs1);
        subjectObject.attachObserver(obs2);
        subjectObject.attachObserver(obs3);

        subjectObject.dettachObserver(obs2);

        subjectObject.setState(7);
    }
}

class Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState(){
       return state;
    }
 
    public void setState(int state){
       this.state = state;
       notifyAllObserver();
    }

    public void attachObserver(Observer observer){
        observers.add(observer);
    }

    public void dettachObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObserver(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}


abstract class Observer{
    public abstract void update();
}

class OctalObserver extends Observer{
    public void update(){
        System.out.println("Inside OctalObserver class");
    }
}

class HexaObserver extends Observer{
    public void update(){
        System.out.println("Inside HexaObserver class");
    }
}

class BinaryObserver extends Observer{
    public void update(){
        System.out.println("Inside BinaryObserver class");
    }
}
