public class BrandBLock extends Lock {
    private String material;
    private String lockType; // e.g., "Deadbolt", "Knob"

    public BrandBLock(String material, String lockType) {
        this.material = material;
        this.lockType = lockType;
    }

    @Override
    public void showInfo() {
        System.out.println("Brand B Lock - Material: " + material + ", Type: " + lockType + ", Power Usage: " + powerUsage + " watts");
    }
}