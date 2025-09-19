public class BrandAFactory implements SmartDeviceFactory {
    @Override
    public Bulb createBulb(String color, int brightness) {
        return new BrandABulb(color, brightness);
    }

    @Override
    public Lock createLock(String material, String type) {
        return new BrandALock(material, type);
    }
}