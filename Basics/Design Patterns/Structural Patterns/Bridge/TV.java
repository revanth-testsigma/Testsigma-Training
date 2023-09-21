public class TV implements Device {
    private boolean on;
    private int volume;
    private int channel;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("TV: Power ON");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("TV: Power OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("TV: Volume set to " + volume);
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV: Channel set to " + channel);
    }
}
