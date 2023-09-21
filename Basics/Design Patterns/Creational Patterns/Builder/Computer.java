public class Computer {
    //private variables
    private String processor;
    private int ram;
    private int storage;
    private boolean hasGraphicsCard;

    // Constructor (private to prevent direct instantiation)
    private Computer() {
    }

    // Getters for computer properties
    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public boolean hasGraphicsCard() {
        return hasGraphicsCard;
    }

    // Nested Builder class
    public static class Builder {
        private String processor;
        private int ram;
        private int storage;
        private boolean hasGraphicsCard;

        // Setters for computer properties in the Builder class
        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        // Build method to create the Computer instance
        public Computer build() {
            Computer computer = new Computer();
            computer.processor = this.processor;
            computer.ram = this.ram;
            computer.storage = this.storage;
            computer.hasGraphicsCard = this.hasGraphicsCard;
            return computer;
        }
    }
}
