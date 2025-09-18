public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

interface SmartBulb {
    float powerUsage;
    String colour;
    int wattage;

    void setBrightness();

    void turnon();

    void turnOff();

    float setPowerUsage(String file);

}

interface SmartLock {

    void lock();

    void Unlock();

    void autoLock();
}

interface SmartDeviceFactory {
    SmartBulb createSmartBulb();

    SmartLock createSmartLock();
}

// BrandA implementations
class BrandABulb implements SmartBulb {
    public void turnOn() {
        System.out.println("BrandA Bulb turned on.");
    }
}

class BrandALock implements SmartLock {
    public void turnOn() {
        System.out.println("BrandA Lock unlocked.");
    }
}

// BrandB implementations
class BrandBBulb implements SmartBulb {
    public void turnOn() {
        System.out.println("BrandB Bulb turned on.");
    }
}

class BrandBLock implements SmartLock {
    public void turnOn() {
        System.out.println("BrandB Lock unlocked.");
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