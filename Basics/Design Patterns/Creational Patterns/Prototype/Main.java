import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // employee
        Employee originalEmployee = new Employee("Revanth", 21, Arrays.asList("Java", "Python"));

        try {
            // Shallow copy
            System.out.println("Employee (Before shallow copy): " + originalEmployee.getName() + ", Skills: " + originalEmployee.getSkills());
            Employee shallowCopy = originalEmployee.clone();
            // Modifying skills
            shallowCopy.getSkills().add("JavaScript");
            System.out.println("Shallow Copy : " + shallowCopy.getName() + ", Skills: " + shallowCopy.getSkills());
            System.out.println("Employee (After shallow copy): " + originalEmployee.getName() + ", Skills: " + originalEmployee.getSkills());
            
            // Deep copy
            Employee deepCopy = originalEmployee.deepCopy();
            // Modifying skills
            deepCopy.getSkills().add("C++");
            System.out.println("Deep Copy : " + deepCopy.getName() + ", Skills: " + deepCopy.getSkills());
            System.out.println("Employee (After deep copy): " + originalEmployee.getName() + ", Skills: " + originalEmployee.getSkills());
            
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
