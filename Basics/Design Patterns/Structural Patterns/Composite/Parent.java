import java.util.ArrayList;
import java.util.List;
public class Parent implements Person {
    
    private String name;
    private List<Person> contents;

    public Parent(String name){
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public void add(Person component){
        contents.add(component);
    }

    public void remove(Person component){
        contents.remove(component);
    }

    @Override
     
    public void display(){
        System.out.println("Parent : " + name);
        for (Person comp : contents){
            comp.display();
        }
    }
    
}
