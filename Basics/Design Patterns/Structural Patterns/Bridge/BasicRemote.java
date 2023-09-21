public class BasicRemote implements Remote {
    //protected keyword is an access modifier used for attributes, methods and constructors, making them accessible in the same package and subclasses
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void powerOn() {
        System.out.println("Remote: Power ON");
        device.powerOn();
    }

    @Override
    public void powerOff() {
        System.out.println("Remote: Power OFF");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: Volume UP");
        device.setVolume(device.getVolume() + 5);
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: Volume DOWN");
        device.setVolume(device.getVolume() - 5);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: Channel UP");
        device.setChannel(device.getChannel() + 1);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: Channel DOWN");
        device.setChannel(device.getChannel() - 1);
    }
}
