public class PrinterAdapter implements AdvancedPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String data) {
        oldPrinter.printData(data);
    }

    @Override
    public void loadPaperTray(int pages) {
        oldPrinter.loadPaper(pages);
    }

    @Override
    public void turnOn() {
        System.out.println("Adapter: Turning on the printer.");
    }

    @Override
    public void turnOff() {
        oldPrinter.turnOff();
    }
}
