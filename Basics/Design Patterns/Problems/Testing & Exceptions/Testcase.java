class err extends Exception {
    public err(String message) {
        super(message);
    }
}

abstract class Testcase {
    public abstract String run(int num) throws err;
}