public class Main {
    public static void main(String[] args) {
        //Devices
        Device tv = new TV();
        Device dvd = new DVD();

        //Remotes
        Remote tvRemote = new BasicRemote(tv);
        Remote dvdRemote = new BasicRemote(dvd);
        AdvRemote tvAdRemote = new AdvRemote(tv);
        AdvRemote dvdAdRemote = new AdvRemote(dvd);


        // Use the remote controls to operate the devices
        tvRemote.powerOn();
        tvRemote.volumeUp();
        tvRemote.channelUp();
        tvRemote.powerOff();

        System.out.println("----------------");

        dvdRemote.powerOn();
        dvdRemote.volumeUp();
        dvdRemote.channelUp();
        dvdRemote.powerOff();

        System.out.println("----------------");

        tvAdRemote.powerOn();
        tvAdRemote.volumeUp();
        tvAdRemote.mute();
        tvAdRemote.powerOff();
    }
}
