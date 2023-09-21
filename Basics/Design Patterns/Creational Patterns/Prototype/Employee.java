import java.util.List;
import java.util.ArrayList;

// Employee class (Prototype)
public class Employee implements Cloneable {
    private String name;
    private int age;
    private List<String> skills;

    public Employee(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = new ArrayList<>(skills);
    }

    // Shallow Copy method
    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    // Deep Copy method
    public Employee deepCopy() {
        List<String> copiedSkills = new ArrayList<>(skills);
        return new Employee(name, age, copiedSkills);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }
}
