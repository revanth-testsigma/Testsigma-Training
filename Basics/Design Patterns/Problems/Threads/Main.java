import java.util.LinkedList;
import java.util.Queue;




public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        Manager Manager = new Manager(server);

        Thread ManagerThread = new Thread(Manager);
        ManagerThread.start();

        // Simulate adding client to the Server queue
        for (int i = 1; i <= 5; i++) {
            Client job = new Client(i, "Request for " + i);
            server.addClient(job);

            try {
                Thread.sleep(1000); // delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
