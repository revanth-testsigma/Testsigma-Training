class Manager implements Runnable {
    private Server server;

    public Manager(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.process();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
