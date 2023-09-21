public class Indian implements Connecter {
    private Socket socket;

    public Indian(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void convert(String type) {
        System.out.println("Converting Indian "+type+" to global.");
    }
    @Override
    public void con(String device) {
        socket.connect(device);
    }
}
