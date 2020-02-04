
/*
Factory Pattern:
1. creational design pattern 
2. provides best way to create an object 
3. creates object without  exposing the creation logic to the client 
4. refers to newly created object using common interface 
*/

public class FactoryPatternDemo{
    public static void main(String[] args){
        System.out.println("Factory Pattern Demo");

        ShapeFactory shapeFactoryObject = new ShapeFactory();
        Shape shape1 = shapeFactoryObject.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = shapeFactoryObject.getShape("CIRCLE");
        shape2.draw();
        Shape shape3 = shapeFactoryObject.getShape("square");
        shape3.draw();         
    }
}

//Create an interface
interface Shape{
    void draw();
}

//Create concrete classes implementing the same interface.
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Rectangle class::draw()");
    }
}

class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Circle class::draw()");
    }
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square class::draw()");
    }
}

//Create a Factory to generate object of concrete class based on given information
class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }else{
            if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            }else if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            }else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }else{
                return null;
            }
        }
    }
}