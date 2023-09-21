public class Main {
    public static void main(String[] args) {

        Socket socket = new Socket();

        Connecter Indian = new Indian(socket);
        Connecter America = new America(socket);
        Connecter France = new France(socket);

        Indian.convert("type B");
        Indian.con("Mobile");

        America.convert("type A");
        America.con("Laptop");

        France.convert("type C");
        France.con("Fan");
        
    }
}
