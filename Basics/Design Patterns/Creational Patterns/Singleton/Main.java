public class Main {
    public static void main(String[] args) {
        //Singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Checking if both instances refer to the same object
        System.out.println(singleton1 == singleton2); // Output: true

        // Set data in one instance
        singleton1.setData(42);

        // Access data in another instance
        System.out.println(singleton2.getData());
        singleton1.setData(45);
        System.out.println(singleton1.getData());
        // Display the message using the second instance
        singleton2.displayMessage();
    }
}
