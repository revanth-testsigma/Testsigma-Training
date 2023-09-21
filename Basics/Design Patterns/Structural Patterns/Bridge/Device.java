public interface Device {
    void powerOn();
    void powerOff();
    int getVolume();
    void setVolume(int volume);
    int getChannel();
    void setChannel(int channel);
}
