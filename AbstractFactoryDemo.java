
/*
Abstract Factory patterns work around a super-factory which creates other factories. This factory is also called as factory of factories. 
This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes. 
Each generated factory can give the objects as per the Factory pattern.
*/

public class AbstractFactoryDemo{

    public static void main(final String[] args) {
        System.out.println("Abstract Factory Design Pattern Demo");

        AbstractFactory factoryObject = FactoryProducer.getFactory(true);   
        Shape shape1 = factoryObject.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = factoryObject.getShape("SQUARE");
        shape2.draw();

        AbstractFactory factoryObject2 = FactoryProducer.getFactory(false);
        Shape shape3 = factoryObject2.getShape("RECTANGLE");
        shape3.draw();
        Shape shape4 = factoryObject2.getShape("SQUARE");
        shape4.draw();        
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

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside Square class::draw()");
    }
}

class RoundedRectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside RoundedRectangle class::draw()");
    }
}

class RoundedSquare implements Shape{
    @Override
    public void draw(){
        System.out.println("Inside RoundedSquare class::draw()");
    }
}

//Create an Abstract class to get factories for Normal and Rounded Shape Objects.
abstract class AbstractFactory{
    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }else{
            if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            }else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }else{
                return null;
            }
        }
    }
}

class RoundedShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }else{
            if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new RoundedRectangle();
            }else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new RoundedSquare();
            }else{
                return null;
            }
        }
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedShapeFactory();
        }else{
            return new ShapeFactory();
        }
    }
}