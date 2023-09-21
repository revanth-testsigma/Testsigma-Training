public class Client {
    private int ClientId;
    private String Request;
    
    public Client(int clientId, String request) {
        this.ClientId = clientId;
        this.Request = request;
    }
    public int getClientId() {
        return ClientId;
    }
    public String getRequest() {
        return Request;
    }
    
}
