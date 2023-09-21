public class America implements Connecter {
    private Socket socket;

    public America(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void convert(String type) {
        System.out.println("Converting American "+type+" to global.");
    }
    @Override
    public void con(String device) {
        socket.connect(device);
    }
}
