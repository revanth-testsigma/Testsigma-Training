public class Singleton {
    private static final Singleton instance = new Singleton();

    private int data;
    private String message;

    // Private constructor to prevent external instantiation
    private Singleton() {
        data = 0;
        message = "Hello, I am Revanth;";
    }

    // Public static method to get the instance
    public static Singleton getInstance() {
        return instance;
    }

    // Getter and setter
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void displayMessage() {
        System.out.println(message);
    }
}
