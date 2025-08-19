public class Spaceship {
    private String name;
    private int capacity;
    private Cargo[] cargoItems;
    private int cargoCount;
    private int currentWeight;
    
    public Spaceship(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.cargoItems = new Cargo[100];
        this.cargoCount = 0;
        this.currentWeight = 0;
    }
    
    public void loadCargo(Cargo cargo) {
        if (cargoCount < 100) {
            if (currentWeight + cargo.getWeight() <= capacity) {
                cargoItems[cargoCount] = cargo;
                cargoCount++;
                currentWeight += cargo.getWeight();
            } else {
                int excess = (currentWeight + cargo.getWeight()) - capacity;
                System.out.println("Warning: Unable to load " + cargo.getName() + " inside " + name + ". Exceeds capacity by " + excess + ".");
            }
        }
    }
    
    public void displayDetails() {
        System.out.println("Spaceship Name: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Cargo Weight: " + currentWeight);
        System.out.print("Cargo:");
        for (int i = 0; i < cargoCount; i++) {
            System.out.print(cargoItems[i].getName() + " ");
        }
        System.out.println();
    }
}
