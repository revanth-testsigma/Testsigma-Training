public class DVD implements Device {
    private boolean on;
    private int volume;
    private int chapter;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("DVD: Power ON");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("DVD: Power OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("DVD: Volume set to " + volume);
    }

    @Override
    public int getChannel() {
        return chapter;
    }

    @Override
    public void setChannel(int chapter) {
        this.chapter = chapter;
        System.out.println("DVD: Channel set to " + chapter);
    }
}
