
/*
MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.
Model - Model represents an object carrying data. It can also have logic to update controller if its data changes.
View  - View represents the visualization of the data that model contains.
Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. 
             It keeps view and model separate.

*/

public class ModelViewControllerDemo{
    public static void main(String[] args) {
        System.out.println("Model View Controller Demo");

        StudentModel model = retriveStudentFromDatabase();
        StudentView  view  = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("John");
        controller.updateView();
    }

    private static StudentModel retriveStudentFromDatabase(){
        StudentModel student = new StudentModel();
        student.setName("Robert");
        student.setRollNumber("10");
        return student;
     }
}

//create model 
class StudentModel{
    private String rollNo;
    private String name;

    public String getRollNumber(){
        return rollNo;
    }

    public String getName(){
        return name;
    }

    public void setRollNumber(String rollNo){
        this.rollNo = rollNo;
    }

    public void setName(String name){
        this.name = name;
    }
}

//create view 
class StudentView{
    public void printStudentDetails(String name, String roll){
        System.out.println("Student Details - ");
        System.out.println("Student name: " + name);
        System.out.println("Student roll: " + roll);
    }
}

//create controller 
class StudentController{
    private StudentModel model;
    private StudentView  view;

    public StudentController(StudentModel model, StudentView view){
        this.model = model;
        this.view = view;
     }    

     public void setStudentName(String name){
        model.setName(name);		
     }
  
     public String getStudentName(){
        return model.getName();		
     }
  
     public void setStudentRollNo(String rollNo){
        model.setRollNumber(rollNo);		
     }
  
     public String getStudentRollNo(){
        return model.getRollNumber();		
     }
  
     public void updateView(){				
        view.printStudentDetails(model.getName(), model.getRollNumber());
     }	     
}