public class Main {
    public static void main(String[] args) {
        
        ComputerBuilderDirector director = new ComputerBuilderDirector();
        Computer Gaming = director.constructGamingComputer();
        Computer Office = director.constructOfficeComputer();

        System.out.println("Gaming Computer details:");
        System.out.println("Processor: " + Gaming.getProcessor());
        System.out.println("RAM: " + Gaming.getRam() + " GB");
        System.out.println("Storage: " + Gaming.getStorage() + " GB");
        System.out.println("Has Graphics Card: " + Gaming.hasGraphicsCard());
        System.out.println("----------------------------------");
        System.out.println("Office Computer details:");
        System.out.println("Processor: " + Office.getProcessor());
        System.out.println("RAM: " + Office.getRam() + " GB");
        System.out.println("Storage: " + Office.getStorage() + " GB");
    }
}
