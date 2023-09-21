public class Main {
    public static void main(String[] args) {
        // Creating a Gaming Laptop and its accessory using GamingLaptopFactory

        //interface variable = new class implementing interface
        LaptopFactory gamingLaptopFactory = new GamingLaptopFactory();
        //abstract class variable  = var.overriden method
        Laptop gamingLaptop = gamingLaptopFactory.createLaptop();
        Accessory gamingAccessory = gamingLaptopFactory.createAccessory();

        System.out.println("Gaming Setup:");
        System.out.println(gamingLaptop.getLaptopDescription());
        System.out.println(gamingAccessory.getAccessoryDescription());

        System.out.println("-----------------------");

        // Createing a Business Laptop and its accessory using BusinessLaptopFactory
        LaptopFactory businessLaptopFactory = new BusinessLaptopFactory();
        Laptop businessLaptop = businessLaptopFactory.createLaptop();
        Accessory businessAccessory = businessLaptopFactory.createAccessory();

        System.out.println("Business Setup:");
        System.out.println(businessLaptop.getLaptopDescription());
        System.out.println(businessAccessory.getAccessoryDescription());
    }
}
