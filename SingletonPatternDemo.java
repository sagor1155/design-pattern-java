/*
Singleton pattern is one of the simplest design patterns in Java. 
This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
*/

public class SingletonPatternDemo{
    public static void main(String[] args){
        System.out.println("Singleton Pattern Demo");
        SingletonClass singleObject = SingletonClass.getInstance();
        singleObject.showMessage();
    }
}

class SingletonClass{
    //create an object of SingletonClass
    private static SingletonClass instance = new SingletonClass();

    //make the constructor private so that this class can't be instantiated 
    private SingletonClass(){
        System.out.println("constructor invoked"); 
    }

    //get the only object available 
    public static SingletonClass getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("singleton object::showMessage");
    }
}
