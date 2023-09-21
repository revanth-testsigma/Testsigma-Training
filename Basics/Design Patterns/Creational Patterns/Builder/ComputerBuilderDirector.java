public class ComputerBuilderDirector {
    public Computer constructGamingComputer() {
        return new Computer.Builder()
                .setProcessor("Intel Core i9")
                .setRam(32)
                .setStorage(1024)
                .setGraphicsCard(true)
                .build();
    }

    public Computer constructOfficeComputer() {
        return new Computer.Builder()
                .setProcessor("Intel Core i5")
                .setRam(8)
                .setStorage(512)
                .build();
    }
}
