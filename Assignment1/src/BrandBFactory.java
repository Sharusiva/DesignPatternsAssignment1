public class BrandBFactory implements SmartDeviceFactory {
    @Override
    public Bulb createBulb(String color, int brightness) {
        return new BrandBBulb(color, brightness);
    }

    @Override
    public Lock createLock(String material, String type) {
        return new BrandBLock(material, type);
    }
}