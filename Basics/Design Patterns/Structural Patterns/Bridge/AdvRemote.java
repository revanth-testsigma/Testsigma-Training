public class AdvRemote extends BasicRemote {
    public AdvRemote(Device device) {
        super(device);
    }

    public void mute() {
        int prevVolume = device.getVolume();
        device.setVolume(0);
        System.out.println("Advanced Remote: Volume Muted (Previous Volume: " + prevVolume + ")");
    }
}
