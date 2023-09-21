class GamingLaptopFactory implements LaptopFactory {
    @Override
    public Laptop createLaptop() {
        return new GamingLaptop();
    }

    @Override
    public Accessory createAccessory() {
        return new GamingMouse();
    }
}
