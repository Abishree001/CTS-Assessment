public class BuilderPattern {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
            .setStorage("256GB SSD")
            .setOperatingSystem("Windows 10")
            .build();

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4080")
            .setOperatingSystem("Windows 11 Pro")
            .build();

        System.out.println("Basic Configuration:\n" + basicComputer);
        System.out.println("\n Gaming Configuration:\n" + gamingComputer);
    }
}
