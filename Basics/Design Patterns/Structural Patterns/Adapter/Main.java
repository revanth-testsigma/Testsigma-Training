public class Main {
    public static void main(String[] args) {
        // Using the OldPrinter with the Adapter to make it work with the Advanced Printer interface
        OldPrinter oldPrinter = new OldPrinter();
        AdvancedPrinter modernPrinter = new PrinterAdapter(oldPrinter);

        // Calling the modern methods through the adapter
        modernPrinter.turnOn();
        modernPrinter.print("Hello, I am Revanth Pavuluri !");
        modernPrinter.loadPaperTray(3);
        modernPrinter.turnOff();
    }
}
