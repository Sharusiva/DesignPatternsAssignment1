
public class App {
    public static void main(String[] args) throws Exception {
        // Demonstrate BrandABulb
        // Create BrandA devices using factory
        SmartDeviceFactory brandAFactory = new BrandAFactory();
        SmartBulb bulbA = brandAFactory.createSmartBulb();
        SmartLock lockA = brandAFactory.createSmartLock();

        System.out.println("=== Testing BrandA Devices ===");
        bulbA.turnOn();
        bulbA.setBrightness();
        System.out.println("BrandA Bulb power usage: " + bulbA.setPowerUsage("dummyFile") + "W");
        bulbA.turnOff();

        lockA.unlock();
        System.out.println("BrandA Lock status (unlocked): " + lockA.lockStatus);
        lockA.lock();
        System.out.println("BrandA Lock status (locked): " + lockA.lockStatus);
        lockA.autoLock();
        System.out.println("BrandA Lock status (auto-locked): " + lockA.lockStatus);
        lockA.setBatteryConsumption("dummyFile");
        System.out.println("BrandA Lock battery: " + lockA.getBatteryConsumption() + "%");

        System.out.println("\n=== Testing BrandB Devices ===");
        // Create BrandB devices using factory
        SmartDeviceFactory brandBFactory = new BrandBFactory();
        SmartBulb bulbB = brandBFactory.createSmartBulb();
        SmartLock lockB = brandBFactory.createSmartLock();

        bulbB.turnOn();
        bulbB.setBrightness();
        System.out.println("BrandA Bulb power usage: " + bulbA.setPowerUsage("dummyFile") + "W");
        bulbB.turnOff();

        lockB.unlock();
        System.out.println("BrandB Lock status (unlocked): " + lockB.lockStatus);
        lockB.lock();
        System.out.println("BrandB Lock status (locked): " + lockB.lockStatus);
        lockB.autoLock();
        System.out.println("BrandB Lock status (auto-locked): " + lockB.lockStatus);
        lockB.setBatteryConsumption("dummyFile");
        System.out.println("BrandB Lock battery: " + lockB.getBatteryConsumption() + "%");

    }
}

abstract class SmartBulb {
    float powerUsage;
    String colour;
    int wattage;

    abstract float setPowerUsage(String file);

    public float getPowerUsage() {
        return powerUsage;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    abstract void setBrightness();

    abstract void turnOn();

    abstract void turnOff();

}

abstract class SmartLock {
    float batteryConsumption;
    String connectivity;
    boolean lockStatus; // lock is initially unlocked

    void lock() {
        lockStatus = true;
    }

    void unlock() {
        lockStatus = false;
    }

    abstract void autoLock();

    abstract float setBatteryConsumption(String file);

    public float getBatteryConsumption() {
        return batteryConsumption;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }
}

interface SmartDeviceFactory {
    SmartBulb createSmartBulb();

    SmartLock createSmartLock();
}

// BrandA implementations
class BrandABulb extends SmartBulb {

    public BrandABulb() {
        this.powerUsage = 25;
        this.colour = "Warm White";
    }

    @Override
    public void turnOn() {
        System.out.println("BrandA Bulb turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("BrandA Bulb turned off.");
    }

    @Override
    public void setBrightness() {
        System.out.println("BrandA Bulb brightness set.");
    }

    @Override
    public float setPowerUsage(String file) {
        this.powerUsage = 56.0f;
        return this.powerUsage;
    }

}

class BrandALock extends SmartLock {

    public BrandALock() {
        this.connectivity = "Bluetooth";
    }

    @Override
    public void unlock() {
        super.unlock();
        System.out.println("BrandA Lock unlocked.");
    }

    @Override
    public void lock() {
        super.lock();
        System.out.println("BrandA Lock locked.");
    }

    @Override
    public void autoLock() {
        System.out.println("BrandA Lock auto-locked.");
    }

    @Override
    public float setBatteryConsumption(String file) {
        // Pretend to read from file
        this.batteryConsumption = 80.0f; // %
        return this.batteryConsumption;
    }
}

// BrandB implementations
class BrandBBulb extends SmartBulb {

    public BrandBBulb() {
        this.powerUsage = 10.0f; // watts
        this.colour = "Cool White";
    }

    @Override
    public void turnOn() {
        System.out.println("BrandB Bulb turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("BrandB Bulb turned off.");
    }

    @Override
    public void setBrightness() {
        System.out.println("BrandB Bulb brightness set.");
    }

    @Override
    public float setPowerUsage(String file) {
        this.powerUsage = 12.0f;
        return this.powerUsage;
    }
}

class BrandBLock extends SmartLock {
    @Override
    public void unlock() {
        super.unlock();
        System.out.println("BrandB Lock unlocked.");
    }

    @Override
    public void lock() {
        super.lock();
        System.out.println("BrandB Lock locked.");
    }

    @Override
    public void autoLock() {
        System.out.println("BrandB Lock auto-locked.");
    }

    @Override
    public float setBatteryConsumption(String file) {
        this.batteryConsumption = 60.0f; // %
        return this.batteryConsumption;
    }
}

// BrandA Factory
class BrandAFactory implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb() {
        return new BrandABulb();
    }

    @Override
    public SmartLock createSmartLock() {
        return new BrandALock();
    }
}

// BrandB Factory
class BrandBFactory implements SmartDeviceFactory {
    @Override
    public SmartBulb createSmartBulb() {
        return new BrandBBulb();
    }

    @Override
    public SmartLock createSmartLock() {
        return new BrandBLock();
    }
}