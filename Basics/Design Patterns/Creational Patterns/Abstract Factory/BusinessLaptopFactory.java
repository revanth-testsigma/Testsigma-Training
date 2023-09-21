// BusinessLaptopFactory.java
class BusinessLaptopFactory implements LaptopFactory {
    @Override
    public Laptop createLaptop() {
        return new BusinessLaptop();
    }

    @Override
    public Accessory createAccessory() {
        return new LaptopBag();
    }
}