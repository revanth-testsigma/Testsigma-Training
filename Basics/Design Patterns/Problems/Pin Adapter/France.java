public class France implements Connecter {
    private Socket socket;

    public France(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void convert(String type) {
        System.out.println("Converting French "+type+" to global.");
    }
    @Override
    public void con(String device) {
        socket.connect(device);
    }
}
