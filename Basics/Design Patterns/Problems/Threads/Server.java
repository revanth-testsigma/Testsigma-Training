import java.util.LinkedList;
import java.util.Queue;

class Server {
    private Queue<Client> clientQueue = new LinkedList<>();

    public synchronized void addClient(Client client) {
        clientQueue.add(client);
        System.out.println("Added client " + client.getClientId() + " to the queue.");
        notify(); // Notifing the worker thread that a new client is available.
    }

    public synchronized void process() throws InterruptedException {
        while (clientQueue.isEmpty()) {
            System.out.println("Server is waiting for clients...");
            wait(); // Wait for client to be added to the queue.
        }

        Client currentClient = clientQueue.poll();
        System.out.println("Processing client " + currentClient.getClientId() + " request : " + currentClient.getRequest());

        Thread.sleep(2000); // Simulate processing.
    }
}
