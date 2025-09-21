
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

        System.out.println("\n=== Testing BrandB Devices ===");
        // Create BrandB devices using factory
        SmartDeviceFactory brandBFactory = new BrandBFactory();
        SmartBulb bulbB = brandBFactory.createSmartBulb();
        SmartLock lockB = brandBFactory.createSmartLock();

        bulbB.turnOn();
        bulbB.setBrightness();
        System.out.println("BrandB Bulb power usage: " + bulbB.setPowerUsage("dummyFile") + "W");
        bulbB.turnOff();

        lockB.unlock();
        System.out.println("BrandB Lock status (unlocked): " + lockB.lockStatus);
        lockB.lock();
        System.out.println("BrandB Lock status (locked): " + lockB.lockStatus);
        lockB.autoLock();
        System.out.println("BrandB Lock status (auto-locked): " + lockB.lockStatus);

    }
}

abstract class SmartBulb {
    float powerUsage;
    String colour;
    int wattage;

    abstract void setBrightness();

    abstract void turnOn();

    abstract void turnOff();

    abstract float setPowerUsage(String file);

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
}

interface SmartDeviceFactory {
    SmartBulb createSmartBulb();

    SmartLock createSmartLock();
}

// BrandA implementations
class BrandABulb extends SmartBulb {

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
        return 56.0f;
    }

}

class BrandALock extends SmartLock {
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
}

// BrandB implementations
class BrandBBulb extends SmartBulb {

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
        return 12.0f;
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
}

// BrandA Factory
class BrandAFactory implements SmartDeviceFactory {
    public SmartBulb createSmartBulb() {
        return new BrandABulb();
    }

    public SmartLock createSmartLock() {
        return new BrandALock();
    }
}

// BrandB Factory
class BrandBFactory implements SmartDeviceFactory {
    public SmartBulb createSmartBulb() {
        return new BrandBBulb();
    }

    public SmartLock createSmartLock() {
        return new BrandBLock();
    }
}