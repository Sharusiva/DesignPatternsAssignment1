public interface SmartDeviceFactory {
    Bulb createBulb(String color, int brightness);
    Lock createLock(String material, String type);

}