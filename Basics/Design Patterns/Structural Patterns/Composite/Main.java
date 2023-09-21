public class Main {
    public static void main(String[] args) {
        // Creating childs
        Person rev = new Child("Revanth");
        Person ammu = new Child("Ammu");
        Person bhar = new Child("Bharath");

        // Creating parents
        Parent Sri = new Parent("Sri");
        Sri.add(rev);
        Sri.add(bhar);

        Parent Sur = new Parent("Sur");
        Sur.add(bhar);

        // Display the contents of folder1
        Sri.display();
        Sur.display();
    }
}
