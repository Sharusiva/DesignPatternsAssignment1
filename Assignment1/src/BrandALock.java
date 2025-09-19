public class BrandALock extends Lock {
    private String material;
    private String lockType; // e.g., "Deadbolt", "Knob"

    public BrandALock(String material, String lockType) {
        this.material = material;
        this.lockType = lockType;
    }

    @Override
    public void showInfo() {
        System.out.println("Brand A Lock - Material: " + material + ", Type: " + lockType + ", Power Usage: " + powerUsage + " watts");
    }
}